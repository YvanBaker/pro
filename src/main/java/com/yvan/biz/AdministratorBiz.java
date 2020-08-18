package com.yvan.biz;

import com.yvan.entity.Administrator;

/**
 * @author Yvan
 */
public interface AdministratorBiz {

    /**
     * 管理员注册的业务逻辑
     *
     * @param name     用户名
     * @param password 密码
     * @param type     类型
     * @return true 成功注册
     */
    boolean registered(String name, String password, String type);

    /**
     * 管理员登录的业务逻辑
     *
     * @param name     账户名
     * @param password 密码
     * @param type     账户类型
     * @return 登录成功返回一个管理员账号
     */
    Administrator login(String name, String password, String type);

    /**
     * 更改密码的业务逻辑
     *
     * @param administrator 账户
     * @param newPassword   新密码
     * @return false 失败
     */
    boolean changePassword(Administrator administrator, String newPassword);

    /**
     * 根据 id 更新 Administrator 用户信息
     *
     * @param id id
     * @return Administrator 对象
     */
    Administrator updateAdministrator(int id);
}
