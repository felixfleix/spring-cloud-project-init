package com.felix.exception;

/**
 * 错误码枚举类规范接口，各项错误码枚举类务必实现此接口
 *
 * @see com.felix.exception.BizErrorCode
 */
public interface ErrorCode {

    String getCode();

    String getMessage();

}
