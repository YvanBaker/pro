package com.yvan.dao.impl;

import com.yvan.dao.AdministratorDao;
import com.yvan.entity.Administrator;
import com.yvan.util.SqlUtil;
import org.jetbrains.annotations.NotNull;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Yvan
 */

public class AdministratorDaoImpl extends BaseDao implements AdministratorDao {

    @Override
    public Administrator findByName(String name,String type) {
        Administrator administrator = null;
        String sql = "select id,name,password,type,del from administrator where name = ? and type = ?";
        List<Object> list = new ArrayList<>();
        list.add(name);
        list.add(type);
        executeQuery(sql, list);
        try {
            while (rs.next()) {
                int id = rs.getInt("id");
                String password = rs.getString("password");
                boolean del = rs.getBoolean("del");
                administrator = new Administrator(id, name, password, type, del);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeAll();
        }

        return administrator;
    }

    @Override
    public Administrator findAllById(int id) {
        Administrator administrator = null;
        String field = "id,name,password,type,del";
        String table = "administrator";
        String term = "id = ?";
        String sql = SqlUtil.select(field, table, term);
        List<Object> list = new ArrayList<>();
        list.add(id);
        executeQuery(sql, list);
        try {
            while (rs.next()) {
                String name = rs.getString("name");
                String password = rs.getString("password");
                String type = rs.getString("type");
                boolean del = rs.getBoolean("del");
                administrator = new Administrator(id, name, password, type, del);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeAll();
        }
        return administrator;
    }

    @Override
    public int changePassword(@NotNull Administrator administrator, String newPassword) {
        String table = "administrator";
        String field = "password = ?";
        String term = "id = ?";
        String sql = SqlUtil.update(table, field, term);
        List<Object> list = new ArrayList<>();
        list.add(newPassword);
        list.add(administrator.getId());
        int res = executeUpdate(sql, list);
        closeAll();
        return res;
    }

    @Override
    public int save(@NotNull Administrator administrator) {
        String table = "administrator";
        String field = "name,password,type,del,create_time";
        String term = "?,?,?,?,?";
        String sql = SqlUtil.insert(table, field, term);
        List<Object> list = new ArrayList<>();
        list.add(administrator.getName());
        list.add(administrator.getPassword());
        list.add(administrator.getType());
        list.add(administrator.getDel());
        list.add(administrator.getCreateTime());
        int res = executeUpdate(sql, list);
        closeAll();
        return res;
    }

}
