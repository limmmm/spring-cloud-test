package com.lim.test.enums.demo.util;

import com.lim.test.common.tools.enums.DynamicEnumUtil;
import com.lim.test.common.response.response.ErrorCode;
import lombok.extern.slf4j.Slf4j;

/**
 * ErrorCode 枚举类辅助操作
 *
 * @author Lim
 * @since 2020-11-18
 */
@Slf4j
public class ErrorCodeEnumUtil {

    /**
     * 添加枚举类型
     * WARN: 参数不能有final修改
     *      枚举类型的构造形参需与传递参数类型完全匹配，int 与 Integer不匹配
     *
     * @param enumName 枚举名
     * @param errorCode 错误业务状态码
     * @param message 错误信息(中文描述，返回至前端显示)
     * @param description 错误描述(英文描述)
     */
    public static void add(String enumName, Integer errorCode, String message, String description) {
        DynamicEnumUtil.addEnum(ErrorCode.class, enumName, new Class<?>[]
                        {Integer.class, String.class, String.class},
                new Object[]{errorCode, message, description});
    }

    /**
     * 打印所有枚举类型
     */
    public static void showEnums() {
        for (ErrorCode errorCode : ErrorCode.values()) {
            log.info("{}", errorCode);
        }
    }

}
