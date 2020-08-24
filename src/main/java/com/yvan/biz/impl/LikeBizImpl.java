package com.yvan.biz.impl;

import com.yvan.biz.LikeBiz;
import com.yvan.dao.BookDao;
import com.yvan.dao.CollectionDao;
import com.yvan.dao.ReservationDao;
import com.yvan.dao.impl.BookDaoImpl;
import com.yvan.dao.impl.CollectionDaoImpl;
import com.yvan.dao.impl.ReservationDaoImpl;
import com.yvan.entity.Book;
import com.yvan.entity.Collection;
import com.yvan.entity.Reservation;
import com.yvan.entity.User;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Yvan
 * @Description 喜欢
 * @Classname LikeBizImpl
 * @Date 2020/8/24 9:42
 */
public class LikeBizImpl implements LikeBiz {
    private final int SIZE = 5;

    private final CollectionDao collectionDao = new CollectionDaoImpl();
    private final ReservationDao reservationDao = new ReservationDaoImpl();
    private final BookDao bookDao = new BookDaoImpl();

    @Override
    public List<Book> like(User user) {
        List<Collection> dataBook = collectionDao.findByUid(user.getId());
        List<Book> res = new ArrayList<>();
        for (Collection collection : dataBook) {
            res.add(bookDao.findById(collection.getBid()));
        }
        if (res.size() > SIZE) {
            return res;
        }
        List<Reservation> dataReservation = reservationDao.findByUid(user.getId());
        for (Reservation reservation : dataReservation) {
            res.add(bookDao.findById(reservation.getBid()));
        }
        return res;
    }
}
