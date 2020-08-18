package com.yvan.entity;


import java.sql.Timestamp;

/**
 * @author Yvan
 */
public class Collection {

    private int id;
    private int uid;
    private int bid;
    private java.sql.Timestamp createTime;
    private boolean del;
    private java.sql.Timestamp delTime;

    public Collection(int id, int uid, int bid, boolean del) {
        this.id = id;
        this.uid = uid;
        this.bid = bid;
        this.del = del;
    }

    public Collection(int uid, int bid, Timestamp createTime, boolean del) {
        this.uid = uid;
        this.bid = bid;
        this.createTime = createTime;
        this.del = del;
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


    public java.sql.Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(java.sql.Timestamp createTime) {
        this.createTime = createTime;
    }


    public boolean getDel() {
        return del;
    }

    public void setDel(boolean del) {
        this.del = del;
    }


    public java.sql.Timestamp getDelTime() {
        return delTime;
    }

    public void setDelTime(java.sql.Timestamp delTime) {
        this.delTime = delTime;
    }

}
