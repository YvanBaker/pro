package com.yvan.dao.impl;

import com.yvan.dao.AdministratorDao;
import com.yvan.entity.Administrator;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AdministratorDaoImpl extends BaseDao implements AdministratorDao {

    /**
     * 根据名字查询数据
     *
     * @param name
     * @return
     */
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
    public Administrator changePassword(Administrator administrator, String newPassword) {
        return null;
    }

    @Override
    public boolean save(Administrator administrator) {
        return false;
    }

}
