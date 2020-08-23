package com.yvan.biz.impl;

import com.yvan.biz.ReservationBiz;
import com.yvan.dao.BookDao;
import com.yvan.dao.ReservationDao;
import com.yvan.dao.impl.BookDaoImpl;
import com.yvan.dao.impl.ReservationDaoImpl;
import com.yvan.entity.Book;
import com.yvan.entity.Reservation;
import com.yvan.entity.User;
import com.yvan.util.TimeUtil;
import org.jetbrains.annotations.NotNull;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Yvan
 * @Description 预约 的业务逻辑层 实现类
 * @Classname ReservationBizImpl
 * @Date 2020/8/18 23:11
 */
public class ReservationBizImpl implements ReservationBiz {
    private final BookDao bookDao = new BookDaoImpl();
    private final ReservationDao reservationDao = new ReservationDaoImpl();

    @Override
    public boolean reservation(@NotNull User user, @NotNull Book book, Date time) {
        Timestamp reservationTime = TimeUtil.dataTurnTimestamp(time);
        System.out.println(user.getId()+"  "+book.getId());
        List<Reservation> dataReservation = reservationDao.findByUidBid(user.getId(),book.getId());
        for (Reservation reservation : dataReservation) {
            if (!reservation.isFulfill()){
                return false;
            }
        }
        int res = reservationDao.save(user.getId(),book.getId(), reservationTime);
        return res > 0;
    }

    @Override
    public List<Book> findReservation(User user) {
        List<Reservation> data = reservationDao.findByUid(user.getId());
        if (data.isEmpty()){
            return null;
        }
        List<Reservation> newData = new ArrayList<>();
        for (Reservation datum : data) {
            if (datum.isFulfill()){
                continue;
            }
            if (TimeUtil.timeMoreCurrent(datum.getTime())){
                continue;
            }
            newData.add(datum);
        }
        if (newData.isEmpty()){
            return null;
        }
        List<Book> resBooks = new ArrayList<>();
        for (Reservation newDatum : newData) {
            Book book = bookDao.findById(newDatum.getBid());
            if (book.getCount() == 0){
                continue;
            }
            resBooks.add(book);
        }
        return resBooks;
    }
}
