package com.yvan.dao;

import com.yvan.entity.Freeze;

import java.sql.Timestamp;

/**
 * @author Yvan
 * @Description Freeze 表 （冻结表） 的 dao 层
 * @Classname FreezeDao
 * @Date 2020/8/20 10:19
 */
public interface FreezeDao {
    /**
     * 插入用户冻结记录
     *
     * @param uid    用户id
     * @param time   时间
     * @param reason 原因
     * @return 条数
     */
    int inset(int uid, Timestamp time, String reason);

    /**
     * 根据 uid 查询 正在冻结的记录
     *
     * @param uid uid
     * @return freeze 条数
     */
    Freeze findFlagFalseByUid(int uid);

    /**
     * 修改 flag 字段为 true
     *
     * @param id     id
     * @param time   时间
     * @param reason 原因
     * @return 条数
     */
    int updateFlagTrue(int id, Timestamp time, String reason);
}
