package com.yvan.biz;

import com.yvan.entity.Book;
import com.yvan.entity.User;

/**
 * @author Yvan
 * @Description 借书的业务逻辑
 * @Classname BorrowBookBiz
 * @Date 2020/8/17 10:00
 */
public interface BorrowBookBiz {

    /**
     * 借书的业务逻辑
     *
     * @param book 书
     * @param user 人
     * @return 1 失败 没有书; 2 库存不足; 3 金额不足 ; 4 借书记录保存失败； 5 成功
     */
    int borrow(Book book, User user);
}
