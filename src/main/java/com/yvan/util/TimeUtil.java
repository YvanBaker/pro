package com.yvan.util;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.sql.Timestamp;


/**
 * @author Yvan
 * @Description 时间工具类
 * @Classname TimeUtil
 * @Date 2020/8/18 10:36
 */
public class TimeUtil {
    private static final long DAY = 86400000;

    /**
     * 获取时间几天后的时间 long
     *
     * @param timestamp 时间
     * @param count     天数
     * @return long 时间类型
     */
    @Contract(pure = true)
    public static long getDay(@NotNull Timestamp timestamp, int count) {
        return timestamp.getTime() + count * DAY;
    }

    /**
     * 获取时间几天后的时间 long
     *
     * @param date  java.util.Date
     * @param count 天数
     * @return long 时间类型
     */
    @Contract(pure = true)
    public static long getDay(@NotNull java.util.Date date, int count) {
        return date.getTime() + count * DAY;
    }

    /**
     * 获取时间几天后的时间 long
     *
     * @param date  java.sql.Date date
     * @param count 天数
     * @return long 时间类型
     */
    @Contract(pure = true)
    public static long getDay(@NotNull java.sql.Date date, int count) {
        return date.getTime() + count * DAY;
    }
}
