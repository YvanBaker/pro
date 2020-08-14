package com.yvan.dao.impl;

import com.yvan.dao.BookDao;
import com.yvan.entity.Book;
import junit.framework.TestCase;

import java.util.List;

public class BookDaoImplTest extends TestCase {
    BookDao bookDao = new BookDaoImpl();

    /**
     * 保存数据
     */
    public void testSave() {
        boolean flag = bookDao.save(new Book("测试", "测试", "测试", 12));
        assert flag;
    }

    /**
     * 查询存在的书籍
     */
    public void testFindByNameAuthor() {
        String name = "23·";
        String author = "23";
        Book book = bookDao.findByNameAuthor(name, author);
        System.out.println(book);
        assert (book != null);
    }


    /**
     * 查询存在的值
     */
    public void testFuzzyFindByNameAuthorPressType() {
        List<Book> bookList = bookDao.fuzzyFindBookByNameAuthorPressType("2");
        assert (bookList.size() != 0);
    }

    /**
     * 查询不存在的值
     */
    public void testFuzzyFindByNameAuthorPressTypeNull() {
        List<Book> bookList = bookDao.fuzzyFindBookByNameAuthorPressType("zhnsdf");
        assert (bookList.size() == 0);
    }

    public void testFindCountByIdNull() {
        assert bookDao.findCountById(1) == null;
    }

    public void testFindCountById() {
        Integer count = bookDao.findCountById(17);
        assert count != null;
    }

    public void testFindAll() {
        assert bookDao.findAll() != null;
    }
}