package com.yvan.util;

import junit.framework.TestCase;

/**
 * @author Yvan
 * @Description StringUtil 的 测试类
 * @Classname StringUtilTest
 * @Date 2020/8/17 20:02
 */
public class StringUtilTest extends TestCase {

    public void testIsNotLegal() {
        assertTrue(StringUtil.isNotLegal("and"));
    }
}