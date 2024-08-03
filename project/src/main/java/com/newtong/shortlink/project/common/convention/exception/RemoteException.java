package com.newtong.shortlink.project.common.convention.exception;

/**
 * @author NewTong
 * @Date 2024/7/30 -9:24
 * @Description 远程服务调用异常
 */

import com.newtong.shortlink.project.common.convention.errorcode.BaseErrorCode;
import com.newtong.shortlink.project.common.convention.errorcode.IErrorCode;

public class RemoteException extends AbstractException {

    public RemoteException(String message) {
        this(message, null, BaseErrorCode.REMOTE_ERROR);
    }

    public RemoteException(String message, IErrorCode errorCode) {
        this(message, null, errorCode);
    }

    public RemoteException(String message, Throwable throwable, IErrorCode errorCode) {
        super(message, throwable, errorCode);
    }

    @Override
    public String toString() {
        return "RemoteException{" +
                "code='" + errorCode + "'," +
                "message='" + errorMessage + "'" +
                '}';
    }
}
