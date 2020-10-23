package com.lim.test.tools.commonresponse.response;

import lombok.Getter;

/**
 * 返回结果枚举类
 *
 * @author lim
 * @since 2020-09-27
 */
public enum ErrorCode {

    // 错误码
    SUCCESS(0, "操作成功", "success"),

    // 系统级错误
    ERROR_UNKNOWN(10001, "系统异常，请联系管理员处理", "unknown error"),
    ERROR_GENERIC(10002, "操作失败，请稍后重试", "Generic error"),
    ERROR_AUTHENTICATION_REQUIRED(10003, "请重新登录", "Required login status"),
    ERROR_AUTHORIZATION_REQUIRED(10004, "您无权访问此功能，请联系管理员处理", "Permission denied"),

    // 参数错误
    ERROR_PARAMS(20001, "参数错误", "Invalid params"),

    // 业务模块错误
    ERROR_SYSTEM_ERROR(31001, "系统管理模块功能异常", "Module system error")
    ;

    /** 错误业务状态码 */
    @Getter
    private final int errorCode;

    /** 错误信息(中文描述，返回至前端显示) */
    @Getter
    private final String message;

    /** 错误描述(英文描述) */
    @Getter
    private final String description;

    ErrorCode(int errorCode, String message, String description) {
        this.errorCode = errorCode;
        this.message = message;
        this.description = description;
    }

    public static ErrorCode getErrorCode(int code) {
        for (ErrorCode errorCode : ErrorCode.values()) {
            if (errorCode.errorCode == code) {
                return errorCode;
            }
        }
        return ErrorCode.ERROR_UNKNOWN;
    }

}
