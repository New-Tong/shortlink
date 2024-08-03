package com.newtong.shortlink.project.controller;

import com.newtong.shortlink.project.common.convention.result.Result;
import com.newtong.shortlink.project.common.convention.result.Results;
import com.newtong.shortlink.project.dto.req.ShortLinkCreateReqDTO;
import com.newtong.shortlink.project.dto.resp.ShortLinkCreateRespDTO;
import com.newtong.shortlink.project.service.ShortLinkService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
