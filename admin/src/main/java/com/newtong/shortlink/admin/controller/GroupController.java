package com.newtong.shortlink.admin.controller;

import com.newtong.shortlink.admin.common.convention.result.Result;
import com.newtong.shortlink.admin.common.convention.result.Results;
import com.newtong.shortlink.admin.dto.req.GroupSaveReqDTO;
import com.newtong.shortlink.admin.dto.req.GroupUpdateReqDTO;
import com.newtong.shortlink.admin.dto.resp.GroupRespDO;
import com.newtong.shortlink.admin.service.GroupDOService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    /**
     * @Author NewTong
     * @Date 20:26 2024/8/1
     * @Description 创建短链接分组
     */
    @PostMapping("/create")
    public Result<Void> createGroup(@RequestBody GroupSaveReqDTO requestParam) {
        groupDOService.saveGroup(requestParam.getGroupName());
        return Results.success();
    }

    /**
     * @Author NewTong
     * @Date 20:27 2024/8/1
     * @Description 获取登录用户所有短链接分组
     */
    @GetMapping
    public Result<List<GroupRespDO>> getAllGroup() {
        List<GroupRespDO> groupRespDOList = groupDOService.getAllGroup();
        return Results.success(groupRespDOList);
    }

    /**
     * @Author NewTong
     * @Date 10:05 2024/8/2
     * @Description 修改短链接分组名
     */
    @PutMapping("/update")
    public Result<Void> updateGroup(@RequestBody GroupUpdateReqDTO requestParam) {
        groupDOService.updateGroup(requestParam);
        return Results.success();
    }

    /**
     * @Author NewTong
     * @Date 10:23 2024/8/2
     * @Description 删除短链接分组
     */
    @DeleteMapping("/delete")
    public Result<Void> deleteGroup(@RequestParam("gid") String gid) {
        groupDOService.deleteGroup(gid);
        return Results.success();
    }

}
