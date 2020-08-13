package com.yvan.dao;

import com.yvan.entity.User;

import java.sql.Timestamp;

public interface UserDao {

    public User findByName(String name);

    public boolean save(String name, String password, Timestamp timestamp);
}
