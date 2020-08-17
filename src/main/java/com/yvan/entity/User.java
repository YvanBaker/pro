package com.yvan.entity;


import java.sql.Timestamp;

public class User {

    private int id;
    private String name;
    private String password;
    private float point;
    private double balance;
    private int level;
    private double sumMoney;
    private boolean del;
    private java.sql.Timestamp creatData;
    private boolean freeze;

    public User(int id, String name, String password, float point, double balance, int level,  boolean del,double sumMoney, boolean freeze) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.point = point;
        this.balance = balance;
        this.level = level;
        this.sumMoney = sumMoney;
        this.del = del;
        this.freeze = freeze;
    }

    public User(int id, String name, String password, float point, double balance, int level, double sumMoney, boolean del, Timestamp creatData, boolean freeze) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.point = point;
        this.balance = balance;
        this.level = level;
        this.sumMoney = sumMoney;
        this.del = del;
        this.creatData = creatData;
        this.freeze = freeze;
    }

    public User(int id, String name, String password, float point, double balance, int level, double sumMoney) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.point = point;
        this.balance = balance;
        this.level = level;
        this.sumMoney = sumMoney;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public float getPoint() {
        return point;
    }

    public void setPoint(float point) {
        this.point = point;
    }


    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }


    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }


    public double getSumMoney() {
        return sumMoney;
    }

    public void setSumMoney(double sumMoney) {
        this.sumMoney = sumMoney;
    }


    public boolean getDel() {
        return del;
    }

    public void setDel(boolean del) {
        this.del = del;
    }


    public java.sql.Timestamp getCreatData() {
        return creatData;
    }

    public void setCreatData(java.sql.Timestamp creatData) {
        this.creatData = creatData;
    }


    public boolean getFreeze() {
        return freeze;
    }

    public void setFreeze(boolean freeze) {
        this.freeze = freeze;
    }

}
