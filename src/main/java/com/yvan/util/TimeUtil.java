package com.yvan.util;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.sql.Timestamp;
import java.util.Date;


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

    /**
     * 获取时间
     *
     * @return Timestamp
     */
    @NotNull
    @Contract(" -> new")
    public static Timestamp getTime() {
        return new Timestamp(System.currentTimeMillis());
    }

    /**
     * 小于当前时间
     *
     * @param date 时间
     * @return true 小于当前时间
     */
    public static boolean timeLessCurrent(@NotNull Date date) {
        return date.getTime() <= System.currentTimeMillis();
    }

    /**
     * 小于当前时间
     *
     * @param date 时间
     * @return true 小于当前时间
     */
    public static boolean timeLessCurrent(@NotNull Timestamp date) {
        return date.getTime() <= System.currentTimeMillis();
    }

    /**
     * 大于当前时间
     *
     * @param date 时间
     * @return 大于当前时间
     */
    public static boolean timeMoreCurrent(@NotNull Date date) {
        return date.getTime() >= System.currentTimeMillis();
    }

    /**
     * 大于当前时间
     *
     * @param date 时间
     * @return 大于当前时间
     */
    public static boolean timeMoreCurrent(@NotNull Timestamp date) {
        return date.getTime() >= System.currentTimeMillis();
    }

    /**
     * Date 转 Timestamp 类型
     *
     * @param date date
     * @return Timestamp 类型
     */
    @NotNull
    @Contract("_ -> new")
    public static Timestamp dataTurnTimestamp(@NotNull Date date) {
        return new Timestamp(date.getTime());
    }
}
