package com.yvan.dao;

import com.yvan.entity.Administrator;

/**
 * @author Yvan
 * @Description 操作 Administrator表（管理员） 的 dao 层
 */
public interface AdministratorDao {

    /**
     * 根据名字查询数据
     * 数据操作层
     *
     * @param name 查询的名字
     * @param type 类型
     * @return 查询出的用户
     */
    Administrator findByName(String name, String type);

    /**
     * 根据 id 查询数据
     *
     * @param id id
     * @return administrator 对象
     */
    Administrator findAllById(int id);

    /**
     * 更改 administrator 密码
     * 数据操作层
     *
     * @param administrator administrator对象
     * @param newPassword   新的密码
     * @return 新的administrator对象
     */
    int changePassword(Administrator administrator, String newPassword);

    /**
     * 保存 administrator对象
     * 数据操作层
     * name,password,type,del,create_time 成员必须有值 ， 且del 为 false
     *
     * @param administrator administrator 对象
     * @return true 成功保存
     */
    int save(Administrator administrator);
}
