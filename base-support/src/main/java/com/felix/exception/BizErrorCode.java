package com.felix.exception;

public enum BizErrorCode implements ErrorCode {

    BIZ_ERROR("BIZ_ERROR", "业务异常"),

    ;

    /**
     * 错误码
     */
    private final String code;

    /**
     * 错误描述信息
     */
    private final String message;

    BizErrorCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
