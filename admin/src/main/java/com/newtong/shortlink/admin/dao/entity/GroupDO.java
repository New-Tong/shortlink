package com.newtong.shortlink.admin.dao.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.newtong.shortlink.admin.common.database.BaseDO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

/**
 * @author NewTong
 * @Date 2024/8/1 -17:43
 * @Description
 */
@Data
@TableName("t_group")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GroupDO extends BaseDO {
    private static final long serialVersionUID = 1L;

    /**
     * 主键，唯一id
     */
    private Long id;

    /**
     * 分组标识
     */
    private String gid;

    /**
     * 分组名称
     */
    private String groupName;

    /**
     * 创建分组用户名
     */
    private String username;

}
