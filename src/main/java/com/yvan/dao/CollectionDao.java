package com.yvan.dao;

import com.yvan.entity.Collection;

import java.sql.Timestamp;
import java.util.List;

/**
 * @author Yvan
 * @Description Collection表（收藏） 的 dao层
 * @Classname CollectionDao
 * @Date 2020/8/18 13:11
 */
public interface CollectionDao {

    /**
     * 保存记录
     *
     * @param uid       uid
     * @param bid       bid
     * @param createTime 时间
     * @return 记录数
     */
    int save(int uid, int bid, Timestamp createTime);

    /**
     * 根据 uid 查询数据
     *
     * @param uid 用户id
     * @return Collection 集合
     */
    List<Collection> findByUid(int uid);


    /**
     * 根据 uid和bid查询数据
     *
     * @param bid 书的 id
     * @param uid 用户 id
     * @return Collection 数据
     */
    Collection findByBidUid(int bid, int uid);

    /**
     * 更新 del 字段为 true 状态
     *
     * @param uid       uid
     * @param bid       bid
     * @param time 时间
     * @return 条数
     */
    int updateDelTrue(int uid, int bid, Timestamp time);

    /**
     * 更新 del 字段为 false 状态
     *
     * @param uid     uid
     * @param bid     bid
     * @param time 时间
     * @return 条数
     */
    int updateDelFalse(int uid, int bid, Timestamp time);
}
