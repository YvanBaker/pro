package com.yvan.dao.impl;

import com.yvan.dao.UserDao;
import com.yvan.entity.User;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

public class UserDaoImpl extends BaseDao implements UserDao {

    @Override
    public User findByName(String name) {
        User user = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        getConn();
        String sql = "select id,name,password,point,balance,level,del,freeze,sum_money " +
                "from user where name = ?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, name);
            rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String password = rs.getString("password");
                float point = rs.getFloat("point");
                double balance = rs.getDouble("balance");
                int level = rs.getInt("level");
                boolean del = rs.getBoolean("del");
                boolean freeze = rs.getBoolean("freeze");
                double sumMoney = rs.getDouble("sum_money");
                user = new User(id, name, password, point, balance, level, del, sumMoney, freeze);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConn();
            closeIter(ps, rs);
        }
        return user;
    }

    @Override
    public boolean save(String name, String password,Timestamp timestamp) {
        PreparedStatement ps = null;
        int res = -1;
        getConn();
        String sql = "INSERT INTO user(name,password,creat_data) VALUE (?,?,?)";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, password);
            ps.setTimestamp(3,timestamp);
            res = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConn();
            closeIter(ps, null);
        }
        return res == 0 ? false : true;
    }
}
