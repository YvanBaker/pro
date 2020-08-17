package com.yvan.dao.impl;

import com.yvan.dao.RecordDao;
import junit.framework.TestCase;

import java.sql.Timestamp;

/**
 * @author Yvan
 * @Description TODO
 * @Classname RecordDaoImplTest
 * @Date 2020/8/17 10:52
 */
public class RecordDaoImplTest extends TestCase {
    final RecordDao recordDao = new RecordDaoImpl();

    public void testSave() {
        Timestamp lend = new Timestamp(System.currentTimeMillis());
        long time = lend.getTime() + 7 * 86400000;
        Timestamp re = new Timestamp(time);
        assertTrue(recordDao.save(15, 1, lend, re, 123) > 0);
    }

    public void testFindAllByUid() {
        assertNotNull(recordDao.findAllByUid(1));
    }
}