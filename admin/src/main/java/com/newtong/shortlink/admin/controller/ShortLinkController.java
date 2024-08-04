package com.newtong.shortlink.admin.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.newtong.shortlink.admin.common.convention.result.Result;
import com.newtong.shortlink.admin.remote.dto.ShortLinkRemoteService;
import com.newtong.shortlink.admin.remote.dto.req.ShortLinkCreateReqDTO;
import com.newtong.shortlink.admin.remote.dto.req.ShortLinkPageReqDTO;
import com.newtong.shortlink.admin.remote.dto.resp.ShortLinkCreateRespDTO;
import com.newtong.shortlink.admin.remote.dto.resp.ShortLinkPageRespDTO;
import org.springframework.web.bind.annotation.*;

/**
 * @author NewTong
 * @Date 2024/8/4 -14:57
 * @Description
 */
@RestController
@RequestMapping("/api/short-link/admin/v1")
public class ShortLinkController {

    /**
     * TODO 后续重构为 SpringCloud Feign调用
     */
    ShortLinkRemoteService shortLinkRemoteService = new ShortLinkRemoteService(){};

    /**
     * @Author NewTong
     * @Date 15:49 2024/8/4
     * @Description 后台管理系统获取短链列表
     */
    @GetMapping("/page")
    public Result<IPage<ShortLinkPageRespDTO>> getShortLinkPage(ShortLinkPageReqDTO requestParam) {
        return shortLinkRemoteService.getShortLinkPage(requestParam);
    }

    /**
     * @Author NewTong
     * @Date 15:49 2024/8/4
     * @Description 后台管理系统创建短链
     */
    @PostMapping("/create")
    public Result<ShortLinkCreateRespDTO> createShortLink(@RequestBody ShortLinkCreateReqDTO requestParam) {
        return shortLinkRemoteService.createShortLink(requestParam);
    }
}
