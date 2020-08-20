package com.yvan.util;

import junit.framework.TestCase;

/**
 * @author Yvan
 * @Description Md5Util 的 测试类
 * @Classname Md5UtilTest
 * @Date 2020/8/17 19:01
 */
public class Md5UtilTest extends TestCase {

    public void testMD5() {
        System.out.println(Md5Util.md5("123"));
        assertTrue( true);
    }

    public void testGenerateUUID() {
        System.out.println(Md5Util.generateUuid());
        assertTrue( true);
    }
}