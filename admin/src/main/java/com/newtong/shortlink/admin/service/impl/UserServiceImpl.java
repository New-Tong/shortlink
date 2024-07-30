package com.newtong.shortlink.admin.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.newtong.shortlink.admin.common.convention.exception.ClientException;
import com.newtong.shortlink.admin.common.convention.exception.ServiceException;
import com.newtong.shortlink.admin.common.enums.UserErrorCodeEnum;
import com.newtong.shortlink.admin.dao.entity.UserDO;
import com.newtong.shortlink.admin.dto.req.UserRegisterReqDTO;
import com.newtong.shortlink.admin.dto.resp.UserRespDTO;
import com.newtong.shortlink.admin.service.UserService;
import com.newtong.shortlink.admin.dao.mapper.UserDOMapper;
import lombok.RequiredArgsConstructor;
import org.redisson.api.RBloomFilter;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

/**
* @author hp
* @description 针对表【t_user】的数据库操作Service实现
* @createDate 2024-07-29 17:43:17
*/
@Service
@RequiredArgsConstructor
public class UserServiceImpl extends ServiceImpl<UserDOMapper, UserDO>
    implements UserService {

    private final RBloomFilter<String> userRegisterCachePenetrationBloomFilter;

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
    public void register(UserRegisterReqDTO userRegisterReqDTO) {
        if (hasUsername(userRegisterReqDTO.getUsername())) {
            throw new ClientException(UserErrorCodeEnum.USER_NAME_EXIST_ERROR);
        }
        int inserted = baseMapper.insert(BeanUtil.toBean(userRegisterReqDTO, UserDO.class));
        if (inserted != 1) {
            throw new ServiceException(UserErrorCodeEnum.USER_REGISTER_ERROR);
        }
        userRegisterCachePenetrationBloomFilter.add(userRegisterReqDTO.getUsername());
    }
}
