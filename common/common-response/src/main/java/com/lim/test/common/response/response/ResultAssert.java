package com.lim.test.common.response.response;

import com.lim.test.common.response.exception.ServiceException;

/**
 * 操作中断
 * 程序不继续执行后续操作，直接返回错误信息，http状态码为200
 *
 * @author Lim
 * @since 2020/09/27
 */
public class ResultAssert {

    /**
     * 操作失败，通用错误信息
     */
    public static void fail() {
        throw new ServiceException(Result.fail());
    }

    /**
     * 操作失败，通用错误代码，自定义提示消息
     */
    public static void fail(String message) {
        throw new ServiceException(Result.fail(message));
    }

    /**
     * 操作失败，枚举错误信息
     */
    public static void fail(ErrorCode errorCode) {
        throw new ServiceException(Result.fail(errorCode));
    }

    /**
     * 操作失败，枚举错误代码，自定义提示信息
     */
    public static void fail(ErrorCode errorCode, String message) {
        throw new ServiceException(Result.fail(errorCode, message));
    }

}
