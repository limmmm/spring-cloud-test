package com.tplink.cloud.parking.commonservice.response;

import lombok.Data;

/**
 * 返回结果结构封装
 *
 * @author liming
 * @since 2020-09-27
 */
@Data
public class ResponseBody<T> {

    /** 返回业务状态码 */
    private Integer errorCode;

    /** 操作信息 */
    private String errorMsg;

    /** 业务数据 */
    private T result;

    public ResponseBody() {
    }

    public ResponseBody(Integer errorCode, String errorMsg, T result) {
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
        this.result = result;
    }

}
