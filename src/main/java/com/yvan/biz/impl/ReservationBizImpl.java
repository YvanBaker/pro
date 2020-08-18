package com.yvan.biz.impl;

import com.yvan.biz.ReservationBiz;
import com.yvan.dao.ReservationDao;
import com.yvan.dao.impl.ReservationDaoImpl;
import com.yvan.entity.Book;
import com.yvan.entity.Reservation;
import com.yvan.entity.User;
import com.yvan.util.TimeUtil;
import org.jetbrains.annotations.NotNull;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
 * @author Yvan
 * @Description TODO
 * @Classname ReservationBizImpl
 * @Date 2020/8/18 23:11
 */
public class ReservationBizImpl implements ReservationBiz {
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
}
