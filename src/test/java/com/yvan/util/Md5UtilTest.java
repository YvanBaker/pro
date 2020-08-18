package com.yvan.util;

import junit.framework.TestCase;

/**
 * @author Yvan
 * @Description TODO
 * @Classname Md5UtilTest
 * @Date 2020/8/17 19:01
 */
public class Md5UtilTest extends TestCase {

    public void testMD5() {
        System.out.println(Md5Util.MD5("123"));
        assertTrue( true);
    }

    public void testGenerateUUID() {
        System.out.println(Md5Util.generateUUID());
        assertTrue( true);
    }
}