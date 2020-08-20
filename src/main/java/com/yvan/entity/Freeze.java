package com.yvan.entity;


import java.sql.Timestamp;

public class Freeze {

    private int id;
    private int uid;
    private java.sql.Timestamp freezeTime;
    private String freezeReason;
    private java.sql.Timestamp unfreezeTime;
    private String unfreezeReason;
    private boolean flag;

    public Freeze(int id, int uid, Timestamp freezeTime, String freezeReason) {
        this.id = id;
        this.uid = uid;
        this.freezeTime = freezeTime;
        this.freezeReason = freezeReason;
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


    public java.sql.Timestamp getFreezeTime() {
        return freezeTime;
    }

    public void setFreezeTime(java.sql.Timestamp freezeTime) {
        this.freezeTime = freezeTime;
    }


    public String getFreezeReason() {
        return freezeReason;
    }

    public void setFreezeReason(String freezeReason) {
        this.freezeReason = freezeReason;
    }


    public java.sql.Timestamp getUnfreezeTime() {
        return unfreezeTime;
    }

    public void setUnfreezeTime(java.sql.Timestamp unfreezeTime) {
        this.unfreezeTime = unfreezeTime;
    }


    public String getUnfreezeReason() {
        return unfreezeReason;
    }

    public void setUnfreezeReason(String unfreezeReason) {
        this.unfreezeReason = unfreezeReason;
    }


    public boolean getFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

}
