package com.newtong.shortlink.admin.dto.req;

import lombok.Data;

/**
 * @author NewTong
 * @Date 2024/8/1 -10:38
 * @Description
 */
@Data
public class UserLoginReqDTO {
    /**
     * @Author NewTong
     * @Date 10:43 2024/8/1
     * @Description 用户名
     */
    private String username;

    /**
     * @Author NewTong
     * @Date 10:43 2024/8/1
     * @Description 密码
     */
    private String password;
}
