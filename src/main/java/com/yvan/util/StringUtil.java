package com.yvan.util;

public class StringUtil {
    /**
     * 判断是否为空字符串
     *
     * @param str 字符串
     * @return true 空
     */
    public static boolean isNull(String str) {
        if ("".equals(str) || str == null) {
            return true;
        }
        return false;
    }
}
