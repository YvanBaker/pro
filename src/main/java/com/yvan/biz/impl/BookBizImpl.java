package com.yvan.biz.impl;

import com.yvan.biz.BookBiz;
import com.yvan.dao.BookDao;
import com.yvan.dao.impl.BookDaoImpl;
import com.yvan.entity.Book;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

public class BookBizImpl implements BookBiz {

    private BookDao bookDao = new BookDaoImpl();

    @Override
    public boolean add(String bookName, String author, String press, int total, Date publicationDate, String type) {
        Timestamp pu = new Timestamp(publicationDate.getTime());
        Book book = bookDao.findByNameAuthor(bookName, press);
        book = new Book(bookName, author, press, pu, type, total);

        return bookDao.save(book);
    }

    @Override
    public boolean add(Book book) {
        return false;
    }

    @Override
    public List<Book> findByString(String str) {
        return null;
    }
}
