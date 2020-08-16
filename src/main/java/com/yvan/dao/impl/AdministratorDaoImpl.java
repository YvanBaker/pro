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
    public Administrator findByName(String name) {
        Administrator administrator = null;
        String sql = "select id,name,password,type,del from administrator where name = ?";
        List<Object> list = new ArrayList<>();
        list.add(name);
        executeQuery(sql,list);
        try {
            while (rs.next()) {
                int id = rs.getInt("id");
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
    public Administrator findAllById(int id) {
        Administrator administrator = null;
        String field = "id,name,password,type,del";
        String table = "administrator";
        String term = "id = ?";
        String sql = SqlUtil.select(field,table,term);
        List<Object> list = new ArrayList<>();
        list.add(id);
        executeQuery(sql,list);
        try {
            rs.next();
            String name = rs.getString("name");
            String password = rs.getString("password");
            String type = rs.getString("type");
            boolean del = rs.getBoolean("del");
            administrator = new Administrator(id, name, password, type, del);
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
        String sql = SqlUtil.update(table,field,term);
        List<Object> list = new ArrayList<>();
        list.add(newPassword);
        list.add(administrator.getId());
        int res = executeUpdate(sql,list);
        closeAll();
        return res;
    }

    @Override
    public boolean save(Administrator administrator) {
        return false;
    }

}
