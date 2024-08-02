package com.newtong.shortlink.admin.dto.req;

import lombok.Data;

/**
 * @author NewTong
 * @Date 2024/8/2 -10:30
 * @Description
 */
@Data
public class GroupOrderReqDTO {
    /**
     * @Author NewTong
     * @Date 10:31 2024/8/2
     * @Description 分组ID
     */
    private String gid;

    /**
     * @Author NewTong
     * @Date 10:31 2024/8/2
     * @Description 排序等级
     */
    private Integer sortOrder;
}
