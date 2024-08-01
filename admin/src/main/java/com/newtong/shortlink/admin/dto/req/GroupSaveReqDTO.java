package com.newtong.shortlink.admin.dto.req;

import lombok.Data;

/**
 * @author NewTong
 * @Date 2024/8/1 -20:03
 * @Description 短链接分组创建请求参数
 */
@Data
public class GroupSaveReqDTO {
    /**
     * 分组名称
     */
    private String groupName;
}
