package com.newtong.shortlink.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.newtong.shortlink.admin.dao.entity.UserDO;
import com.newtong.shortlink.admin.dto.req.UserLoginReqDTO;
import com.newtong.shortlink.admin.dto.req.UserRegisterReqDTO;
import com.newtong.shortlink.admin.dto.req.UserUpdateReqDTO;
import com.newtong.shortlink.admin.dto.resp.UserLoginRespDTO;
import com.newtong.shortlink.admin.dto.resp.UserRespDTO;

/**
* @author NewTong
* @description 针对表【t_user】的数据库操作Service
* @createDate 2024-07-29 17:43:17
*/
public interface UserService extends IService<UserDO> {
    /**
     * @Description  根据用户名获取用户信息
     */
    UserRespDTO getUserByUsername(String username);

    /**
     * @Description 判断用户名是否已存在
     */
    boolean hasUsername(String username);

    /**
     * @Description 注册
     */
    void register(UserRegisterReqDTO requestParam);

    /**
     * @Description 根据用户名修改用户信息
     */
    void update(UserUpdateReqDTO requestParam);

    /**
     * @Description 用户登录
     */
    UserLoginRespDTO login(UserLoginReqDTO requestParam);

    /**
     * @Description 验证用户登录
     */
    Boolean checkLogin(String username, String token);

    /**
     * @Description 退出登录
     */
    void logout(String username, String token);
}
