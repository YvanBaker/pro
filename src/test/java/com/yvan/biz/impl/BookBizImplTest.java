package com.yvan.biz.impl;

import com.yvan.biz.BookBiz;
import com.yvan.entity.Book;
import com.yvan.util.TimeUtil;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Yvan
 * @Description BookBizImpl 测试类
 * @Classname BookBizImplTest
 * @Date 2020/8/19 10:57
 */
public class BookBizImplTest {
    private final BookBiz bookBiz = new BookBizImpl();

    @Test
    public void testAdd() {
        long time = System.currentTimeMillis();
        for (int i = 0; i < 9999; i++) {
            System.out.println(bookBiz.add(new Book("测试" + i, "测试" + i, "测试出品", TimeUtil.getTime(), "测试", 9999, 10)));
        }
        System.out.println(System.currentTimeMillis() - time);
        Assert.assertTrue(true);
    }
}