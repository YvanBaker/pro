package com.yvan.dao.impl;

import com.yvan.dao.AdministratorDao;
import com.yvan.entity.Administrator;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
        PreparedStatement ps = null;
        ResultSet rs = null;
        getConn();
        String sql = "select id,name,password,type,del from administrator where name = ?";

        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, name);
            rs = ps.executeQuery();
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
            closeConn();
            closeIter(ps, rs);
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
