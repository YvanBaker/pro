package com.yvan.entity;


import java.sql.Timestamp;

public class Book {

    private int id;
    private String bookName;
    private String author;
    private String press;
    private Timestamp publicationDate;
    private String type;
    private int count;
    private int times;
    private int hasLended;
    private int total;
    private boolean del;

    public Book(int id, String bookName, String author, String press, Timestamp publicationDate, String type) {
        this.id = id;
        this.bookName = bookName;
        this.author = author;
        this.press = press;
        this.publicationDate = publicationDate;
        this.type = type;
    }

    public Book(int id, String bookName, String author, String press, String type) {
        this.id = id;
        this.bookName = bookName;
        this.author = author;
        this.press = press;
        this.type = type;
    }

    public Book(String bookName, String author, String press, Timestamp publicationDate, String type, int total) {
        this.bookName = bookName;
        this.author = author;
        this.press = press;
        this.publicationDate = publicationDate;
        this.type = type;
        this.total = total;
    }

    public Book(String bookName, String author, String press, int total) {
        this.bookName = bookName;
        this.author = author;
        this.press = press;
        this.total = total;
    }

    public Book(int id, String bookName, String author, String press, Timestamp publicationDate, String type, int count, int times, int hasLended, int total, boolean del) {
        this.id = id;
        this.bookName = bookName;
        this.author = author;
        this.press = press;
        this.publicationDate = publicationDate;
        this.type = type;
        this.count = count;
        this.times = times;
        this.hasLended = hasLended;
        this.total = total;
        this.del = del;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }


    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }


    public String getPress() {
        return press;
    }

    public void setPress(String press) {
        this.press = press;
    }


    public Timestamp getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(Timestamp publicationDate) {
        this.publicationDate = publicationDate;
    }


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }


    public int getTimes() {
        return times;
    }

    public void setTimes(int times) {
        this.times = times;
    }


    public int getHasLended() {
        return hasLended;
    }

    public void setHasLended(int hasLended) {
        this.hasLended = hasLended;
    }


    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }


    public boolean getDel() {
        return del;
    }

    public void setDel(boolean del) {
        this.del = del;
    }

}
