package com.yvan.biz.impl;

import com.yvan.biz.BookBiz;
import com.yvan.dao.BookDao;
import com.yvan.dao.CollectionDao;
import com.yvan.dao.impl.BookDaoImpl;
import com.yvan.dao.impl.CollectionDaoImpl;
import com.yvan.entity.Book;
import com.yvan.entity.Collection;
import com.yvan.entity.User;
import org.jetbrains.annotations.NotNull;

import java.sql.Timestamp;
import java.util.*;

/**
 * @author Yvan
 */

public class BookBizImpl implements BookBiz {

    private final BookDao bookDao = new BookDaoImpl();
    private final CollectionDao collectionDao = new CollectionDaoImpl();

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
    public List<Book> findByString(String str, User user) {
        List<Book> dataBook = bookDao.fuzzyFindBookByNameAuthorPressType(str);
        if (dataBook.isEmpty()) {
            return dataBook;
        }
        return getBookList(user, dataBook);
    }

    @Override
    public List<Book> findCountZoneByString(String str, User user) {
        List<Book> dataBook = bookDao.fuzzyFindBookByNameAuthorPressType(str);
        if (dataBook.isEmpty()) {
            return dataBook;
        }
        return getBookCountZoneList(user, dataBook);
    }

    @NotNull
    private List<Book> getBookList(@NotNull User user, List<Book> dataBook) {
        Map<Integer, Boolean> map = new HashMap<>(12);
        List<Collection> dataCollection = collectionDao.findByUid(user.getId());
        List<Book> resList = new ArrayList<>();
        for (Collection collection : dataCollection) {
            map.put(collection.getBid(), collection.getDel());
        }
        for (Book book : dataBook) {
            Boolean flag = map.get(book.getId());
            if (flag != null) {
                book.setCollection(!flag);
            }
            if (!book.isDel()) {
                resList.add(book);
            }
        }
        return resList;
    }

    @NotNull
    private List<Book> getBookCountZoneList(@NotNull User user, List<Book> dataBook) {
        Map<Integer, Boolean> map = new HashMap<>(12);
        List<Collection> dataCollection = collectionDao.findByUid(user.getId());
        List<Book> resList = new ArrayList<>();
        for (Collection collection : dataCollection) {
            map.put(collection.getBid(), collection.getDel());
        }
        for (Book book : dataBook) {
            Boolean flag = map.get(book.getId());
            if (flag != null) {
                book.setCollection(!flag);
            }
            if (!book.isDel() && book.getCount() == 0) {
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
    public List<Book> findAll(User user) {
        List<Book> dataBook = bookDao.findAll();
        if (dataBook.isEmpty()) {
            return dataBook;
        }
        return getBookList(user, dataBook);
    }

    @Override
    public List<Book> findCountZero(User user) {
        List<Book> dataBook = bookDao.findAll();
        if (dataBook.isEmpty()) {
            return dataBook;
        }
        return getBookCountZoneList(user, dataBook);
    }

    @Override
    public boolean delBook(int id) {
        int res = bookDao.delBook(id);
        return res > 0;
    }

    @Override
    public boolean updateBookInfo(int id, @NotNull Book book) {
        Book newBook = bookDao.findByNameAuthor(book.getBookName(), book.getAuthor());
        if (newBook != null && (!newBook.isDel())) {
            return false;
        }
        int res = bookDao.updateBook(id, book);
        return res > 0;
    }
}
