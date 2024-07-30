package com.newtong.shortlink.admin.dto.req;

import lombok.Data;

/**
 * @author NewTong
 * @Date 2024/7/30 -15:25
 * @Description 用户注册的请求参数
 */
@Data
public class UserRegisterReqDTO {
    /**
     * id
     */
    private Long id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 真实姓名
     */
    private String realName;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 邮箱
     */
    private String mail;
}
