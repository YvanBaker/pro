package com.yvan.dao.impl;

import junit.framework.TestCase;

/**
 * @author Yvan
 * @Description FreezeDaoImpl 的测试类
 * @Classname FreezeDaoImplTest
 * @Date 2020/8/20 10:47
 */
public class FreezeDaoImplTest extends TestCase {
    private final FreezeDaoImpl freezeDao = new FreezeDaoImpl();

    public void testInset() {

    }

    public void testFindFlagFalseByUidNull() {
        System.out.println(freezeDao.findFlagFalseByUid(3));
        assertNull(freezeDao.findFlagFalseByUid(3));
    }

    public void testFindFlagFalseByUidNotNull() {
        System.out.println(freezeDao.findFlagFalseByUid(1));
        assertNull(freezeDao.findFlagFalseByUid(3));
    }

    public void testUpdateFlagTrue() {
    }
}