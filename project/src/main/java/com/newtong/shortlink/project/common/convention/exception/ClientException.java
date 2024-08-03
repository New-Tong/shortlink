package com.newtong.shortlink.project.common.convention.exception;

/**
 * @author NewTong
 * @Date 2024/7/30 -9:23
 * @Description 客户端异常
 */

import com.newtong.shortlink.project.common.convention.errorcode.BaseErrorCode;
import com.newtong.shortlink.project.common.convention.errorcode.IErrorCode;

public class ClientException extends AbstractException {

    public ClientException(IErrorCode errorCode) {
        this(null, null, errorCode);
    }

    public ClientException(String message) {
        this(message, null, BaseErrorCode.CLIENT_ERROR);
    }

    public ClientException(String message, IErrorCode errorCode) {
        this(message, null, errorCode);
    }

    public ClientException(String message, Throwable throwable, IErrorCode errorCode) {
        super(message, throwable, errorCode);
    }

    @Override
    public String toString() {
        return "ClientException{" +
                "code='" + errorCode + "'," +
                "message='" + errorMessage + "'" +
                '}';
    }
}
