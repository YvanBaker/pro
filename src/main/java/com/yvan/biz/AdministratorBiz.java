package com.yvan.biz;

import com.yvan.entity.Administrator;

public interface AdministratorBiz {
    public Administrator login(String name,String password,String type);
}
