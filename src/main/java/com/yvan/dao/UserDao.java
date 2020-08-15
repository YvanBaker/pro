package com.yvan.dao;

import com.yvan.entity.User;

/**
 * @author Yvan
 */

public interface UserDao {


    /**
     * 根据用户名查找用户
     * 数据操作层
     *
     * @param name 用户名
     * @return 找到返回 User对象 ，没找到返回 null
     */
    public User findByName(String name);

    /**
     * 保存用户信息
     * 数据操作层
     *
     * @param name     用户名
     * @param password 密码
     * @return true 保存成功
     */
    public boolean save(String name, String password);
}
