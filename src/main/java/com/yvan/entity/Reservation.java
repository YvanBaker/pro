package com.yvan.entity;


/**
 * @author Yvan
 */
public class Reservation {

    private int id;
    private int uid;
    private int bid;
    private String time;
    private boolean fulfill;

    public Reservation(int id, int uid, int bid, boolean fulfill) {
        this.id = id;
        this.uid = uid;
        this.bid = bid;
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


    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public boolean isFulfill() {
        return fulfill;
    }


    public void setFulfill(boolean fulfill) {
        this.fulfill = fulfill;
    }

}
