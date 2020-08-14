package com.yvan.dao.impl;

import com.yvan.dao.UserDao;
import com.yvan.entity.User;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl extends BaseDao implements UserDao {

    @Override
    public User findByName(String name) {
        User user = null;
        String sql = "select id,name,password,point,balance,level,del,freeze,sum_money from user where name = ?";
        List<Object> list = new ArrayList<>();
        list.add(name);
        executeQuery(sql, list);
        try {
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
            closeAll();
        }
        return user;
    }

    @Override
    public boolean save(String name, String password) {
        int res = -1;
        getConn();
        String sql = "INSERT INTO user (name,password) VALUE (?,?)";
        List<Object> list = new ArrayList<>();
        list.add(name);
        list.add(password);
        res = executeUpdate(sql, list);
        closeAll();
        return res == 0 ? false : true;
    }
}
