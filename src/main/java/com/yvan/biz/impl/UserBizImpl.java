package com.yvan.biz.impl;

import com.yvan.biz.UserBiz;
import com.yvan.dao.UserDao;
import com.yvan.dao.impl.UserDaoImpl;
import com.yvan.entity.User;
import com.yvan.util.Md5Util;

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
        password = Md5Util.MD5(password);
        return userDao.save(name, password);
    }

    @Override
    public User login(String name, String password) {
        User user = userDao.findByName(name);
        if (user == null) {
            return null;
        }
        password = Md5Util.MD5(password);
        String dataPassword = user.getPassword();
        assert password != null;
        if (!password.equals(dataPassword)) {
            return null;
        }
        return user;
    }

    @Override
    public boolean changePassword(User user, String newPassword) {
        newPassword = Md5Util.MD5(newPassword);
        int i = userDao.changePassword(user,newPassword);
        return i > 0;
    }

    @Override
    public User updateUser(int id) {
        return userDao.findAllById(id);
    }
}
