package com.yvan.dao;

import java.sql.Timestamp;

/**
 * @author Yvan
 * @Description Journal(表) 的 dao层
 * @Classname JournalDao
 * @Date 2020/8/23 20:40
 */
public interface JournalDao {
    /**
     * 插入流水记录
     *
     * @param uid   uid
     * @param money 金额
     * @param time  时间
     * @return 条数
     */
    int save(int uid, int money, Timestamp time);
}
