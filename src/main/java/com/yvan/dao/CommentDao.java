package com.yvan.dao;

import com.yvan.entity.Comment;

import java.util.List;

/**
 * @author Yvan
 * @Description Comment 表 （评论）的 Dao层
 * @Classname CommentDao
 * @Date 2020/8/19 14:36
 */
public interface CommentDao {

    /**
     * 保存 评论 数据
     *
     * @param uid     uid
     * @param bid     bid
     * @param content 内容
     * @return 条数
     */
    int save(int uid, int bid, String content);

    /**
     * 根据 书的 id 查询记录
     *
     * @param bid 书 id
     * @return comment 集
     */
    List<Comment> findByBid(int bid);
}
