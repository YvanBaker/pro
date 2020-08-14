package com.yvan.biz.impl;

import com.yvan.biz.UserBiz;
import com.yvan.dao.UserDao;
import com.yvan.dao.impl.UserDaoImpl;
import com.yvan.entity.User;


public class UserBizImpl implements UserBiz {
    private UserDao userDao = new UserDaoImpl();

    @Override
    public boolean registered(String name, String password) {

        if (userDao.findByName(name) != null) {
            return false;
        }
        return userDao.save(name, password);
    }

    @Override
    public User login(String name, String password) {
        User user = userDao.findByName(name);
        if (user == null) {
            return null;
        }
        String dataPassword = user.getPassword();
        if (!password.equals(dataPassword)) {
            return null;
        }
        return user;
    }
}
