package com.newtong.shortlink.admin.controller;

import com.newtong.shortlink.admin.common.convention.result.Result;
import com.newtong.shortlink.admin.common.convention.result.Results;
import com.newtong.shortlink.admin.dto.req.GroupSaveReqDTO;
import com.newtong.shortlink.admin.service.GroupDOService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/create")
    public Result<Void> createGroup(@RequestBody GroupSaveReqDTO requestParam) {
        groupDOService.saveGroup(requestParam.getGroupName());
        return Results.success();
    }

}
