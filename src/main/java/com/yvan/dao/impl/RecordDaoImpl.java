package com.yvan.dao.impl;

import com.yvan.dao.RecordDao;
import com.yvan.util.SqlUtil;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Yvan
 * @Description RecordDao 的实现类
 * @Classname RecordDaoImpl
 * @Date 2020/8/17 10:08
 */
public class RecordDaoImpl extends BaseDao implements RecordDao {
    @Override
    public int save(int bookId, int userId,Timestamp lendTime, Timestamp returnTime,float deposit) {
        String table = "record";
        String field = "uid,bid,lend_time,return_time,deposit";
        String term = "?,?,?,?,?";
        String sql = SqlUtil.insert(table,field,term);
        List<Object> list = new ArrayList<>();
        list.add(userId);
        list.add(bookId);
        list.add(lendTime);
        list.add(returnTime);
        list.add(deposit);
        int res = executeUpdate(sql,list);
        closeAll();
        return res;
    }
}
