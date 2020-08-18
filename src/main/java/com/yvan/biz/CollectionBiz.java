package com.yvan.biz;

import com.yvan.entity.Book;
import com.yvan.entity.User;

import java.util.Map;

/**
 * @author Yvan
 * @Description Collection 的业务逻辑的抽象类
 * @Classname CollectionBiz
 * @Date 2020/8/18 13:06
 */
public interface CollectionBiz {

    /**
     * 保存收藏状态
     *
     * @param book book
     * @param flag flag
     * @return true 成功
     */
    boolean save(Book book, boolean flag);

    /**
     * 根据 用户 查询 记录的业务逻辑
     *
     * @param user 用户
     * @return Map<Book, Boolean>
     */
    Map<Integer, Boolean> findByUser(User user);

    /**
     * 更改 del 状态
     *
     * @param user 用户
     * @param book 书
     * @param flag 值
     * @return true 成功
     */
    boolean updateDel(User user, Book book, boolean flag);
}
