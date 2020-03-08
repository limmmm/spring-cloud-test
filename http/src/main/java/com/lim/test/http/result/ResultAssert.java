package com.lim.test.http.result;

import com.lim.test.http.exception.ServiceException;

/**
 * 操作中断
 * @author lim
 * @date 2020/3/8
 */
public class ResultAssert {

    /**
     * 操作失败，通用返回结果
     * @param show 是否显示提示信息
     */
    public static void error(Boolean show) {
        throw new ServiceException(ResultVOUtil.error(show));
    }

    /**
     * 操作失败，自定义提示消息
     * @param message 提示消息
     * @param show 是否显示提示信息
     */
    public static void error(String message, Boolean show) {
        throw new ServiceException(ResultVOUtil.error(message, show));
    }

    /**
     * 操作失败，自定义错误类型
     * @param resultEnum 错误类型
     * @param show 是否显示提示信息
     */
    public static void error(ResultEnum resultEnum, Boolean show) {
        throw new ServiceException(ResultVOUtil.error(resultEnum, show));
    }

    /**
     * 操作失败，自定义错误类型与提示消息
     * @param resultEnum 错误类型
     * @param message 提示消息
     * @param show 是否显示提示信息
     */
    public static void error(ResultEnum resultEnum, String message, Boolean show) {
        throw new ServiceException(ResultVOUtil.error(resultEnum, message, show));
    }
}
