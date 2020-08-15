package com.yvan.dao.impl;

import com.yvan.dao.BookDao;
import com.yvan.entity.Book;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Yvan
 */

public class BookDaoImpl extends BaseDao implements BookDao {

    /**
     * 保存一本书
     *
     * @param book 书
     * @return false 失败
     */
    @Override
    public boolean save(Book book) {
        String sql = "INSERT INTO book(book_name,author,press,publication_date,type,book_deposit,count,total) VALUE (?,?,?,?,?,?,?,?)";
        List<Object> list = new ArrayList<>();
        list.add(book.getBookName());
        list.add(book.getAuthor());
        list.add(book.getPress());
        list.add(book.getPublicationDate());
        list.add(book.getType());
        list.add(book.getBookDeposit());
        list.add(book.getTotal());
        list.add(book.getTotal());
        int i = executeUpdate(sql, list);
        closeAll();
        return i == 0 ? false : true;
    }

    /**
     * 根据名字和作者查询一本书
     *
     * @param bookName 书名
     * @param author   作者
     * @return Book对象
     */
    @Override
    public Book findByNameAuthor(String bookName, String author) {
        String sql = "SELECT * FROM book where book_name = ? and author = ?";
        List<Object> list = new ArrayList<>();
        list.add(bookName);
        list.add(author);
        executeQuery(sql, list);
        Book book = null;
        try {
            while (rs.next()) {
                int id = rs.getInt("id");
                String press = rs.getString("press");
                Timestamp publicationDate = rs.getTimestamp("publication_date");
                String type = rs.getString("type");
                float bookDeposit = rs.getFloat("book_deposit");
                book = new Book(id, bookName, author, press, publicationDate, type,bookDeposit);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeAll();
        }
        return book;
    }

    /**
     * 根据名字、作者、作者、类型模糊查询书籍信息
     *
     * @param str 字符串
     * @return 书的集合
     */
    @Override
    public List<Book> fuzzyFindBookByNameAuthorPressType(String str) {
        str = "%" + str + "%";
        String sql = "SELECT id,book_name,author,press,type from book where book_name LIKE ? or author LIKE ? or press LIKE ? or type LIKE ?";
        List<Object> list = new ArrayList<>();
        List<Book> bookList = new ArrayList<>();
        list.add(str);
        list.add(str);
        list.add(str);
        list.add(str);
        executeQuery(sql, list);
        try {
            while (rs.next()) {
                int id = rs.getInt("id");
                String bookName = rs.getString("book_name");
                String author = rs.getString("author");
                String press = rs.getString("press");
                String type = rs.getString("type");
                bookList.add(new Book(id, bookName, author, press, type));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeAll();
        }
        return bookList;
    }

    @Override
    public Integer findCountById(int id) {
        Integer res = null;
        String sql = "SELECT count from book where id = ?";
        List<Object> list = new ArrayList<>();
        list.add(id);
        executeQuery(sql, list);
        try {
            while (rs.next()) {
                res = rs.getInt("count");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeAll();
        }
        return res;
    }

    @Override
    public List<Book> findAll() {
        List<Book> list = new ArrayList<>();
        String sql = "Select * from book";
        executeQuery(sql, new ArrayList<Object>());
        try {
            while (rs.next()) {
                int id = rs.getInt("id");
                String bookName = rs.getString("book_name");
                String author = rs.getString("author");
                String press = rs.getString("press");
                Timestamp publicationDate = rs.getTimestamp("publication_date");
                String type = rs.getString("type");
                int count = rs.getInt("count");
                int times = rs.getInt("times");
                int hasLended = rs.getInt("has_lended");
                int total = rs.getInt("total");
                boolean del = rs.getBoolean("del");
                list.add(new Book(id, bookName, author, press, publicationDate, type, count, times, hasLended, total, del));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
