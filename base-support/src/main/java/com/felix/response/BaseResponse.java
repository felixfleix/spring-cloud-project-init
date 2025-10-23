package com.felix.response;

import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
public class BaseResponse implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 响应状态码
     *
     * @see com.felix.response.ResponseCode
     */
    private String code;

    /**
     * 响应信息，如果发生异常，需要将异常信息补充到该属性中
     */
    private String message;

    /**
     * 是否处理成功，用于请求方快速判断请求是否被成功处理
     */
    private Boolean success;

}
