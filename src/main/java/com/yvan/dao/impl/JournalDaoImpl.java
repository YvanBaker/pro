package com.yvan.dao.impl;

import com.yvan.dao.JournalDao;
import com.yvan.util.SqlUtil;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Yvan
 * @Description JournalDao 的 实现类
 * @Classname JournalDaoImpl
 * @Date 2020/8/23 20:43
 */
public class JournalDaoImpl extends BaseDao implements JournalDao {
    @Override
    public int save(int uid, int money, Timestamp time) {
        String sql = SqlUtil.insert("journal", "uid,time,money", "?,?,?");
        List<Object> list = new ArrayList<>();
        list.add(uid);
        list.add(time);
        list.add(money);
        int res = executeUpdate(sql, list);
        closeAll();
        return res;
    }
}
