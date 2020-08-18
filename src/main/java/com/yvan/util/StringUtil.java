package com.yvan.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Yvan
 */

public class StringUtil {

    private static final String SQLPATTERN = "(and|exec|insert|select|drop|grant|alter|delete|update|count|chr|mid|master|truncate|char|declare|or)\\b|(\\*|;|\\+|'|%|#)";

    /**
     * 判断是否为空字符串
     *
     * @param str 字符串
     * @return true 空
     */
    public static boolean isNull(String str) {
        return "".equals(str) || str == null;
    }

    public static String isNullString(String str) {
        return str + "为空！！！";
    }

    public static boolean isNotLegal(String str) {
        Pattern pattern = Pattern.compile(SQLPATTERN);
        Matcher matcher = pattern.matcher(str);
        return matcher.find();
    }
}
