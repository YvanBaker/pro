package com.yvan.dao;

import com.yvan.entity.Record;
import com.yvan.entity.RecordView;

import java.sql.Timestamp;
import java.util.List;

/**
 * @author Yvan
 * @Description 操作 Record表（借书） 的 dao 层
 * @Classname RecordDao
 * @Date 2020/8/17 10:04
 */
public interface RecordDao {

    /**
     * 保存借书记录
     *
     * @param bookId     书的id
     * @param userId     用户id
     * @param lendTime   借阅时间
     * @param returnTime 应归还时间
     * @param deposit    交纳的押金金额
     * @return 条数
     */
    int save(int bookId, int userId, Timestamp lendTime, Timestamp returnTime, float deposit);

    /**
     * 根据id查询信息
     *
     * @param id id
     * @return record 记录
     */
    Record findAllById(int id);

    /**
     * 根据 用户id 查询记录
     *
     * @param uid 用户 id
     * @return record 记录
     */
    List<RecordView> findAllByUid(int uid);

    /**
     * 根据 用户id 和 书id 查询记录
     *
     * @param uid 用户id
     * @param bid 书 id
     * @return 结果集
     */
    List<RecordView> findIdByUidBid(int uid, int bid);

    /**
     * 根据 用户id 和 字符串 查询记录
     *
     * @param uid 用户id
     * @param str 字符串
     * @return record 记录
     */
    List<RecordView> findAllByStr(int uid, String str);

    /**
     * 修改还书状态
     *
     * @param id       记录id
     * @param isReturn 状态
     * @return 影响条数
     */
    int updateIsReturn(int id, boolean isReturn);

    /**
     * 根据 id 修改 实际还书时间
     *
     * @param id         id
     * @param actualTime 修改后的值
     * @return 条数
     */
    int updateActualTime(int id, Timestamp actualTime);

    /**
     * 修改 实际退款金额
     *
     * @param id         id
     * @param returnTerm 修改后金额
     * @return 条数
     */
    int updateReturnTerm(int id, float returnTerm);

    /**
     * 更改 renew 状态为 true
     *
     * @param id id
     * @return 条数
     */
    int updateRenewTrue(int id);

    /**
     * 修改 应该归还时间
     *
     * @param id   id
     * @param time 时间
     * @return 条数
     */
    int updateReturnTime(int id, Timestamp time);
}
