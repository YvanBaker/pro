package com.yvan.entity;


import java.sql.Timestamp;
import java.util.Objects;

/**
 * record view 视图实体类
 *
 * @author Yvan
 */
public class RecordView {

    private int id;
    private int uid;
    private int bid;
    private String name;
    private String bookName;
    private String author;
    private java.sql.Timestamp lendTime;
    private java.sql.Timestamp returnTime;
    private float deposit;
    private float returnTerm;
    private java.sql.Timestamp actualTime;
    private boolean isRenew;
    private boolean isReturn;

    public RecordView(int id, int uid, int bid, String name, String bookName, String author, Timestamp lendTime, Timestamp returnTime, float deposit, float returnTerm, Timestamp actualTime, boolean isRenew, boolean isReturn) {
        this.id = id;
        this.uid = uid;
        this.bid = bid;
        this.name = name;
        this.bookName = bookName;
        this.author = author;
        this.lendTime = lendTime;
        this.returnTime = returnTime;
        this.deposit = deposit;
        this.returnTerm = returnTerm;
        this.actualTime = actualTime;
        this.isRenew = isRenew;
        this.isReturn = isReturn;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getBid() {
        return bid;
    }

    public void setBid(int bid) {
        this.bid = bid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public java.sql.Timestamp getLendTime() {
        return lendTime;
    }

    public void setLendTime(java.sql.Timestamp lendTime) {
        this.lendTime = lendTime;
    }


    public java.sql.Timestamp getReturnTime() {
        return returnTime;
    }

    public void setReturnTime(java.sql.Timestamp returnTime) {
        this.returnTime = returnTime;
    }


    public float getDeposit() {
        return deposit;
    }

    public void setDeposit(float deposit) {
        this.deposit = deposit;
    }


    public float getReturnTerm() {
        return returnTerm;
    }

    public void setReturnTerm(float returnTerm) {
        this.returnTerm = returnTerm;
    }


    public java.sql.Timestamp getActualTime() {
        return actualTime;
    }

    public void setActualTime(java.sql.Timestamp actualTime) {
        this.actualTime = actualTime;
    }

    public boolean isRenew() {
        return isRenew;
    }

    public void setRenew(boolean renew) {
        isRenew = renew;
    }

    public boolean isReturn() {
        return isReturn;
    }

    public void setReturn(boolean aReturn) {
        isReturn = aReturn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof RecordView)) {
            return false;
        }
        RecordView that = (RecordView) o;
        return Objects.equals(getBookName(), that.getBookName()) &&
                Objects.equals(getAuthor(), that.getAuthor());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getBookName(), getAuthor());
    }
}
