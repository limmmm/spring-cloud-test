package com.tplink.cloud.parking.commonservice.response;

/**
 * 返回结果枚举类
 *
 * @author liming
 * @since 2020-09-27
 */
public enum ErrorCode {

    // 业务云错误码
    ERROR_SUCCESS(0, "Success"),
    ERROR_INVALID_PARAMS(-82400, "Parameter is invalid"),
    ERROR_PERMISSION_DENIED(-82401, "Permission denied"),
    ERROR_ACCOUNT_LOGIN_IN_OTHER_PLACES(-82402, "Account login in other places"),
    ERROR_JAVA_TYPE_MISMATCH_DATABASE_TYPE(-82403, "Java type mismatches database type"),
    ERROR_CLOSE_DATABASE_CONNECTION_FAILED(-82404, "Close database connection failed"),
    ERROR_CONNECT_DATABASE_FAILED(-82405, "Connect database failed"),
    ERROR_INSERTION_VIOLATE_DATABASE_CONSISTENCY(-82406, "Insertion violates database consistency"),
    ERROR_DATABASE_DEAD_LOCK(-82407, "Database dead lock"),
    ERROR_DATABASE_API_MISUSE(-82408, "Database API misuse"),
    ERROR_UNEXPECTED_ERROR_WHEN_UPDATE(-82409, "Unexpected error when update"),
    ERROR_DATABASE_RESOURCE_MISUSE(-82410, "Database resource misuse"),
    ERROR_GET_OPTIMISTIC_LOCK_FAILED(-82411, "Get optimistic lock failed"),
    ERROR_ACCESS_DATA_IN_DATABASE_FAILED(-82412, "Access data in database failed"),
    ERROR_GENERIC(-82413, "Generic error"),
    ERROR_SERVER_INTERNAL_ERROR(-82414, "Server internal error"),
    ERROR_UNKNOWN(-82415, "Unknown error"),
    ERROR_PARSE_JSON(-82416, "JSON format error"),
    ERROR_PARSE_JSON_NULL(-82417, "JSON body is NULL"),
    ERROR_METHOD_NOT_FOUND(-82418, "The method does not exist or is not available"),
    ERROR_PARAMS_NOT_FOUND(-82419, "Parameter doesn't exist"),
    ERROR_PARAMS_WRONG_RANGE(-82420, "The value is out of the range for parameter"),
    ERROR_PARAMS_WRONG_TYPE(-82421, "Parameter has different type with value"),
    ERROR_BATCH_CONFIG_WITH_PARTIAL_ERROR(-82422, "Partial error when batch configuration"),
    ERROR_SHARE_TIME_NOT_MATCH(-82423, "Current not match the share time"),
    ERROR_SERVICE_BUSY(-82429, "Service is busy"),
    SYSTEM_DATABASE_SYNCHRONIZING(-82434, "DB synchronizing"),
    LOCAL_SERVER_IP_NOT_ALLOWED_FOR_DB_SYNC(-82435, "any ip of the local server is not allowed for DB synchronization"),
    SYNC_HOST_NOT_REACHABLE(-82436, "sync host is not reachable"),
    DB_SYNC_CONFIGURATION_ERROR(-82437, "db sync configuration finished with error"),
    TOKEN_EMPTY(-82438, "Token empty"),
    FTP_SERVER_CONNECTION_FAILED(-82441, "Failed to connect to FTP server"),

    // 停车云后台错误码[-86000, -86200]

    /** 未获取到openId */
    ERROR_OPENID_REQUIRED(-86001, "openId is required"),
    /** 未获取到车牌号 */
    ERROR_CAR_NUMBER_REQUIRED(-86002, "carNumber is required"),
    /** openId与账号未绑定 */
    ERROR_OPENID_NOT_BOUND(-86003, "openId not bound any user"),
    /** 车牌号未在停车场注册 */
    ERROR_CAR_NOT_EXIST(-86004, "car account not exist"),
    /** 您已绑定此车牌号 */
    ERROR_USER_CAR_BOUND(-86005, "user car has bound"),
    /** 未获取到旧车牌号 */
    ERROR_OLD_CAR_NUMBER_REQUIRED(-86006, "carNumberOld is required"),
    /** 未获取到新车牌号 */
    ERROR_NEW_CAR_NUMBER_REQUIRED(-86007, "carNumberNew is required"),
    /** 用户只绑定一个车牌号 */
    ERROR_USER_ONLY_ONE_CAR(-86008, "account only bind one car"),
    /** 车辆有进行中的订单 */
    ERROR_CAR_HAS_UNDERWAY_ORDER(-86009, "car has underway order"),
    /** 车辆在车场中有余额 */
    ERROR_CAR_HAS_BALANCE(-86010, "car account has balance left in some parking lot"),
    /** 未获取到设备id */
    ERROR_DEVICE_ID_REQUIRED(-86011, "device id is required"),
    /** 未获取到设备token */
    ERROR_DEVICE_TOKEN_REQUIRED(-86012, "device token is required"),
    /** 设备token/id校验不通过 */
    ERROR_DEVICE_VALID_FAILED(-86013, "device valid failed"),
    /** 未获取到停车场名称 */
    ERROR_PARKING_NAME_REQUIRED(-86014, "parking name is required"),
    /** 未获取到停车场车位总数 */
    ERROR_PARKING_SPACE_TOTAL_REQUIRED(-86015, "parking spaceTotal is required"),
    /** 未获取到停车场地址 */
    ERROR_PARKING_ADDRESS_REQUIRED(-86016, "parking address is required"),
    /** 未获取到停车场在线充值信息 */
    ERROR_PARKING_ONLINE_RECHARGE_REQUIRED(-86017, "parking onlineRecharge is required"),
    /** 未获取到停车场经度信息 */
    ERROR_PARKING_LONGITUDE_REQUIRED(-86018, "parking longitude is required"),
    /** 未获取到停车场纬度信息 */
    ERROR_PARKING_LATITUDE_REQUIRED(-86019, "parking latitude is required"),
    /** deviceId已被注册 */
    ERROR_PARKING_DEVICE_ID_REGISTERED(-86020, "parking deviceId has been registered"),
    /** 未找到对应停车场 */
    ERROR_PARKING_NOT_FOUND(-86021, "parking not found"),
    /** 车辆账号已注册 */
    ERROR_CAR_ACCOUNT_REGISTERED(-86022, "car account has been registered"),
    /** 车辆账号未注册 */
    ERROR_CAR_ACCOUNT_NOT_EXIST(-86023, "car account not exist"),
    /** 未获取到旧车牌号 */
    ERROR_CAR_NUMBER_BEFORE_REQUIRED(-86024, "carNumberBefore is required"),
    /** 未获取到新车牌号 */
    ERROR_CAR_NUMBER_AFTER_REQUIRED(-86025, "carNumberAfter is required"),
    /** 未获取到账户余额 */
    ERROR_ACCOUNT_BALANCE_REQUIRED(-86026, "account balance is required"),
    /** 未获取到用户经度信息 */
    ERROR_USER_LONGITUDE_REQUIRED(-86027, "user longitude is required"),
    /** 未获取到用户纬度信息 */
    ERROR_USER_LATITUDE_REQUIRED(-86028, "user latitude is required")
    ;

    private int errorCode;
    private String message;

    ErrorCode(int errorCode, String message) {
        this.errorCode = errorCode;
        this.message = message;
    }

    public String getStringExp() {
        return errorCode + message;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public String getMessage() {
        return message;
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
