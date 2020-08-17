package com.yvan.biz.impl;

import com.yvan.biz.BorrowBookBiz;
import com.yvan.dao.BookDao;
import com.yvan.dao.RecordDao;
import com.yvan.dao.UserDao;
import com.yvan.dao.impl.BookDaoImpl;
import com.yvan.dao.impl.RecordDaoImpl;
import com.yvan.dao.impl.UserDaoImpl;
import com.yvan.entity.Book;
import com.yvan.entity.User;

import java.sql.Timestamp;

/**
 * @author Yvan
 * @Description BorrowBookBiz 的实现类
 * @Classname BorrowBookBizImpl
 * @Date 2020/8/17 10:02
 */
public class BorrowBookBizImpl implements BorrowBookBiz {
    private final BookDao bookDao = new BookDaoImpl();
    private final UserDao userDao = new UserDaoImpl();
    private final RecordDao recordDao = new RecordDaoImpl();

    @Override
    public synchronized int borrow(Book book, User user) {
        Integer count = bookDao.findCountById(book.getId());
        if (count == null) {
            return 1;
        }
        if (count <= 0) {
            return 2;
        }
        if (book.getBookDeposit() > user.getBalance()) {
            return 3;
        }
        Timestamp lendTime = new Timestamp(System.currentTimeMillis());
        //七天后时间
        long time = lendTime.getTime() + 7 * 86400000;
        Timestamp returnTime = new Timestamp(time);
        int i = recordDao.save(book.getId(), user.getId(), lendTime, returnTime, book.getBookDeposit());
        if (i <= 0) {
            return 4;
        }
        bookDao.updateCount(book.getId(), count - 1);
        float newPoint = user.getPoint() + 10;
        double newBalance = user.getBalance() - book.getBookDeposit();
        userDao.updatePointBalance(user.getId(), newPoint, newBalance);
        return 5;
    }
}
