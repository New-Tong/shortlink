package com.newtong.shortlink.admin.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.alibaba.fastjson2.JSON;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.newtong.shortlink.admin.common.constant.RedisCacheConstant;
import com.newtong.shortlink.admin.common.convention.exception.ClientException;
import com.newtong.shortlink.admin.common.convention.exception.ServiceException;
import com.newtong.shortlink.admin.common.enums.UserErrorCodeEnum;
import com.newtong.shortlink.admin.dao.entity.UserDO;
import com.newtong.shortlink.admin.dto.req.UserLoginReqDTO;
import com.newtong.shortlink.admin.dto.req.UserRegisterReqDTO;
import com.newtong.shortlink.admin.dto.req.UserUpdateReqDTO;
import com.newtong.shortlink.admin.dto.resp.UserLoginRespDTO;
import com.newtong.shortlink.admin.dto.resp.UserRespDTO;
import com.newtong.shortlink.admin.service.UserService;
import com.newtong.shortlink.admin.dao.mapper.UserDOMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RBloomFilter;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.BeanUtils;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @author hp
 * @description 针对表【t_user】的数据库操作Service实现
 * @createDate 2024-07-29 17:43:17
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class UserServiceImpl extends ServiceImpl<UserDOMapper, UserDO>
        implements UserService {

    private final RBloomFilter<String> userRegisterCachePenetrationBloomFilter;
    private final RedissonClient redissonClient;
    private final StringRedisTemplate redisTemplate;
    private static final String token_prefix = RedisCacheConstant.USER_LOGIN_TOKEN_CACHE_KEY_PREFIX;


    @Override
    public UserRespDTO getUserByUsername(String username) {
        LambdaQueryWrapper<UserDO> wrapper = Wrappers.lambdaQuery(UserDO.class)
                .eq(UserDO::getUsername, username);
        UserDO userDO = baseMapper.selectOne(wrapper);
        UserRespDTO respDTO = new UserRespDTO();
        if (userDO == null) {
            throw new ServiceException(UserErrorCodeEnum.USER_NULL_ERROR);
        }
        BeanUtils.copyProperties(userDO, respDTO);
        return respDTO;
    }

    @Override
    public boolean hasUsername(String username) {
        return userRegisterCachePenetrationBloomFilter.contains(username);
    }

    @Override
    public void register(UserRegisterReqDTO requestParam) {
        if (hasUsername(requestParam.getUsername())) {
            throw new ClientException(UserErrorCodeEnum.USER_NAME_EXIST_ERROR);
        }
        RLock lock = redissonClient.getLock(RedisCacheConstant.LOCK_USER_REGISTER_CACHE_KEY + requestParam.getUsername());
        try {
            if (lock.tryLock()) {
                int inserted = baseMapper.insert(BeanUtil.toBean(requestParam, UserDO.class));
                if (inserted != 1) {
                    throw new ServiceException(UserErrorCodeEnum.USER_REGISTER_ERROR);
                }
                userRegisterCachePenetrationBloomFilter.add(requestParam.getUsername());
                return;
            }
            throw new ClientException(UserErrorCodeEnum.USER_NAME_EXIST_ERROR);
        } catch (Exception e) {
            throw new ServiceException(e.toString());
        } finally {
            lock.unlock();
        }
    }

    @Override
    public void update(UserUpdateReqDTO requestParam) {
        baseMapper.update(BeanUtil.toBean(requestParam, UserDO.class),
                Wrappers.lambdaUpdate(UserDO.class).eq(UserDO::getUsername, requestParam.getUsername()));
    }

    @Override
    public UserLoginRespDTO login(UserLoginReqDTO requestParam) {
        LambdaQueryWrapper<UserDO> queryWrapper = Wrappers.lambdaQuery(UserDO.class)
                .eq(UserDO::getUsername, requestParam.getUsername())
                .eq(UserDO::getPassword, requestParam.getPassword());
        UserDO userDO = baseMapper.selectOne(queryWrapper);
        if (userDO == null) {
            throw new ClientException(UserErrorCodeEnum.USER_LOGIN_USERNAME_NOT_EXIST_ERROR);
        }
        if (Boolean.TRUE.equals(redisTemplate.hasKey(token_prefix + userDO.getUsername()))) {
            throw new ClientException(UserErrorCodeEnum.USER_LOGIN_EXIST_ERROR);
        }
        String token = UUID.randomUUID().toString();
        redisTemplate.opsForHash().put(token_prefix + requestParam.getUsername(),
                token, JSON.toJSONString(userDO));
        redisTemplate.expire(token_prefix + requestParam.getUsername(),
                RedisCacheConstant.USER_LOGIN_TOKEN_CACHE_EXPIRE_TIME,
                RedisCacheConstant.USER_LOGIN_TOKEN_CACHE_TIME_UNIT);
        return new UserLoginRespDTO(token);
    }

    @Override
    public Boolean checkLogin(String username, String token) {
        Object redisToken = redisTemplate.opsForHash().get(token_prefix + username, token);
        return redisToken != null;
    }

    @Override
    public void logout(String username, String token) {
        if (checkLogin(username, token)) {
            redisTemplate.delete(token_prefix + username);
        } else {
            throw new ClientException(UserErrorCodeEnum.USER_LOGIN_NULL_ERROR);
        }
    }

    @Override
    public void delete(String username) {
        LambdaUpdateWrapper<UserDO> updateWrapper = Wrappers.lambdaUpdate(UserDO.class)
                .eq(UserDO::getUsername, username)
                .set(UserDO::getDeletionTime, System.currentTimeMillis());
        baseMapper.update(baseMapper.selectOne(updateWrapper), updateWrapper);
        baseMapper.delete(updateWrapper);
    }
}
