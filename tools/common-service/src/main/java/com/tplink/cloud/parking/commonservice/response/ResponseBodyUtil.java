package com.tplink.cloud.parking.commonservice.response;

/**
 * Http 返回结果封装
 *
 * @author liming
 * @since 2020-09-27
 */
public class ResponseBodyUtil {

    /**
     * 操作成功，无业务返回参数, 无提示信息
     */
    public static <T> ResponseBody<T> success() {
        return success(null, null);
    }

    /**
     * 操作成功，无业务返回参数, 有提示信息
     */
    public static <T> ResponseBody<T> success(String message) {
        return success(message, null);
    }

    /**
     * 操作成功，有业务返回参数, 无提示信息
     */
    public static <T> ResponseBody<T> success(T result) {
        return success(null, result);
    }

    /**
     * 操作成功，有业务返回参数
     * @param message 操作信息
     * @param result 业务数据
     */
    public static <T> ResponseBody<T> success(String message, T result) {
        return new ResponseBody<>(ErrorCode.ERROR_SUCCESS.getErrorCode(), message, result);
    }

    /**
     * 操作失败，通用错误信息
     */
    public static <T> ResponseBody<T> fail() {
        return fail(ErrorCode.ERROR_GENERIC.getErrorCode(), ErrorCode.ERROR_GENERIC.getMessage());
    }

    /**
     * 操作失败，通用错误代码，自定义提示消息
     */
    public static <T> ResponseBody<T> fail(String message) {
        return fail(ErrorCode.ERROR_GENERIC.getErrorCode(), message);
    }

    /**
     * 操作失败，枚举错误信息
     */
    public static <T> ResponseBody<T> fail(ErrorCode errorCode) {
        return fail(errorCode.getErrorCode(), errorCode.getMessage());
    }

    /**
     * 操作失败，枚举错误代码，自定义提示信息
     */
    public static <T> ResponseBody<T> fail(ErrorCode errorCode, String message) {
        return fail(errorCode.getErrorCode(), message);
    }

    /**
     * 操作失败，自定义错误代码，自定义提示信息
     *
     * @param code 业务状态码
     * @param message 错误信息
     */
    public static <T> ResponseBody<T> fail(Integer code, String message) {
        return new ResponseBody<T>(code, message, null);
    }

}
