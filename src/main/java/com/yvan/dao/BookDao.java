package com.yvan.dao;

import com.yvan.entity.Book;

import java.util.List;

public interface BookDao {

    /**
     * 保存一本书
     *
     * @param book 书
     * @return false 失败
     */
    public boolean save(Book book);

    /**
     * 根据名字和作者查询一本书
     *
     * @param bookName 书名
     * @param author   作者
     * @return Book对象
     */
    public Book findByNameAuthor(String bookName, String author);

    /**
     * 根据名字、作者、作者、类型模糊查询书籍信息
     *
     * @param str 字符串
     * @return 书的集合
     */
    public List<Book> fuzzyFindBookByNameAuthorPressType(String str);

    /**
     * 根据id查询剩余数量
     *
     * @param id
     * @return
     */
    public Integer findCountById(int id);

    /**
     * 查询所有数据信息
     *
     * @return 书籍集合
     */
    public List<Book> findAll();
}
