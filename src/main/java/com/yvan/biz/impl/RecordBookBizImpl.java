package com.yvan.biz.impl;

import com.yvan.biz.RecordBookBiz;
import com.yvan.dao.BookDao;
import com.yvan.dao.RecordDao;
import com.yvan.dao.UserDao;
import com.yvan.dao.impl.BookDaoImpl;
import com.yvan.dao.impl.RecordDaoImpl;
import com.yvan.dao.impl.UserDaoImpl;
import com.yvan.entity.Book;
import com.yvan.entity.RecordView;
import com.yvan.entity.User;
import com.yvan.util.TimeUtil;
import org.jetbrains.annotations.NotNull;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Yvan
 * @Description RecordBookBiz 的实现类
 * @Classname RecordBookBizImpl
 * @Date 2020/8/17 10:02
 */
public class RecordBookBizImpl implements RecordBookBiz {
    private final BookDao bookDao = new BookDaoImpl();
    private final UserDao userDao = new UserDaoImpl();
    private final RecordDao recordDao = new RecordDaoImpl();

    @Override
    public synchronized int borrow(@NotNull Book book, User user) {
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


        //查询记录
        List<RecordView> record = recordDao.findIdByUidBid(user.getId(), book.getId());
        for (RecordView recordView : record) {
            if (!recordView.isReturn()) {
                return 4;
            }
        }

        Timestamp lendTime = new Timestamp(System.currentTimeMillis());
        //七天后时间
        long time = TimeUtil.getDay(lendTime, 7);
        Timestamp returnTime = new Timestamp(time);
        int i = recordDao.save(book.getId(), user.getId(), lendTime, returnTime, book.getBookDeposit());
        if (i <= 0) {
            return 5;
        }
        bookDao.updateCount(book.getId(), count - 1);
        bookDao.updateTimes(book.getId(), book.getTimes() + 1);
        bookDao.updateHasLended(book.getId(), book.getHasLended() + 1);

        float newPoint = user.getPoint() + 10;
        double newBalance = user.getBalance() - book.getBookDeposit();
        userDao.updatePointBalance(user.getId(), newPoint, newBalance);
        return 6;
    }

    @Override
    public synchronized boolean returnBook(RecordView record, User user) {
        int res = recordDao.updateIsReturn(record.getId(), true);
        if (res <= 0) {
            return false;
        }
        Timestamp returnTime = new Timestamp(System.currentTimeMillis());
        int id = record.getId();
        int bid = record.getBid();
        int uid = record.getUid();
        int count = bookDao.findCountById(bid);
        int times = bookDao.findTimesById(bid);

        recordDao.updateActualTime(id, returnTime);
        recordDao.updateReturnTerm(id, record.getDeposit());

        bookDao.updateCount(bid, count + 1);
        bookDao.updateTimes(bid, times - 1);

        userDao.updateBalance(uid, user.getBalance() + record.getDeposit());
        return true;
    }

    @Override
    public List<RecordView> showBorrowNotReturnRecord(@NotNull User user) {
        List<RecordView> dateRecord = recordDao.findAllByUid(user.getId());
        List<RecordView> resRecord = new ArrayList<>();
        for (RecordView recordView : dateRecord) {
            if (!recordView.isReturn()) {
                resRecord.add(recordView);
            }
        }
        return resRecord;
    }

    @Override
    public List<RecordView> findNotReturnByString(User user, String str) {
        List<RecordView> dataRecord = recordDao.findAllByStr(user.getId(), str);
        List<RecordView> resRecord = new ArrayList<>();
        for (RecordView recordView : dataRecord) {
            if (!recordView.isReturn()) {
                resRecord.add(recordView);
            }
        }
        return resRecord;
    }

}
