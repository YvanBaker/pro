package com.yvan.biz;

import com.yvan.entity.Book;
import com.yvan.entity.User;

import java.util.List;

/**
 * @author Yvan
 * @Description 猜你喜欢
 * @Classname LinkBiz
 * @Date 2020/8/24 9:39
 */
public interface LikeBiz {
    /**
     * 猜你喜欢
     *
     * @param user 用户
     * @return book 列表
     */
    List<Book> like(User user);
}
