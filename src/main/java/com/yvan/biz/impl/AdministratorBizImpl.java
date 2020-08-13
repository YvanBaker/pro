package com.yvan.biz.impl;

import com.yvan.biz.AdministratorBiz;
import com.yvan.dao.AdministratorDao;
import com.yvan.dao.impl.AdministratorDaoImpl;
import com.yvan.entity.Administrator;

public class AdministratorBizImpl implements AdministratorBiz {

    private AdministratorDao administratorDao = new AdministratorDaoImpl();
    /**
     * 管理员登录
     * @param name 账户名
     * @param password 密码
     * @param type 账户类型
     * @return 登录成功返回一个管理员账号
     */
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
