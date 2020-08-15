package com.yvan.dao;

import com.yvan.entity.Administrator;

/**
 * @author Yvan
 */
public interface AdministratorDao {

    /**
     * 根据名字查询数据
     * 数据操作层
     *
     * @param name 查询的名字
     * @return 查询出的用户
     */
    public Administrator findByName(String name);

    /**
     * 更改 administrator 密码
     * 数据操作层
     *
     * @param administrator administrator对象
     * @param newPassword   新的密码
     * @return 新的administrator对象
     */
    public Administrator changePassword(Administrator administrator, String newPassword);

    /**
     * 保存 administrator对象
     * 数据操作层
     *
     * @param administrator administrator 对象
     * @return true 成功保存
     */
    public boolean save(Administrator administrator);
}
