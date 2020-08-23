package com.yvan.dao.impl;

import com.yvan.entity.Administrator;
import com.yvan.util.Md5Util;
import com.yvan.util.TimeUtil;
import junit.framework.TestCase;

public class AdministratorDaoImplTest extends TestCase {
    private static AdministratorDaoImpl administratorDao = new AdministratorDaoImpl();

    /**
     * 测试 findByName 不返回 null
     */
    public void testFindByNameNotNull() {
        assertNotNull(administratorDao.findByName("admin", "超级管理"));
    }

    /**
     * 测试 findByName 返回 bull
     */
    public void testTestFindByNameNull() {
        assertNull(administratorDao.findByName("ceea", "超级管理"));
    }

    /**
     * 测试 findAllById 返回 null
     */
    public void testFindAllByIdNull() {
        assertNull(administratorDao.findAllById(123));
    }

    /**
     * 测试 findAllById 不返回 null
     */
    public void testFindAllByIdNotNull() {
        assertNotNull(administratorDao.findAllById(1));
    }

    /**
     * 测试 changePassword 返回值 为 1
     */
    public void testChangePassword() {
        assertEquals(administratorDao.changePassword(new Administrator(2), Md5Util.md5("12345")), 1, 1);
    }

    /**
     * 测试 save 返回 1
     */
    public void testSave() {
        assertEquals(administratorDao.save(new Administrator("测试", Md5Util.md5("123"), "超级管理", false, TimeUtil.getTime())), 1, 1);
    }
}