package com.newtong.shortlink.project.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.newtong.shortlink.project.common.convention.result.Result;
import com.newtong.shortlink.project.common.convention.result.Results;
import com.newtong.shortlink.project.dto.req.ShortLinkCreateReqDTO;
import com.newtong.shortlink.project.dto.req.ShortLinkPageReqDTO;
import com.newtong.shortlink.project.dto.resp.ShortLinkCreateRespDTO;
import com.newtong.shortlink.project.dto.resp.ShortLinkPageRespDTO;
import com.newtong.shortlink.project.service.ShortLinkService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * @author NewTong
 * @Date 2024/8/3 -13:24
 * @Description
 */
@RestController
@RequestMapping("/api/short-link/v1")
@RequiredArgsConstructor
public class ShortLinkController {

    private final ShortLinkService shortLinkService;


    @PostMapping("/create")
    public Result<ShortLinkCreateRespDTO> createShortLink(@RequestBody ShortLinkCreateReqDTO requestParam) {
        return Results.success(shortLinkService.createShortLink(requestParam));
    }

    @GetMapping("/page")
    public Result<IPage<ShortLinkPageRespDTO> > getShortLinkPage(ShortLinkPageReqDTO requestParam) {
        return Results.success(shortLinkService.getShortLinkPage(requestParam));
    }
}
