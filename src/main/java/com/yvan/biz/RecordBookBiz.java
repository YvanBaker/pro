package com.yvan.biz;

import com.yvan.entity.Book;
import com.yvan.entity.RecordView;
import com.yvan.entity.User;

import java.util.List;

/**
 * @author Yvan
 * @Description 借书的业务逻辑
 * @Classname RecordBookBiz
 * @Date 2020/8/17 10:00
 */
public interface RecordBookBiz {

    /**
     * 借书的业务逻辑
     *
     * @param book 书
     * @param user 人
     * @return 1 失败 没有书; 2 库存不足; 3 金额不足 ; 4 存在没有还的记录; 5 借书记录保存失败； 6 成功
     */
    int borrow(Book book, User user);

    /**
     * 还书的业务逻辑
     *
     * @param record 记录
     * @param user   用户
     * @return false 失败
     */
    boolean returnBook(RecordView record, User user);

    /**
     * 查询没有还的记录
     *
     * @param user 用户
     * @return 记录集合
     */
    List<RecordView> showBorrowNotReturnRecord(User user);

    /**
     * 根据 字符串 查询没有还的记录
     *
     * @param user 用户
     * @param str  字符串
     * @return 记录集合
     */
    List<RecordView> findNotReturnByString(User user, String str);
}
