package com.yvan.biz;

import com.yvan.entity.User;

public interface UserBiz {

    public boolean registered(String name, String password);

    public User login(String name, String password);
}
