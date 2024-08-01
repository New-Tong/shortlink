package com.newtong.shortlink.admin.dao.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author NewTong
 * @Date 2024/8/1 -17:43
 * @Description
 */
@Data
@TableName("t_group")
public class GroupDO implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 主键，唯一id
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 分组标识
     */
    private String gid;

    /**
     * 分组名称
     */
    private String name;

    /**
     * 创建分组用户名
     */
    private String username;

    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT, value = "create_time")
    private Date createTime;

    /**
     * 修改时间
     */
    @TableField(fill = FieldFill.INSERT_UPDATE, value = "update_time")
    private Date updateTime;

    /**
     * 删除标识 0：未删除 1：已删除
     */
    @TableLogic
    @TableField(fill = FieldFill.INSERT, value = "del_flag")
    private int delFlag;
}
