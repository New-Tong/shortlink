package com.newtong.shortlink.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.newtong.shortlink.admin.dao.entity.UserDO;
import com.newtong.shortlink.admin.dto.req.UserRegisterReqDTO;
import com.newtong.shortlink.admin.dto.resp.UserRespDTO;

/**
* @author NewTong
* @description 针对表【t_user】的数据库操作Service
* @createDate 2024-07-29 17:43:17
*/
public interface UserService extends IService<UserDO> {
    /**
     * @Param [username]
     * @return com.newtong.shortlink.admin.dto.resp.UserRespDTO
     * @Description  根据用户名获取用户信息
     */
    UserRespDTO getUserByUsername(String username);

    /**
     * @Param [username]
     * @return boolean
     * @Description 判断用户名是否已存在
     */
    boolean hasUsername(String username);

    /**
     * @Param [requestParam]
     * @return void
     * @Description 注册
     */
    void register(UserRegisterReqDTO requestParam);
}
