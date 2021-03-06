package com.yvan.dao.impl;

import com.yvan.dao.ReservationDao;
import com.yvan.entity.Reservation;
import com.yvan.util.SqlUtil;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Yvan
 * @Description ReservationDao 的 实现类
 * @Classname ReservationDaoImpl
 * @Date 2020/8/18 23:02
 */
public class ReservationDaoImpl extends BaseDao implements ReservationDao {
    @Override
    public int save(int uid, int bid, Timestamp time) {
        String sql = SqlUtil.insert("reservation", "uid,bid,time", "?,?,?");
        List<Object> list = new ArrayList<>();
        list.add(uid);
        list.add(bid);
        list.add(time);
        int res = executeUpdate(sql, list);
        closeAll();
        return 0;
    }

    @Override
    public List<Reservation> findByBid(int bid) {
        String sql = SqlUtil.select("id,uid,bid,fulfill", "reservation", "bid = ?");
        List<Object> list = new ArrayList<>();
        list.add(bid);
        executeQuery(sql, list);
        List<Reservation> resReservation = new ArrayList<>();
        try {
            while (rs.next()) {
                int id = rs.getInt("id");
                int uid = rs.getInt("uid");
                boolean fulfill = rs.getBoolean("fulfill");
                resReservation.add(new Reservation(id, uid, bid, fulfill));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeAll();
        }
        return resReservation;
    }

    @Override
    public List<Reservation> findByUid(int uid) {
        String sql = SqlUtil.select("id,uid,bid,time,fulfill", "reservation", "uid = ?");
        List<Object> list = new ArrayList<>();
        list.add(uid);
        executeQuery(sql, list);
        List<Reservation> resReservation = new ArrayList<>();
        try {
            while (rs.next()) {
                int id = rs.getInt("id");
                int bid = rs.getInt("bid");
                Timestamp time = rs.getTimestamp("time");
                boolean fulfill = rs.getBoolean("fulfill");
                resReservation.add(new Reservation(id, uid, bid, time, fulfill));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeAll();
        }
        return resReservation;
    }

    @Override
    public List<Reservation> findByUidBid(int uid, int bid) {
        String sql = SqlUtil.select("id,uid,bid,fulfill", "reservation", "uid = ? and bid = ?");
        List<Object> list = new ArrayList<>();
        list.add(uid);
        list.add(bid);
        List<Reservation> resList = new ArrayList<>();
        executeQuery(sql, list);
        try {
            while (rs.next()) {
                int id = rs.getInt("id");
                boolean fulfill = rs.getBoolean("fulfill");
                resList.add(new Reservation(id, uid, bid, fulfill));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resList;
    }

    @Override
    public int updateFulfillTrue(int id) {
        String sql = SqlUtil.update("reservation", "fulfill = ?", "id = ?");
        List<Object> list = new ArrayList<>();
        list.add(true);
        list.add(id);
        int res = executeUpdate(sql, list);
        closeAll();
        return res;
    }
}
