package com.yvan.dao.impl;

import com.yvan.dao.CommentDao;
import com.yvan.entity.Comment;
import com.yvan.util.SqlUtil;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Yvan
 * @Description CommentDao 的 实现类
 * @Classname CommentDaoImpl
 * @Date 2020/8/19 14:38
 */
public class CommentDaoImpl extends BaseDao implements CommentDao {
    @Override
    public int save(int uid, int bid, String content) {
        String sql = SqlUtil.insert("comment","uid,bid,content","?,?,?");
        List<Object> list = new ArrayList<>();
        list.add(uid);
        list.add(bid);
        list.add(content);
        int res = executeUpdate(sql,list);
        closeAll();
        return res;
    }

    @Override
    public List<Comment> findByBid(int bid) {
        String sql = SqlUtil.select("id,uid,content", "comment", "bid = ?");
        List<Object> list = new ArrayList<>();
        list.add(bid);
        List<Comment> resComments = new ArrayList<>();
        executeQuery(sql,list);
        try {
            while (rs.next()) {
                int id = rs.getInt("id");
                int uid = rs.getInt("uid");
                String content = rs.getString("content");
                resComments.add(new Comment(id, uid, bid, content));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeAll();
        }
        return resComments;
    }
}
