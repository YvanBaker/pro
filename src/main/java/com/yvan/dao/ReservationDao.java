package com.yvan.dao;

import com.yvan.entity.Reservation;

import java.sql.Timestamp;
import java.util.List;

/**
 * @author Yvan
 * @Description Reservation表（预约） 的 dao层
 * @Classname ReservationDao
 * @Date 2020/8/18 23:00
 */
public interface ReservationDao {

    /**
     * 保存 预约 记录
     *
     * @param uid  uid
     * @param bid  bid
     * @param time 时间
     * @return 条数
     */
    int save(int uid, int bid, Timestamp time);

    /**
     * 根据 bid 查询 预约记录
     *
     * @param bid bid
     * @return Reservation 记录
     */
    List<Reservation> findByBid(int bid);

    /**
     * 更加 uid 和 bid 查询 预约记录
     *
     * @param uid uid
     * @param bid bid
     * @return Reservation 集合
     */
    List<Reservation> findByUidBid(int uid, int bid);

    /**
     * 更改 fulfill 字段为 true
     *
     * @param uid uid
     * @param bid bid
     * @return 条数
     */
    int updateFulfillTrue(int uid, int bid);
}
