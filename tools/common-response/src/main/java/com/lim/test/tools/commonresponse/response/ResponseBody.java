package com.lim.test.tools.commonresponse.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 返回结果结构封装
 *
 * @author lim
 * @since 2020-09-27
 */
@Data
@NoArgsConstructor
public class ResponseBody<T> {

    /** 返回业务状态码 */
    private Integer errorCode;

    /** 错误信息 */
    private String message;

    /** 错误描述 */
    @JsonIgnore
    private String description;

    /** 业务数据 */
    private T result;

    protected ResponseBody(Integer errorCode, String message, String description, T result) {
        this.errorCode = errorCode;
        this.message = message;
        this.description = description;
        this.result = result;
    }

}
