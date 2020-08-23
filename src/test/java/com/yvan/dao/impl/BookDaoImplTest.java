package com.yvan.dao.impl;

import com.yvan.dao.BookDao;
import com.yvan.entity.Book;
import junit.framework.TestCase;

public class BookDaoImplTest extends TestCase {
    BookDao bookDao = new BookDaoImpl();

    /**
     * 测试 save 函数 返回 true
     */
    public void testSaveTrue() {
        assertTrue(bookDao.save(new Book("测试", "测试", "测试", 12)));
    }

    /**
     * 测试 findByNameAuthor 返回 不为空
     */
    public void testFindByNameAuthorNotNull() {
        String name = "测试";
        String author = "测试";
        assertNotNull (bookDao.findByNameAuthor(name, author));
    }

    /**
     * 测试 findByNameAuthor 返回 为空
     */
    public void testFindByNameAuthorNull() {
        String name = "测试111";
        String author = "测试111";
        assertNull(bookDao.findByNameAuthor(name, author));
    }

    /**
     * 测试 findByNameAuthor 返回 不为空
     */
    public void testFindByNameAuthorListNotNull() {
        String name = "测试";
        String author = "测试";
        assertNotNull(bookDao.findByNameAuthor(name, author));
    }

    /**
     * 测试 FuzzyFindByNameAuthorPressType 返回的 列表 不为空
     */
    public void testFuzzyFindByNameAuthorPressType() {
        assertFalse(bookDao.fuzzyFindBookByNameAuthorPressType("测").isEmpty() );
    }

    /**
     * 测试 FuzzyFindByNameAuthorPressType 返回的 列表 之 为空
     */
    public void testFuzzyFindByNameAuthorPressTypeNull() {
        assertTrue(bookDao.fuzzyFindBookByNameAuthorPressType("撒旦法的").isEmpty());
    }

    /**
     * 测试 findCountById 返回 为空
     */
    public void testFindCountByIdNull() {
        assertNull(bookDao.findCountById(1));
    }

    /**
     * 测试 findCountById 返回 不为空
     */
    public void testFindCountByIdNotNull() {
        assertNotNull(bookDao.findCountById(22));
    }

    /**
     * 测试 findTimesById 返回 为空
     */
    public void testFindTimesByIdNull() {
        assertNull(bookDao.findTimesById(1));
    }
    /**
     * 测试 findTimesById 返回 为空
     */
    public void testFindTimesByIdNotNull() {
        assertNotNull(bookDao.findTimesById(22));
    }

    /**
     * 测试 findAll 返回一个 非空集合
     */
    public void testFindAll() {
        assertFalse(bookDao.findAll().isEmpty());
    }

    /**
     * 测试  delBook 返回 0
     */
    public void testTestDelBookZero() {
        assertEquals(bookDao.delBook(1),0,0);
    }

    /**
     * 测试  delBook 返回 1
     */
    public void testTestDelBookOne() {
        assertEquals(bookDao.delBook(2987),1,1);
    }

    /**
     * 测试 updateBook 返回 0
     */
    public void testUpdateBookZero() {
        assertEquals(bookDao.updateBook(55,new Book("测试修改","测试修改","测试修改",12)),1,1);
    }

    /**
     * 测试 updateBook 返回 1
     */
    public void testUpdateBookOne() {
        assertEquals(bookDao.updateBook(2988,new Book("测试修改","测试修改","测试修改",12)),1,1);
    }

    /**
     * 测试 updateCount 返回 0
     */
    public void testUpdateCountZero(){
        assertEquals(bookDao.updateCount(55,100),0,0);
    }

    /**
     * 测试 updateCount 返回 1
     */
    public void testUpdateCount() {
        assertEquals(bookDao.updateCount(2988,100),1,1);
    }

    /**
     * 测试 updateTimes 返回 0
     */
    public void testUpdateTimesZero() {
        assertEquals(bookDao.updateTimes(123,100),0,0);
    }

    /**
     * 测试 updateTimes 返回 1
     */
    public void testUpdateTimesOne() {
        assertEquals(bookDao.updateTimes(2988,100),1,1);
    }

    /**
     * 测试 updateHasLended 返回 0
     */
    public void testUpdateHasLendedZero() {
        assertEquals(bookDao.updateHasLended(55,100),0,0);
    }

    /**
     * 测试 updateHasLended 返回 1
     */
    public void testUpdateHasLendedOne() {
        assertEquals(bookDao.updateHasLended(2988,100),1,1);
    }
}