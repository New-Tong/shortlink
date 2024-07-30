package com.newtong.shortlink.admin.controller;

import com.newtong.shortlink.admin.common.convention.exception.ServiceException;
import com.newtong.shortlink.admin.common.convention.result.Result;
import com.newtong.shortlink.admin.common.convention.result.Results;
import com.newtong.shortlink.admin.common.enums.UserErrorCodeEnum;
import com.newtong.shortlink.admin.dto.resp.UserRespDTO;
import com.newtong.shortlink.admin.service.UserDOService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author NewTong
 * @Date 2024/7/29 -17:07
 * @Description 用户管理控制层
 */

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/short-link/admin/v1/user")
public class UserController {
    private final UserDOService userDOService;

    /**
     * @Author NewTong
     * @Date 17:10 2024/7/29
     * @Description 根据用户名查询用户信息
     */
    @GetMapping("/{username}")
    public Result getUserByUsername(@PathVariable("username") String username) {
        return Results.success(userDOService.getUserByUsername(username));
    }

}
