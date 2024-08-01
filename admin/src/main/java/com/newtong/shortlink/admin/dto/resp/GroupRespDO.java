package com.newtong.shortlink.admin.dto.resp;

import lombok.Data;

import java.io.Serializable;

/**
 * @author NewTong
 * @Date 2024/8/1 -20:27
 * @Description
 */
@Data
public class GroupRespDO implements Serializable {

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

    /**
     * 分组排序
     */
    private Integer sortOrder;

}
