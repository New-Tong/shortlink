package com.newtong.shortlink.admin.dto.req;

import lombok.Data;

/**
 * @author NewTong
 * @Date 2024/8/2 -10:04
 * @Description
 */
@Data
public class GroupUpdateReqDTO {

    /**
     * @Author NewTong
     * @Date 10:04 2024/8/2
     * @Description 分组标识
     */
    private String gid;

    /**
     * @Author NewTong
     * @Date 10:04 2024/8/2
     * @Description 分组名称
     */
    private String groupName;
}
