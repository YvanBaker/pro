package com.yvan.dao.impl;

import com.yvan.dao.FreezeDao;
import com.yvan.entity.Freeze;
import com.yvan.util.SqlUtil;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Yvan
 * @Description Freeze 表 （冻结） 的 dao 层实现类
 * @Classname FreezeDaoImpl
 * @Date 2020/8/20 10:23
 */
public class FreezeDaoImpl extends BaseDao implements FreezeDao {
    @Override
    public int inset(int uid, Timestamp time, String reason) {
        String sql = SqlUtil.insert("freeze", "uid,freeze_time,freeze_reason", "?,?,?");
        List<Object> list = new ArrayList<>();
        list.add(uid);
        list.add(time);
        list.add(reason);
        int res = executeUpdate(sql,list);
        closeAll();
        return res;
    }

    @Override
    public Freeze findFlagFalseByUid(int uid) {
        String sql = SqlUtil.select("id,freeze_time,freeze_reason", "freeze", "uid = ? and flag = ?");
        List<Object> list = new ArrayList<>();
        list.add(uid);
        list.add(false);
        executeQuery(sql,list);
        Freeze resFreeze = null;
        try{
            while (rs.next()){
                int id = rs.getInt("id");
                Timestamp time = rs.getTimestamp("freeze_time");
                String reason = rs.getString("freeze_reason");
                resFreeze = new Freeze(id,uid,time,reason);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeAll();
        }
        return resFreeze;
    }

    @Override
    public int updateFlagTrue(int id, Timestamp time, String reason) {
        String sql = SqlUtil.update("freeze", "unfreeze_time = ?, unfreeze_reason = ?,flag = ?", "id = ?");
        List<Object> list = new ArrayList<>();
        list.add(time);
        list.add(reason);
        list.add(true);
        list.add(id);
        int res = executeUpdate(sql,list);
        closeAll();
        return res;
    }
}
