package com.lim.test.tools.commonresponse.response;

/**
 * Http 返回结果封装
 *
 * @author Lim
 * @since 2020/09/27
 */
public class Result {

    /**
     * 操作成功，无业务返回参数, 无提示信息
     */
    public static <T> ResponseBody<T> success() {
        return success(ErrorCode.SUCCESS.getMessage(), null);
    }

    /**
     * 操作成功，有业务返回参数, 无提示信息
     */
    public static <T> ResponseBody<T> success(T result) {
        return success(ErrorCode.SUCCESS.getMessage(), result);
    }

    /**
     * 操作成功，有业务返回参数
     * @param message 操作信息
     * @param result 业务数据
     */
    public static <T> ResponseBody<T> success(String message, T result) {
        return new ResponseBody<>(ErrorCode.SUCCESS.getErrorCode(), message, null, result);
    }

    /**
     * 操作失败，通用错误信息
     */
    public static <T> ResponseBody<T> fail() {
        return fail(ErrorCode.ERROR_GENERIC.getErrorCode(), ErrorCode.ERROR_GENERIC.getMessage(),
                ErrorCode.ERROR_GENERIC.getDescription());
    }

    /**
     * 操作失败，通用错误代码，自定义提示消息
     */
    public static <T> ResponseBody<T> fail(String message) {
        return fail(ErrorCode.ERROR_GENERIC.getErrorCode(), message, ErrorCode.ERROR_GENERIC.getDescription());
    }

    /**
     * 操作失败，枚举错误信息
     */
    public static <T> ResponseBody<T> fail(ErrorCode errorCode) {
        return fail(errorCode.getErrorCode(), errorCode.getMessage(), errorCode.getDescription());
    }

    /**
     * 操作失败，枚举错误代码，自定义提示信息
     */
    public static <T> ResponseBody<T> fail(ErrorCode errorCode, String message) {
        return fail(errorCode.getErrorCode(), message, errorCode.getDescription());
    }

    /**
     * 操作失败，自定义错误代码，自定义提示信息
     *
     * @param code 业务状态码
     * @param message 错误信息
     * @param description 错误描述
     */
    private static <T> ResponseBody<T> fail(Integer code, String message, String description) {
        return new ResponseBody<T>(code, message, description, null);
    }

}
