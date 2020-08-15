package com.yvan.biz;

import com.yvan.entity.User;

/**
 * @author Yvan
 */

public interface UserBiz {

    /**
     * 用户注册的业务逻辑
     *
     * @param name     用户名
     * @param password 密码
     * @return true 成功注册
     */
    public boolean registered(String name, String password);

    /**
     * 用户登录的业务逻辑
     *
     * @param name     用户名
     * @param password 密码
     * @return 成功登录时返回 User对象
     */
    public User login(String name, String password);
}
