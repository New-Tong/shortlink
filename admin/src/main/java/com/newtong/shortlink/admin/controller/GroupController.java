package com.newtong.shortlink.admin.controller;

import com.newtong.shortlink.admin.service.GroupDOService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author NewTong
 * @Date 2024/8/1 -18:05
 * @Description 短链接分组控制层
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/short-link/admin/v1/group")
public class GroupController {
    private final GroupDOService groupDOService;

}
