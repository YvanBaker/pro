package com.yvan.dao;

import com.yvan.entity.User;

public interface UserDao {


    public User findByName(String name);

    public boolean save(String name, String password);
}
