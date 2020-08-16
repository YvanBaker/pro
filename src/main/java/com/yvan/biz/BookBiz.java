package com.yvan.biz;

import com.yvan.entity.Book;

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
     * 查询所有没有删除的书籍
     *
     * @return book的集合
     */
    List<Book> findAll();

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
