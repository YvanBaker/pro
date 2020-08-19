package com.yvan.biz;

import com.yvan.entity.Book;
import com.yvan.entity.Comment;
import com.yvan.entity.RecordView;
import com.yvan.entity.User;

import java.util.List;

/**
 * @author Yvan
 * @Description TODO
 * @Classname CommentBiz
 * @Date 2020/8/19 14:44
 */
public interface CommentBiz {

    /**
     * 创建新的评论
     *
     * @param user    user
     * @param record  record
     * @param content 内容
     * @return true 成功
     */
    boolean createComment(User user, RecordView record, String content);

    /**
     * 获取这本书的评论集
     *
     * @param book 书
     * @return 评论 集
     */
    List<Comment> getContent(Book book);
}
