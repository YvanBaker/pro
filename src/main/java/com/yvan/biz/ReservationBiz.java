package com.yvan.biz;

import com.yvan.entity.Book;
import com.yvan.entity.User;

import java.util.Date;
import java.util.List;

/**
 * @author Yvan
 * @Description 预约 的业务逻辑层
 * @Classname ReservationBiz
 * @Date 2020/8/18 23:10
 */
public interface ReservationBiz {
    /**
     * 预约的业务逻辑
     *
     * @param user user
     * @param book 书
     * @param time 时间
     * @return true 成功
     */
    boolean reservation(User user, Book book, Date time);

    /**
     * 查记录
     *
     * @param user 用户
     * @return 条数
     */
    List<Book> findReservation(User user);
}
