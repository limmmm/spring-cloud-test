package com.tplink.cloud.parking.commonservice.exception;

import com.tplink.cloud.parking.commonservice.response.ResponseBody;

/**
 * 自定义业务异常类
 *
 * @author liming
 * @since 2020-09-27
 */
public class ServiceException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private ResponseBody responseBody;

    public ServiceException(ResponseBody responseBody) {
        super(responseBody.toString());
        this.responseBody = responseBody;
    }

    public ResponseBody getResponseBody() {
        return responseBody;
    }

}
