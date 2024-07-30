package com.newtong.shortlink.admin.common.convention.errorcode;

/**
 * @author NewTong
 * @Date 2024/7/29 -21:08
 * @Description
 */
public enum BaseErrorCode implements IErrorCode{

    // ========== 一级宏观错误码 客户端错误 ==========
    CLIENT_ERROR("A0001", "用户端错误"),

    // ========== 二级宏观错误码 用户注册错误 ==========
    USER_REGISTER_ERROR("A0100", "用户注册错误"),
    USER_NAME_VERIFY_ERROR("A0110", "用户名校验失败"),
    USER_NAME_EXIST_ERROR("A0111", "用户名已存在"),
    USER_NAME_SENSITIVE_ERROR("A0112", "用户名包含敏感词"),
    USER_NAME_SPECIAL_CHARACTER_ERROR("A0113", "用户名包含特殊字符"),
    PASSWORD_VERIFY_ERROR("A0120", "密码校验失败"),
    PASSWORD_SHORT_ERROR("A0121", "密码长度不够"),
    PHONE_VERIFY_ERROR("A0151", "手机格式校验失败"),

    // ========== 二级宏观错误码 系统请求缺少幂等Token ==========
    IDEMPOTENT_TOKEN_NULL_ERROR("A0200", "幂等Token为空"),
    IDEMPOTENT_TOKEN_DELETE_ERROR("A0201", "幂等Token已被使用或失效"),

    // ========== 一级宏观错误码 系统执行出错 ==========
    SERVICE_ERROR("B0001", "系统执行出错"),
    // ========== 二级宏观错误码 系统执行超时 ==========
    SERVICE_TIMEOUT_ERROR("B0100", "系统执行超时"),

    // ========== 一级宏观错误码 调用第三方服务出错 ==========
    REMOTE_ERROR("C0001", "调用第三方服务出错");

    private final String code;

    private final String message;

    BaseErrorCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public String code() {
        return code;
    }

    @Override
    public String message() {
        return message;
    }
}
