package com.newtong.shortlink.admin.common.enums;

import com.newtong.shortlink.admin.common.convention.errorcode.IErrorCode;

/**
 * @author NewTong
 * @Date 2024/7/29 -21:11
 * @Description
 */
public enum UserErrorCodeEnum implements IErrorCode {

    USER_REGISTER_ERROR("A0100", "用户注册错误"),
    USER_NAME_VERIFY_ERROR("A0110", "用户名校验失败"),
    USER_NAME_EXIST_ERROR("A0111", "用户名已存在"),
    USER_NAME_SENSITIVE_ERROR("A0112", "用户名包含敏感词"),
    USER_NAME_SPECIAL_CHARACTER_ERROR("A0113", "用户名包含特殊字符"),
    USER_NAME_NULL_ERROR("A0114", "用户名不能为空"),
    USER_LOGIN_ERROR("A0120", "用户登录错误"),
    USER_LOGIN_PASSWORD_ERROR("A0121", "用户密码错误"),
    USER_LOGIN_USERNAME_ERROR("A0122", "用户名错误"),
    USER_LOGIN_USERNAME_NULL_ERROR("A0123", "用户名不能为空"),
    USER_LOGIN_PASSWORD_NULL_ERROR("A0124", "用户密码不能为空"),
    USER_LOGIN_USERNAME_NOT_EXIST_ERROR("A0125", "用户不存在"),
    USER_LOGIN_EXIST_ERROR("A0126", "用户已经登录"),
    PASSWORD_VERIFY_ERROR("A0220", "密码校验失败"),
    PASSWORD_SHORT_ERROR("A0221", "密码长度不够"),
    PHONE_VERIFY_ERROR("A0351", "手机格式校验失败"),
    REMOTE_ERROR("C0001", "调用第三方服务出错"),
    SERVICE_ERROR("B0001", "系统执行出错"),
    SERVICE_TIMEOUT_ERROR("B0100", "系统执行超时"),
    USER_NULL_ERROR("B0201", "用户记录不存在"),
    IDEMPOTENT_TOKEN_NULL_ERROR("A0201", "幂等Token为空"),
    IDEMPOTENT_TOKEN_DELETE_ERROR("A0202", "幂等Token已被使用或失效");

    UserErrorCodeEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    private final String code;
    private final String message;

    @Override
    public String code() {
        return code;
    }

    @Override
    public String message() {
        return message;
    }
}
