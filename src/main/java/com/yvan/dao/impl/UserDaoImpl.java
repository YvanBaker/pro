package com.yvan.dao.impl;

import com.yvan.dao.UserDao;
import com.yvan.entity.User;
import com.yvan.util.SqlUtil;
import org.jetbrains.annotations.NotNull;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Yvan
 */

public class UserDaoImpl extends BaseDao implements UserDao {

    /**
     * 创建一个user用户
     * User(id, name, password, point, balance, level, del, sumMoney, freeze)
     * id,name,password,point,balance,level,del,freeze,sum_money
     *
     * @return user用户
     */
    private User createUser() {
        User user = null;
        try {
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String password = rs.getString("password");
                float point = rs.getFloat("point");
                double balance = rs.getDouble("balance");
                int level = rs.getInt("level");
                boolean del = rs.getBoolean("del");
                double sumMoney = rs.getDouble("sum_money");
                user = new User(id, name, password, point, balance, level, del, sumMoney);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeAll();
        }
        return user;
    }

    /**
     * 创建一个user用户列表
     *
     * @return user 列表
     */
    @NotNull
    private List<User> createUserList() {
        List<User> userList = new ArrayList<>();
        try {
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String password = rs.getString("password");
                float point = rs.getFloat("point");
                double balance = rs.getDouble("balance");
                int level = rs.getInt("level");
                boolean del = rs.getBoolean("del");
                double sumMoney = rs.getDouble("sum_money");
                userList.add(new User(id, name, password, point, balance, level, del, sumMoney));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeAll();
        }
        return userList;
    }

    @Override
    public List<User> findAll() {
        String sql = SqlUtil.select("id,name,password,point,balance,level,del,freeze,sum_money", "user");
        executeQuery(sql);
        return createUserList();
    }

    @Override
    public User findByName(String name) {
        User user;
        String sql = "select id,name,password,point,balance,level,del,freeze,sum_money from user where name = ?";
        List<Object> list = new ArrayList<>();
        list.add(name);
        executeQuery(sql, list);
        user = createUser();
        return user;
    }

    @Override
    public List<User> fuzzyFindByName(String name) {
        String fuzzyName = "%" + name + "%";
        String sql = SqlUtil.select("id,name,password,point,balance,level,del,freeze,sum_money", "user", "name LIKE ?");
        List<Object> list = new ArrayList<>();
        list.add(fuzzyName);
        executeQuery(sql, list);
        return createUserList();
    }

    @Override
    public User findAllById(int id) {

        String field = "id,name,password,point,balance,level,del,freeze,sum_money";
        String table = "user";
        String term = "id = ?";
        String sql = SqlUtil.select(field, table, term);
        List<Object> list = new ArrayList<>();
        list.add(id);
        executeQuery(sql, list);
        return createUser();
    }

    @Override
    public boolean save(String name, String password) {
        String sql = "INSERT INTO user (name,password) VALUE (?,?)";
        List<Object> list = new ArrayList<>();
        list.add(name);
        list.add(password);
        int res = executeUpdate(sql, list);
        closeAll();
        return res != 0;
    }

    @Override
    public int changePassword(@NotNull User user, String newPassword) {
        String sql = SqlUtil.update("user", "password = ?", "id = ?");
        List<Object> list = new ArrayList<>();
        list.add(newPassword);
        list.add(user.getId());
        int res = executeUpdate(sql, list);
        closeAll();
        return res;
    }

    @Override
    public int updatePointBalance(int id, float point, double balance) {
        String table = "user";
        String field = "point = ?, balance = ?";
        String term = "id = ?";
        String sql = SqlUtil.update(table, field, term);
        List<Object> list = new ArrayList<>();
        list.add(point);
        list.add(balance);
        list.add(id);
        int res = executeUpdate(sql, list);
        closeAll();
        return res;
    }

    @Override
    public int updateBalance(int id, double balance) {
        String sql = SqlUtil.update("user", "balance = ?", "id = ?");
        List<Object> list = new ArrayList<>();
        list.add(balance);
        list.add(id);
        int res = executeUpdate(sql, list);
        closeAll();
        return res;
    }
}
