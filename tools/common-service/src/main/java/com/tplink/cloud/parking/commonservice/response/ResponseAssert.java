package com.tplink.cloud.parking.commonservice.response;

import com.tplink.cloud.parking.commonservice.exception.ServiceException;

/**
 * 操作中断
 * 程序不继续执行后续操作，直接返回错误信息，http状态码为200
 *
 * @author liming
 * @since 2020-09-27
 */
public class ResponseAssert {

    /**
     * 操作失败，通用错误信息
     */
    public static void fail() {
        throw new ServiceException(ResponseBodyUtil.fail());
    }

    /**
     * 操作失败，通用错误代码，自定义提示消息
     */
    public static void fail(String message) {
        throw new ServiceException(ResponseBodyUtil.fail(message));
    }

    /**
     * 操作失败，枚举错误信息
     */
    public static void fail(ErrorCode errorCode) {
        throw new ServiceException(ResponseBodyUtil.fail(errorCode));
    }

    /**
     * 操作失败，枚举错误代码，自定义提示信息
     */
    public static void fail(ErrorCode errorCode, String message) {
        throw new ServiceException(ResponseBodyUtil.fail(errorCode, message));
    }

    /**
     * 操作失败，自定义错误代码，自定义提示信息
     *
     * @param code 业务状态码
     * @param message 错误信息
     */
    public static void fail(Integer code, String message) {
        throw new ServiceException(ResponseBodyUtil.fail(code, message));
    }

}
