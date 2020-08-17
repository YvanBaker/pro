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
    User findByName(String name);

    /**
     * 根据 id 查找数据
     * 数据操作层
     *
     * @param id id
     * @return user 对象
     */
    User findAllById(int id);

    /**
     * 保存用户信息
     * 数据操作层
     *
     * @param name     用户名
     * @param password 密码
     * @return true 保存成功
     */
    boolean save(String name, String password);

    /**
     * 根据 user 对象修改 密码
     *
     * @param user        用户
     * @param newPassword 新密码
     * @return 影响条数
     */
    int changePassword(User user, String newPassword);

    /**
     * 修改 Point Balance 字段
     *
     * @param id      用户id
     * @param point   修改积分
     * @param balance 修改后的余额
     * @return 条数
     */
    int updatePointBalance(int id, float point, double balance);

    /**
     * 修改 余额
     *
     * @param id      id
     * @param balance 修改后的余额
     * @return 条数
     */
    int updateBalance(int id, double balance);
}
