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
    boolean registered(String name, String password);

    /**
     * 用户登录的业务逻辑
     *
     * @param name     用户名
     * @param password 密码
     * @return 成功登录时返回 User对象
     */
    User login(String name, String password);

    /**
     * 修改密码的业务逻辑
     *
     * @param user        用户
     * @param newPassword 新密码
     * @return false 失败
     */
    boolean changePassword(User user, String newPassword);

    /**
     * 根据 id 当前 user 账号信息
     *
     * @param id id
     * @return user对象
     */
    User updateUser(int id);
}
