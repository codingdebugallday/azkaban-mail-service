package com.isacc.mail.api.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.apache.http.HttpStatus;

/**
 * <p>
 * 对API调用的返回结果封装类
 * </p>
 *
 * @author isacc 2019/04/29 0:59
 */
@Builder
@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResult<T> {

    /**
     * 返回给前台的状态码
     */
    private Integer code;
    /**
     * 请求是否成功
     */
    private Boolean result;
    /**
     * 返回给前台的信息
     */
    private String message;
    /**
     * 返回给前台的数据
     */
    private T content;

    private ApiResult(Integer code, Boolean result) {
        this.code = code;
        this.result = result;
    }

    public static ApiResult<Object> initSuccess() {
        return new ApiResult<>(HttpStatus.SC_OK, true);
    }

    public static ApiResult<Object> initFailure() {
        return new ApiResult<>(HttpStatus.SC_INTERNAL_SERVER_ERROR, false);
    }

}
