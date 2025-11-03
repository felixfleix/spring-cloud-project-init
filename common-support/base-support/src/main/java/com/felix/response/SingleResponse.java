package com.felix.response;

import com.felix.exception.ErrorCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;

@Getter
@Setter
public class SingleResponse<T> extends BaseResponse {

    @Serial
    private static final long serialVersionUID = 1L;

    private T data;

    public static <T> SingleResponse<T> of(T data, String code, String message, Boolean success) {
        SingleResponse<T> response = new SingleResponse<>();
        response.setData(data);
        response.setCode(code);
        response.setMessage(message);
        response.setSuccess(success);
        return response;
    }

    public static <T> SingleResponse<T> success(T data) {
        return of(data, ResponseCode.SUCCESS.name(), null, true);
    }

    public static <T> SingleResponse<T> fail(String code, String message) {
        return of(null, code, message, false);
    }

    public static <T> SingleResponse<T> fail(ErrorCode errorCode) {
        return of(null, errorCode.getCode(), errorCode.getMessage(), false);
    }

}
