package com.felix.request;

import lombok.Getter;
import lombok.Setter;

import java.io.Serial;

@Getter
@Setter
public class PageRequest extends BaseRequest {

    @Serial
    private static final long serialVersionUID = 1L;

    private Integer currentPage;

    private Integer pageSize;

}
