package com.yvan.biz;

import com.yvan.entity.Administrator;

/**
 * @author Yvan
 */
public interface AdministratorBiz {

    /**
     * 管理员登录
     *
     * @param name     账户名
     * @param password 密码
     * @param type     账户类型
     * @return 登录成功返回一个管理员账号
     */
    public Administrator login(String name, String password, String type);
}
