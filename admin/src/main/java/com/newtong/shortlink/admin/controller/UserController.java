package com.newtong.shortlink.admin.controller;

import cn.hutool.core.bean.BeanUtil;
import com.newtong.shortlink.admin.common.convention.result.Result;
import com.newtong.shortlink.admin.common.convention.result.Results;
import com.newtong.shortlink.admin.dto.req.UserRegisterReqDTO;
import com.newtong.shortlink.admin.dto.resp.UserActualRespDTO;
import com.newtong.shortlink.admin.dto.resp.UserRespDTO;
import com.newtong.shortlink.admin.service.UserService;
import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * @author NewTong
 * @Date 2024/7/29 -17:07
 * @Description 用户管理控制层
 */

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/short-link/admin/v1/user")
public class UserController {
    private final UserService userService;

    /**
     * @Author NewTong
     * @Date 17:10 2024/7/29
     * @Description 根据用户名查询用户脱敏信息
     */
    @GetMapping("/{username}")
    public Result<UserRespDTO> getUserByUsername(@PathVariable("username") String username) {
        return Results.success(userService.getUserByUsername(username));
    }

    /**
     * @Author NewTong
     * @Date 17:10 2024/7/29
     * @Description 根据用户名查询用户脱敏信息
     */
    @GetMapping("/actual/{username}")
    public Result<UserActualRespDTO> getActualUserByUsername(@PathVariable("username") String username) {
        return Results.success(BeanUtil.toBean(userService.getUserByUsername(username), UserActualRespDTO.class));
    }

    /**
     * @Author NewTong
     * @Date 17:10 2024/7/29
     * @Description 查询用户名是否存在
     */
    @GetMapping("/has-username")
    public Result<Boolean> hasUsername(@RequestParam("username") String username) {
        return Results.success(!userService.hasUsername(username));
    }

    /**
     * @Author NewTong
     * @Date 15:35 2024/7/30
     * @Description 注册
     */
    @PostMapping("/register")
    public Result<Void> register(@RequestBody UserRegisterReqDTO requestParam) {
        userService.register(requestParam);
        return Results.success();
    }
}
