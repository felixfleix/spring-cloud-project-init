package com.felix.response;

import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.util.List;

@Getter
@Setter
public class MultiResponse<T> extends BaseResponse {

    @Serial
    private static final long serialVersionUID = 1L;

    private List<T> data;

    public static <T> MultiResponse<T> of(List<T> data, String code, String message, Boolean success) {
        MultiResponse<T> response = new MultiResponse<>();
        response.setData(data);
        response.setCode(code);
        response.setMessage(message);
        response.setSuccess(success);
        return response;
    }

    public static <T> MultiResponse<T> success(List<T> data) {
        return of(data, ResponseCode.SUCCESS.name(), null, true);
    }

    public static <T> MultiResponse<T> fail(String code, String message) {
        return of(null, code, message, false);
    }

}
