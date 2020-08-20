package com.yvan.dao.impl;

import com.yvan.dao.CollectionDao;
import com.yvan.entity.Collection;
import com.yvan.util.SqlUtil;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Yvan
 * @Description CollectionDao 的 实现类
 * @Classname CollectionDaoImpl
 * @Date 2020/8/18 13:15
 */
public class CollectionDaoImpl extends BaseDao implements CollectionDao {


    @Override
    public int save(int uid, int bid, Timestamp createTime) {
        String sql = SqlUtil.insert("collection", "uid,bid,create_time", "?,?,?");
        List<Object> list = new ArrayList<>();
        list.add(uid);
        list.add(bid);
        list.add(createTime);
        int res = executeUpdate(sql, list);
        closeAll();
        return res;
    }

    @Override
    public List<Collection> findByUid(int uid) {
        String sql = SqlUtil.select("id,bid,del", "collection", "uid = ?");
        List<Object> list = new ArrayList<>();
        list.add(uid);
        executeQuery(sql, list);
        List<Collection> resCollection = new ArrayList<>();
        try {
            while (rs.next()) {
                int id = rs.getInt("id");
                int bid = rs.getInt("bid");
                boolean del = rs.getBoolean("del");
                resCollection.add(new Collection(id, uid, bid, del));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resCollection;
    }

    @Override
    public Collection findByBidUid(int bid, int uid) {
        String sql = SqlUtil.select("id,uid,bid,del", "collection", "uid = ? and bid = ?");
        List<Object> list = new ArrayList<>();
        Collection collection = null;
        list.add(uid);
        list.add(bid);
        executeQuery(sql, list);
        try {
            while (rs.next()) {
                int id = rs.getInt("id");
                boolean del = rs.getBoolean("del");
                collection = new Collection(id, uid, bid, del);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return collection;
    }

    @Override
    public int updateDelTrue(int uid, int bid, Timestamp time) {
        String sql = SqlUtil.update("collection", "del = ?, del_time = ?", "uid = ? and bid = ?");
        List<Object> list = new ArrayList<>();
        list.add(true);
        list.add(time);
        list.add(uid);
        list.add(bid);
        int res = executeUpdate(sql, list);
        closeAll();
        return res;
    }

    @Override
    public int updateDelFalse(int uid, int bid, Timestamp time) {
        String sql = SqlUtil.update("collection", "del = ?, create_time = ?", "uid = ? and bid = ?");
        List<Object> list = new ArrayList<>();
        list.add(false);
        list.add(time);
        list.add(uid);
        list.add(bid);
        int res = executeUpdate(sql, list);
        closeAll();
        return res;
    }
}
