package com.newtong.shortlink.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.newtong.shortlink.admin.common.convention.exception.ClientException;
import com.newtong.shortlink.admin.common.convention.exception.ServiceException;
import com.newtong.shortlink.admin.common.enums.UserErrorCodeEnum;
import com.newtong.shortlink.admin.dao.entity.UserDO;
import com.newtong.shortlink.admin.dto.resp.UserRespDTO;
import com.newtong.shortlink.admin.service.UserDOService;
import com.newtong.shortlink.admin.dao.mapper.UserDOMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

/**
* @author hp
* @description 针对表【t_user】的数据库操作Service实现
* @createDate 2024-07-29 17:43:17
*/
@Service
public class UserDOServiceImpl extends ServiceImpl<UserDOMapper, UserDO>
    implements UserDOService{

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
}
