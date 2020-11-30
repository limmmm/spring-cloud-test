package com.lim.test.common.tools.date;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

/**
 * LocalDataTime 操作辅助
 *
 * @author Lim
 * @since 2020/09/27
 */
public class LocalDateTimeUtil {

    /**
     * LocalDateTime 转为 毫秒数
     * WARN: 使用系统默认时区
     */
    public static long localDateTime2Mills(LocalDateTime localDateTime) {
        return localDateTime.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
    }

    /**
     * LocalDateTime 转为 秒数
     * WARN: 使用系统默认时区
     */
    public static long localDateTime2Seconds(LocalDateTime localDateTime) {
        return localDateTime.atZone(ZoneId.systemDefault()).toEpochSecond();
    }

    /**
     * 毫秒数 转为 LocalDateTime
     * WARN: 使用系统默认时区
     */
    public static LocalDateTime mills2LocalDateTime(long mills) {
        return LocalDateTime.ofInstant(Instant.ofEpochMilli(mills), ZoneId.systemDefault());
    }

    /**
     * 秒数 转为 LocalDateTime
     * WARN: 使用系统默认时区
     */
    public static LocalDateTime seconds2LocalDateTime(long seconds) {
        return LocalDateTime.ofInstant(Instant.ofEpochSecond(seconds), ZoneId.systemDefault());
    }

}
