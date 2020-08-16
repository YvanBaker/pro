package com.yvan.biz.impl;

import com.yvan.biz.UserBiz;
import com.yvan.dao.UserDao;
import com.yvan.dao.impl.UserDaoImpl;
import com.yvan.entity.User;

/**
 * @author Yvan
 */

public class UserBizImpl implements UserBiz {
    private final UserDao userDao = new UserDaoImpl();

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

    @Override
    public boolean changePassword(User user, String newPassword) {
        int i = userDao.changePassword(user,newPassword);
        return i > 0;
    }

    @Override
    public User updateUser(int id) {
        return userDao.findAllById(id);
    }
}
