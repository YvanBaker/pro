package com.yvan.entity;


import java.sql.Timestamp;
import java.util.Objects;

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
    private String freeze;
    private Timestamp freezeTime;

    public User(int id) {
        this.id = id;
    }

    public User(int id, String name, String password, float point, double balance, int level, boolean del, double sumMoney) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.point = point;
        this.balance = balance;
        this.level = level;
        this.sumMoney = sumMoney;
        this.del = del;
    }

    public User(int id, String name, String password, float point, double balance, int level, double sumMoney, boolean del, Timestamp creatData) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.point = point;
        this.balance = balance;
        this.level = level;
        this.sumMoney = sumMoney;
        this.del = del;
        this.creatData = creatData;
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

    public User(String name, String password) {
        this.name = name;
        this.password = password;
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


    public String getFreeze() {
        return freeze;
    }

    public void setFreeze(String freeze) {
        this.freeze = freeze;
    }

    public boolean isDel() {
        return del;
    }

    public Timestamp getFreezeTime() {
        return freezeTime;
    }

    public void setFreezeTime(Timestamp freezeTime) {
        this.freezeTime = freezeTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof User)) {
            return false;
        }
        User user = (User) o;
        return getId() == user.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
