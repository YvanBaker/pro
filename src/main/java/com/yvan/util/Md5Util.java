package com.yvan.util;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

/**
 * @author Yvan
 * @Description Md5 工具类
 * @Classname Md5Util
 * @Date 2020/8/17 18:53
 */
public class Md5Util {

    /**
     * 生成uuid
     *
     * @return uuid
     */
    @NotNull
    public static String generateUUID() {

        return UUID.randomUUID().toString()
                .replaceAll("-", "").substring(0, 32);
    }

    /**
     * 生成 md5 的方法
     *
     * @param data 数据
     * @return MD5 加密后的结果
     */
    @Nullable
    public static String MD5(@NotNull String data) {
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            byte[] array = md5.digest(data.getBytes(StandardCharsets.UTF_8));
            StringBuilder sb = new StringBuilder();
            for (byte item : array) {
                sb.append(Integer.toHexString((item & 0xFF) | 0x100), 1, 3);
            }
            return sb.toString().toUpperCase();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }
}
