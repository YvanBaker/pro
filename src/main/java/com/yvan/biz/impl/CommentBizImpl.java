package com.yvan.biz.impl;

import com.yvan.biz.CommentBiz;
import com.yvan.dao.CommentDao;
import com.yvan.dao.impl.CommentDaoImpl;
import com.yvan.entity.Book;
import com.yvan.entity.Comment;
import com.yvan.entity.RecordView;
import com.yvan.entity.User;
import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * @author Yvan
 * @Description TODO
 * @Classname CommentBizImpl
 * @Date 2020/8/19 14:47
 */
public class CommentBizImpl implements CommentBiz {
    private final CommentDao commentDao = new CommentDaoImpl();

    @Override
    public boolean createComment(@NotNull User user, @NotNull RecordView record, String content) {
        int uid = user.getId();
        int bid = record.getBid();
        return commentDao.save(uid, bid, content) > 0;
    }

    @Override
    public List<Comment> getContent(@NotNull Book book) {

        return commentDao.findByBid(book.getId());
    }
}
