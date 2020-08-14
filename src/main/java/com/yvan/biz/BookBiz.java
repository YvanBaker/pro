package com.yvan.biz;

import com.yvan.entity.Book;

import java.util.Date;
import java.util.List;

public interface BookBiz {
    public boolean add(String bookName, String author, String press, int count, Date publicationDate, String type);

    public boolean add(Book book);

    /**
     * 根据输入的字符串查新书籍
     *
     * @param str 字符串
     * @return book的集合
     */
    public List<Book> findByString(String str);
}
