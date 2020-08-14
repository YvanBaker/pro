package com.yvan.dao.impl;

import com.yvan.dao.BookDao;
import com.yvan.entity.Book;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class BookDaoImpl extends BaseDao implements BookDao {
    @Override
    public boolean save(Book book) {
        String sql = "INSERT INTO book(book_name,author,press,publication_date,type,count,total) VALUE (?,?,?,?,?,?,?)";
        List<Object> list = new ArrayList<>();
        list.add(book.getBookName());
        list.add(book.getAuthor());
        list.add(book.getPress());
        list.add(book.getPublicationDate());
        list.add(book.getType());
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
                book = new Book(id, bookName, author, press, publicationDate, type);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeAll();
        }
        return book;
    }

    @Override
    public List<Book> fuzzyFindByNameAuthorPressType(String str) {
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
}
