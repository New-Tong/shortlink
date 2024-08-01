package com.newtong.shortlink.admin.dto.req;

import lombok.Data;

/**
 * @author NewTong
 * @Date 2024/8/1 -9:56
 * @Description
 */
@Data
public class UserUpdateReqDTO {
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
