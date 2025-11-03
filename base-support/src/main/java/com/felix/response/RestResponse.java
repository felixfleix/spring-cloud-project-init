package com.felix.response;

import com.alibaba.fastjson2.JSONObject;
import com.felix.annotation.Nullable;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;

@Getter
@Setter
public class RestResponse extends BaseResponse {

    @Serial
    private static final long serialVersionUID = 1L;

    private JSONObject data;

    private JSONObject error;

    @Override
    public Boolean getSuccess() {
        return data != null;
    }

    @Nullable
    @Override
    public String getCode() {
        if (error != null) {
            return error.getString("code");
        }
        return null;
    }

    @Nullable
    @Override
    public String getMessage() {
        if (error != null) {
            return error.getString("message");
        }
        return null;
    }
}
