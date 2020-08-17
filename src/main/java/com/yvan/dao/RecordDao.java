package com.yvan.dao;

import java.sql.Timestamp;

/**
 * @author Yvan
 * @Description 操作借书表的dao层
 * @Classname RecordDao
 * @Date 2020/8/17 10:04
 */
public interface RecordDao {

    /**
     * 保存借书记录
     *
     * @param bookId     书的id
     * @param userId     用户id
     * @param lendTime   借阅时间
     * @param returnTime 应归还时间
     * @param deposit    交纳的押金金额
     * @return 条数
     */
    int save(int bookId, int userId, Timestamp lendTime, Timestamp returnTime, float deposit);
}
