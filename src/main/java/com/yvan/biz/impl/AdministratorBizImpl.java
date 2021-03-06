package com.yvan.biz.impl;

import com.yvan.biz.AdministratorBiz;
import com.yvan.dao.AdministratorDao;
import com.yvan.dao.impl.AdministratorDaoImpl;
import com.yvan.entity.Administrator;
import com.yvan.entity.UserType;
import com.yvan.util.Md5Util;

import java.sql.Timestamp;

/**
 * @author Yvan
 */
public class AdministratorBizImpl implements AdministratorBiz {

    private final AdministratorDao administratorDao = new AdministratorDaoImpl();


    @Override
    public boolean registered(String name, String password, UserType type) {
        Administrator administrator = administratorDao.findByName(name, type.getType());
        if (administrator != null) {
            return false;
        }
        password = Md5Util.md5(password);
        Timestamp data = new Timestamp(System.currentTimeMillis());
        administrator = new Administrator(name, password, type.getType(), false, data);
        return administratorDao.save(administrator) > 0;
    }

    @Override
    public Administrator login(String name, String password, String type) {
        Administrator administrator = administratorDao.findByName(name, type);
        if (administrator == null) {
            return null;
        }
        password = Md5Util.md5(password);
        String dataPassword = administrator.getPassword();
        String dataType = administrator.getType();
        assert password != null;
        if (!password.equals(dataPassword) || !type.equals(dataType)) {
            return null;
        }
        return administrator;
    }

    @Override
    public boolean changePassword(Administrator administrator, String newPassword) {
        newPassword = Md5Util.md5(newPassword);
        int i = administratorDao.changePassword(administrator, newPassword);
        System.out.println(i);
        return i > 0;
    }

    @Override
    public Administrator updateAdministrator(int id) {
        return administratorDao.findAllById(id);
    }
}
