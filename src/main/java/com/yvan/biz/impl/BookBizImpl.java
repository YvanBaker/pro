package com.yvan.biz.impl;

import com.yvan.biz.BookBiz;
import com.yvan.dao.BookDao;
import com.yvan.dao.impl.BookDaoImpl;
import com.yvan.entity.Book;
import org.jetbrains.annotations.NotNull;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Yvan
 */

public class BookBizImpl implements BookBiz {

    private final BookDao bookDao = new BookDaoImpl();

    @Override
    public boolean add(String bookName, String author, String press, int total, @NotNull Date publicationDate, String type, float bookDeposit) {
        Timestamp pu = new Timestamp(publicationDate.getTime());
        Book book = bookDao.findByNameAuthor(bookName, press);
        if (book != null) {
            return false;
        }
        book = new Book(bookName, author, press, pu, type, bookDeposit, total);
        return bookDao.save(book);
    }

    @Override
    public boolean add(Book book) {
        return false;
    }

    @Override
    public List<Book> findByString(String str) {
        List<Book> resList = new ArrayList<>();
        List<Book> dataBook = bookDao.fuzzyFindBookByNameAuthorPressType(str);
        for (Book book : dataBook) {
            if (!book.isDel()) {
                resList.add(book);
            }
        }
        return resList;
    }

    @Override
    public List<Book> findAll() {
        List<Book> resBook = new ArrayList<>();
        List<Book> dataBook = bookDao.findAll();
        for (Book book : dataBook) {
            if (!book.isDel()) {
                resBook.add(book);
            }
        }
        return resBook;
    }

    @Override
    public boolean delBook(int id) {
        int res = bookDao.delBook(id);
        return res > 0;
    }

    @Override
    public boolean updateBookInfo(int id, @NotNull Book book) {
        if (bookDao.findByNameAuthor(book.getBookName(), book.getAuthor()) != null) {
            return false;
        }
        int res = bookDao.updateBook(id, book);
        return res > 0;
    }
}
