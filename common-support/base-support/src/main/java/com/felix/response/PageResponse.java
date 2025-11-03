package com.felix.response;

import com.felix.exception.ErrorCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.util.List;

@Getter
@Setter
public class PageResponse<T> extends MultiResponse<T> {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 当前页
     */
    private Integer currentPage;

    /**
     * 页大小
     */
    private Integer pageSize;

    /**
     * 总页数
     */
    private Integer totalPage;

    /**
     * 总条数
     */
    private Integer total;

    public static <T> PageResponse<T> of(List<T> data, Integer currentPage, Integer pageSize, Integer total, String code, String message, Boolean success) {
        PageResponse<T> response = new PageResponse<>();
        response.setCurrentPage(currentPage);
        response.setPageSize(pageSize);
        // 注意边界条件，0条、小于pageSize条
        response.setTotalPage((total + (pageSize - 1)) / pageSize);
        response.setTotal(total);
        response.setData(data);
        response.setCode(code);
        response.setMessage(message);
        response.setSuccess(success);
        return response;
    }

    public static <T> PageResponse<T> success(List<T> data, Integer currentPage, Integer pageSize, Integer total) {
        return of(data, currentPage, pageSize, total, ResponseCode.SUCCESS.name(), null, true);
    }

    public static <T> PageResponse<T> fail(Integer currentPage, Integer pageSize, String code, String message) {
        return of(null, currentPage, pageSize, 0, code, message, false);
    }

    public static <T> PageResponse<T> fail(Integer currentPage, Integer pageSize, ErrorCode errorCode) {
        return of(null, currentPage, pageSize, 0, errorCode.getCode(), errorCode.getMessage(), false);
    }

}
