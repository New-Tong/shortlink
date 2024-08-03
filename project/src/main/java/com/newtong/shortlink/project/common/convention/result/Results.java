package com.newtong.shortlink.project.common.convention.result;

/**
 * @author NewTong
 * @Date 2024/7/30 -9:29
 * @Description 全局返回对象构造器
 */

import com.newtong.shortlink.project.common.convention.errorcode.BaseErrorCode;
import com.newtong.shortlink.project.common.convention.exception.AbstractException;

import java.util.Optional;

public final class Results {

    /**
     * 构造成功响应
     */
    public static <T> Result<T> success() {
        return new Result<T>()
                .setCode(Result.SUCCESS_CODE);
    }

    /**
     * 构造带返回数据的成功响应
     */
    public static <T> Result<T> success(T data) {
        return new Result<T>()
                .setCode(Result.SUCCESS_CODE)
                .setData(data);
    }

    /**
     * 构建服务端失败响应
     */
    public static <T> Result<T> failure() {
        return new Result<T>()
                .setCode(BaseErrorCode.SERVICE_ERROR.code())
                .setMessage(BaseErrorCode.SERVICE_ERROR.message());
    }

    /**
     * 通过 {@link AbstractException} 构建失败响应
     */
    public static <T> Result<T> failure(AbstractException abstractException) {
        String errorCode = Optional.ofNullable(abstractException.getErrorCode())
                .orElse(BaseErrorCode.SERVICE_ERROR.code());
        String errorMessage = Optional.ofNullable(abstractException.getErrorMessage())
                .orElse(BaseErrorCode.SERVICE_ERROR.message());
        return new Result<T>()
                .setCode(errorCode)
                .setMessage(errorMessage);
    }

    /**
     * 通过 errorCode、errorMessage 构建失败响应
     */
    public static <T> Result<T> failure(String errorCode, String errorMessage) {
        return new Result<T>()
                .setCode(errorCode)
                .setMessage(errorMessage);
    }
}