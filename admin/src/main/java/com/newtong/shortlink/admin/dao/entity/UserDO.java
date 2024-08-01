package com.newtong.shortlink.admin.dao.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.newtong.shortlink.admin.common.database.BaseDO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serial;
import java.io.Serializable;

/**
 * @author NewTong
 * @Date 2024/7/29 -17:45
 * @Description 用户持久层实体
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("t_user")
public class UserDO extends BaseDO {

    private static final long serialVersionUID = 1L;

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

    /**
     * 注销时间戳
     */
    private Long deletionTime;

}
