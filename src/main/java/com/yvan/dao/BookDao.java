package com.yvan.dao;

import com.yvan.entity.Book;

import java.util.List;

public interface BookDao {

    public boolean save(Book book);

    public Book findByNameAuthor(String bookName, String author);

    public List<Book> fuzzyFindByNameAuthorPressType(String str);
}
