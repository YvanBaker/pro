package com.yvan.biz;

import com.yvan.entity.Book;
import com.yvan.entity.User;

import java.util.Date;
import java.util.List;

/**
 * @author Yvan
 */

public interface BookBiz {

    /**
     * 添加书籍数据的业务逻辑
     *
     * @param bookName        书名
     * @param author          作者
     * @param press           出版社
     * @param count           数量
     * @param publicationDate 出版日期
     * @param type            类型
     * @param bookDeposit     押金
     * @return true 成功保存
     */
    boolean add(String bookName, String author, String press, int count, Date publicationDate, String type, float bookDeposit);

    /**
     * 添加书籍数据的业务逻辑
     *
     * @param book book
     * @return true 保存成功
     */
    boolean add(Book book);

    /**
     * 根据输入的字符串查新书籍
     *
     * @param str 字符串
     * @return book的集合
     */
    List<Book> findByString(String str);

    /**
     * 根据字符串查找数据，有没有收藏
     *
     * @param str  字符串
     * @param user 用户
     * @return book 集合
     */
    List<Book> findByString(String str, User user);

    /**
     * 根据字符串查找数据，有没有收藏, 且 count 等于 0
     *
     * @param str  字符串
     * @param user 用户
     * @return count 为 0的数据
     */
    List<Book> findCountZoneByString(String str, User user);


    /**
     * 查询所有没有删除的书籍
     *
     * @return book的集合
     */
    List<Book> findAll();

    /**
     * 根据用户查找，是否有没有收藏
     *
     * @param user 用户
     * @return book 集合
     */
    List<Book> findAll(User user);

    /**
     * 根据用户查找，是否有没有收藏，且count字段为0
     *
     * @param user 用户
     * @return book 集合 count 字段为 0
     */
    List<Book> findCountZero(User user);

    /**
     * 根据 id 删除书籍
     * 伪删除
     *
     * @param id id
     * @return false 失败
     */
    boolean delBook(int id);

    /**
     * 根据 id 修改书籍信息
     *
     * @param id   id
     * @param book book信息
     * @return false 失败
     */
    boolean updateBookInfo(int id, Book book);

}
