package com.newtong.shortlink.admin.dto.resp;

import lombok.Data;

/**
 * @author NewTong
 * @Date 2024/7/29 -19:43
 * @Description 用户返回参数响应实体
 */
@Data
public class UserRespDTO {

    /**
     * id
     */
    private Long id;

    /**
     * 用户名
     */
    private String username;

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
