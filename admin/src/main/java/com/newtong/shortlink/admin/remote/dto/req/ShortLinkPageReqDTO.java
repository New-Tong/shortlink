package com.newtong.shortlink.admin.remote.dto.req;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author NewTong
 * @Date 2024/8/4 -11:37
 * @Description 短链接分页请求参数
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ShortLinkPageReqDTO extends Page {
    /**
     * @Author NewTong
     * @Date 11:38 2024/8/4
     * @Description 分组标识
     */
    private String gid;

}
