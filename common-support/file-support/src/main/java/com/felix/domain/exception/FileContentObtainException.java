package com.felix.domain.exception;

import com.felix.exception.ErrorCode;
import com.felix.exception.SystemException;

import java.io.Serial;

public class FileContentObtainException extends SystemException {

    @Serial
    private static final long serialVersionUID = 1L;

    public FileContentObtainException(ErrorCode errorCode) {
        super(errorCode);
    }

    public FileContentObtainException(ErrorCode errorCode, String message) {
        super(errorCode, message);
    }

    public FileContentObtainException(ErrorCode errorCode, String message, Throwable cause) {
        super(errorCode, message, cause);
    }

    public FileContentObtainException(ErrorCode errorCode, Throwable cause) {
        super(errorCode, cause);
    }

    protected FileContentObtainException(ErrorCode errorCode, String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(errorCode, message, cause, enableSuppression, writableStackTrace);
    }

}
