package com.newtong.shortlink.admin.common.biz.user;

import com.alibaba.fastjson2.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author NewTong
 * @Date 2024/8/2 -8:38
 * @Description
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserInfoDTO {

    /**
     * @Author NewTong
     * @Date 8:39 2024/8/2
     * @Description 用户ID
     */
    @JSONField(name = "id")
    private String userId;

    /**
     * @Author NewTong
     * @Date 8:39 2024/8/2
     * @Description 用户名
     */
    private String username;

    /**
     * @Author NewTong
     * @Date 8:39 2024/8/2
     * @Description 真实姓名
     */
    private String realName;

    /**
     * @Author NewTong
     * @Date 8:39 2024/8/2
     * @Description 登录token
     */
    private String token;
}
