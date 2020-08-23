package com.yvan.entity;


import java.sql.Timestamp;

/**
 * @author Yvan
 */
public class Reservation {

    private int id;
    private int uid;
    private int bid;
    private Timestamp time;
    private boolean fulfill;

    public Reservation(int id, int uid, int bid, boolean fulfill) {
        this.id = id;
        this.uid = uid;
        this.bid = bid;
        this.fulfill = fulfill;
    }

    public Reservation(int id, int uid, int bid, Timestamp time, boolean fulfill) {
        this.id = id;
        this.uid = uid;
        this.bid = bid;
        this.time = time;
        this.fulfill = fulfill;
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


    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public boolean isFulfill() {
        return fulfill;
    }


    public void setFulfill(boolean fulfill) {
        this.fulfill = fulfill;
    }

}
