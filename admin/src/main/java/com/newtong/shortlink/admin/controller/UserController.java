package com.newtong.shortlink.admin.controller;

import cn.hutool.core.bean.BeanUtil;
import com.newtong.shortlink.admin.common.convention.result.Result;
import com.newtong.shortlink.admin.common.convention.result.Results;
import com.newtong.shortlink.admin.dto.req.UserLoginReqDTO;
import com.newtong.shortlink.admin.dto.req.UserRegisterReqDTO;
import com.newtong.shortlink.admin.dto.req.UserUpdateReqDTO;
import com.newtong.shortlink.admin.dto.resp.UserActualRespDTO;
import com.newtong.shortlink.admin.dto.resp.UserLoginRespDTO;
import com.newtong.shortlink.admin.dto.resp.UserRespDTO;
import com.newtong.shortlink.admin.service.UserService;
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

    /**
     * @Author NewTong
     * @Date 9:59 2024/8/1
     * @Description 更新用户信息
     */
    @PutMapping
    public Result<Void> update(@RequestBody UserUpdateReqDTO requestParam) {
        userService.update(requestParam);
        return Results.success();
    }

    /**
     * @Author NewTong
     * @Date 10:44 2024/8/1
     * @Description 登录
     */
    @PostMapping("/login")
    public Result<UserLoginRespDTO> login(@RequestBody UserLoginReqDTO requestParam) {
        return Results.success(userService.login(requestParam));
    }

    /**
     * @Author NewTong
     * @Date 17:02 2024/8/1
     * @Description 检查用户是否登录
     */
    @GetMapping("/check-login")
    public Result<Boolean> checkLogin(@RequestParam("username") String username, @RequestParam("token") String token) {
        return Results.success(userService.checkLogin(username, token));
    }

    /**
     * @Author NewTong
     * @Date 17:03 2024/8/1
     * @Description 用户退出登录
     */
    @DeleteMapping("/logout")
    public Result<Void> logout(@RequestParam("username") String username, @RequestParam("token") String token) {
        userService.logout(username, token);
        return Results.success();
    }

    @DeleteMapping("/deleteUser")
    public Result<Void> delete(@RequestParam("username") String username, @RequestParam("token") String token) {
        userService.logout(username, token);
        userService.delete(username);
        return Results.success();
    }
}
