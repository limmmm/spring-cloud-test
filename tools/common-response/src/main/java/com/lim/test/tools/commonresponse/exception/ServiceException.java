package com.lim.test.tools.commonresponse.exception;

import com.lim.test.tools.commonresponse.response.ResponseBody;

/**
 * 自定义业务异常类
 *
 * @author Lim
 * @since 2020/09/27
 */
public class ServiceException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private final ResponseBody<Void> responseBody;

    public ServiceException(ResponseBody<Void> responseBody) {
        super(responseBody.toString());
        this.responseBody = responseBody;
    }

    public ResponseBody<Void> getResponseBody() {
        return responseBody;
    }

}
