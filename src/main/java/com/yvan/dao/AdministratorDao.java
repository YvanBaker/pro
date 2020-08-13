package com.yvan.dao;

import com.yvan.entity.Administrator;

public interface AdministratorDao {

    public Administrator findByName(String name);

    public Administrator changePassword(Administrator administrator,String newPassword);

    public boolean save(Administrator administrator);
}
