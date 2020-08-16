package com.yvan.dao.impl;

import com.yvan.dao.BookDao;
import com.yvan.entity.Book;
import com.yvan.util.SqlUtil;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Yvan
 */

public class BookDaoImpl extends BaseDao implements BookDao {

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
                book = new Book(id, bookName, author, press, publicationDate, type, bookDeposit);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeAll();
        }
        return book;
    }

    @Override
    public List<Book> fuzzyFindBookByNameAuthorPressType(String str) {
        str = "%" + str + "%";
        String sql = "SELECT id,book_name,author,press,publication_date,type,book_deposit,total,count,times,has_lended,del " +
                "from book where book_name LIKE ? or author LIKE ? or press LIKE ? or type LIKE ?";
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
                Timestamp publicationDate = rs.getTimestamp("publication_date");
                String type = rs.getString("type");
                float bookDeposit = rs.getFloat("book_deposit");
                int total = rs.getInt("total");
                int count = rs.getInt("count");
                int times = rs.getInt("times");
                int hasLended = rs.getInt("has_lended");
                boolean del = rs.getBoolean("del");
                bookList.add(new Book(id, bookName, author, press, bookDeposit, publicationDate, type, count, times, hasLended, total, del));
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
                float bookDeposit = rs.getFloat("book_deposit");
                Timestamp publicationDate = rs.getTimestamp("publication_date");
                String type = rs.getString("type");
                int count = rs.getInt("count");
                int times = rs.getInt("times");
                int hasLended = rs.getInt("has_lended");
                int total = rs.getInt("total");
                boolean del = rs.getBoolean("del");
                list.add(new Book(id, bookName, author, press, bookDeposit, publicationDate, type, count, times, hasLended, total, del));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public int delBook(int id) {
        String table = "book";
        String field = "del = ?,count = ?";
        String term = "id = ?";
        String sql = SqlUtil.update(table, field, term);
        List<Object> list = new ArrayList<>();
        list.add(true);
        list.add(0);
        list.add(id);
        int res = executeUpdate(sql, list);
        closeAll();
        return res;
    }
}
