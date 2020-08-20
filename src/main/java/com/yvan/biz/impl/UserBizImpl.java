package com.yvan.biz.impl;

import com.yvan.biz.UserBiz;
import com.yvan.dao.FreezeDao;
import com.yvan.dao.UserDao;
import com.yvan.dao.impl.FreezeDaoImpl;
import com.yvan.dao.impl.UserDaoImpl;
import com.yvan.entity.Freeze;
import com.yvan.entity.User;
import com.yvan.util.Md5Util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Yvan
 */
@SuppressWarnings("All")
public class UserBizImpl implements UserBiz {
    private final UserDao userDao = new UserDaoImpl();
    private final FreezeDao freezeDao = new FreezeDaoImpl();

    @Override
    public boolean registered(String name, String password) {
        if (userDao.findByName(name) != null) {
            return false;
        }
        password = Md5Util.md5(password);
        return userDao.save(name, password);
    }

    @Override
    public User login(String name, String password) {
        User user = userDao.findByName(name);
        if (user == null) {
            return null;
        }
        password = Md5Util.md5(password);
        String dataPassword = user.getPassword();
        assert password != null;
        if (!password.equals(dataPassword)) {
            return null;
        }
        Freeze dateFreeze = freezeDao.findFlagFalseByUid(user.getId());
        if (dataPassword != null) {
            user.setFreeze(dateFreeze.getFreezeReason());
            user.setFreezeTime(dateFreeze.getFreezeTime());
        }
        return user;
    }

    @Override
    public boolean changePassword(User user, String newPassword) {
        newPassword = Md5Util.md5(newPassword);
        int i = userDao.changePassword(user, newPassword);
        return i > 0;
    }

    @Override
    public User updateUser(int id) {
        return userDao.findAllById(id);
    }

    @Override
    public Map<User, Freeze> userFreezeList() {
        List<User> dateUserList = userDao.findAll();
        Map<User, Freeze> userFreezeMap = new HashMap<>(12);
        for (User user : dateUserList) {
            if (!user.getDel()) {
                userFreezeMap.put(user, freezeDao.findFlagFalseByUid(user.getId()));
            }
        }
        return userFreezeMap;
    }

    @Override
    public Map<User, Freeze> userFreezeList(String str) {
        List<User> dateUserList = userDao.fuzzyFindByName(str);
        Map<User,Freeze> userFreezeMap = new HashMap<>(12);
        for (User user : dateUserList) {
            if (!user.getDel()){
                userFreezeMap.put(user,freezeDao.findFlagFalseByUid(user.getId()));
            }
        }
        return userFreezeMap;
    }

    @Override
    public boolean initializePassword(int id) {
        String initializePassword = Md5Util.md5("123456");
        int i = userDao.changePassword(new User(id), initializePassword);
        return i > 0;
    }


}
