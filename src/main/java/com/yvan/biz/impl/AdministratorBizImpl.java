package com.yvan.biz.impl;

import com.yvan.biz.AdministratorBiz;
import com.yvan.dao.AdministratorDao;
import com.yvan.dao.impl.AdministratorDaoImpl;
import com.yvan.entity.Administrator;

/**
 * @author Yvan
 */
public class AdministratorBizImpl implements AdministratorBiz {

    private AdministratorDao administratorDao = new AdministratorDaoImpl();

    @Override
    public Administrator login(String name, String password, String type) {
        Administrator administrator = administratorDao.findByName(name);
        if (administrator == null){
            return null;
        }
        String dataPassword = administrator.getPassword();
        String dataType = administrator.getType();
        if (!password.equals(dataPassword) || !type.equals(dataType)){
            return null;
        }
        return administrator;
    }
}
