package com.yvan.entity;


import java.sql.Timestamp;

/**
 * @author Yvan
 */

public class Book {

    private int id;
    private String bookName;
    private String author;
    private String press;
    private Timestamp publicationDate;
    private String type;
    private float bookDeposit;
    private int count;
    private int times;
    private int hasLended;
    private int total;
    private boolean del;
    private boolean collection;

    public Book(int id, String bookName, String author, String press, Timestamp publicationDate, String type, float bookDeposit) {
        this.id = id;
        this.bookName = bookName;
        this.author = author;
        this.press = press;
        this.publicationDate = publicationDate;
        this.type = type;
        this.bookDeposit = bookDeposit;
    }

    public Book(int id, String bookName, String author, String press, String type) {
        this.id = id;
        this.bookName = bookName;
        this.author = author;
        this.press = press;
        this.type = type;
    }

    public Book(String bookName, String author, String press, Timestamp publicationDate, String type, float bookDeposit, int total) {
        this.bookName = bookName;
        this.author = author;
        this.press = press;
        this.publicationDate = publicationDate;
        this.type = type;
        this.bookDeposit = bookDeposit;
        this.total = total;
    }

    public Book(int id, String bookName, String author, String press, float bookDeposit) {
        this.id = id;
        this.bookName = bookName;
        this.author = author;
        this.press = press;
        this.bookDeposit = bookDeposit;
    }

    public Book(String bookName, String author, String press, int total) {
        this.bookName = bookName;
        this.author = author;
        this.press = press;
        this.total = total;
    }

    public Book(int id, String bookName, String author, String press, Timestamp publicationDate, String type, float bookDeposit, int count) {
        this.id = id;
        this.bookName = bookName;
        this.author = author;
        this.press = press;
        this.publicationDate = publicationDate;
        this.type = type;
        this.bookDeposit = bookDeposit;
        this.count = count;
    }

    public Book(int id, String bookName, String author, String press, Timestamp publicationDate, String type, float bookDeposit, boolean del) {
        this.id = id;
        this.bookName = bookName;
        this.author = author;
        this.press = press;
        this.publicationDate = publicationDate;
        this.type = type;
        this.bookDeposit = bookDeposit;
        this.del = del;
    }

    public Book(int id, String bookName, String author, String press, float bookDeposit, Timestamp publicationDate, String type, int count, int times, int hasLended, int total, boolean del) {
        this.id = id;
        this.bookName = bookName;
        this.author = author;
        this.press = press;
        this.bookDeposit = bookDeposit;
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

    public float getBookDeposit() {
        return bookDeposit;
    }

    public void setBookDeposit(float bookDeposit) {
        this.bookDeposit = bookDeposit;
    }

    public boolean isDel() {
        return del;
    }

    public void setDel(boolean del) {
        this.del = del;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Book)) {
            return false;
        }

        Book book = (Book) o;

        if (getId() != book.getId()) {
            return false;
        }
        if (Float.compare(book.getBookDeposit(), getBookDeposit()) != 0) {
            return false;
        }
        if (getCount() != book.getCount()) {
            return false;
        }
        if (getBookName() != null ? !getBookName().equals(book.getBookName()) : book.getBookName() != null) {
            return false;
        }
        if (getAuthor() != null ? !getAuthor().equals(book.getAuthor()) : book.getAuthor() != null) {
            return false;
        }
        if (getPress() != null ? !getPress().equals(book.getPress()) : book.getPress() != null) {
            return false;
        }
        if (getPublicationDate() != null ? !getPublicationDate().equals(book.getPublicationDate()) : book.getPublicationDate() != null) {
            return false;
        }
        return getType() != null ? getType().equals(book.getType()) : book.getType() == null;
    }

    public boolean isCollection() {
        return collection;
    }

    public void setCollection(boolean collection) {
        this.collection = collection;
    }

    @Override
    public int hashCode() {
        int result = getId();
        result = 31 * result + (getBookName() != null ? getBookName().hashCode() : 0);
        result = 31 * result + (getAuthor() != null ? getAuthor().hashCode() : 0);
        result = 31 * result + (getPress() != null ? getPress().hashCode() : 0);
        result = 31 * result + (getPublicationDate() != null ? getPublicationDate().hashCode() : 0);
        result = 31 * result + (getType() != null ? getType().hashCode() : 0);
        result = 31 * result + (getBookDeposit() != +0.0f ? Float.floatToIntBits(getBookDeposit()) : 0);
        result = 31 * result + getCount();
        return result;
    }
}
