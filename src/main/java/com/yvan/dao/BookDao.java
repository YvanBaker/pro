package com.yvan.dao;

import com.yvan.entity.Book;

import java.util.List;

/**
 * @author Yvan
 */

public interface BookDao {

    /**
     * 保存一本书
     *
     * @param book 书
     * @return false 失败
     */
    boolean save(Book book);

    /**
     * 根据名字和作者查询一本书
     *
     * @param bookName 书名
     * @param author   作者
     * @return Book对象
     */
    Book findByNameAuthor(String bookName, String author);

    /**
     * 根据名字和作者查询一本书
     *
     * @param bookName 书名
     * @param author   作者
     * @return Book 集合
     */
    List<Book> findByNameAuthorList(String bookName, String author);

    /**
     * 根据名字、作者、作者、类型模糊查询书籍信息
     *
     * @param str 字符串
     * @return 书的集合
     */
    List<Book> fuzzyFindBookByNameAuthorPressType(String str);

    /**
     * 根据id查询剩余数量
     *
     * @param id id
     * @return null 查询不到
     */
    Integer findCountById(int id);

    /**
     * 根据 id 查询 借出的数量
     *
     * @param id id
     * @return null 查询不到
     */
    Integer findTimesById(int id);

    /**
     * 查询所有数据信息
     *
     * @return 书籍集合
     */
    List<Book> findAll();

    /**
     * 将书籍删除
     * 伪删除，将 del 字段设置成1
     *
     * @param id 书籍id
     * @return 数据库条数
     */
    int delBook(int id);

    /**
     * 更新书籍信息
     *
     * @param id   id
     * @param book 书
     * @return 影响数量
     */
    int updateBook(int id, Book book);

    /**
     * 更新 在馆数量 字段
     *
     * @param id    书 id
     * @param count 更改后的值
     * @return 条数
     */
    int updateCount(int id, int count);

    /**
     * 更新 被借出数量 字段
     *
     * @param id    书 id
     * @param times 更改后的值
     * @return 条数
     */
    int updateTimes(int id, int times);

    /**
     * 更新 has_lended 字段
     *
     * @param id        书 id
     * @param hasLended 更改后的值
     * @return 条数
     */
    int updateHasLended(int id, int hasLended);
}
