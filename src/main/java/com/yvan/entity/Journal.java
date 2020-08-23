package com.yvan.entity;


public class Journal {

  private int id;
  private int uid;
  private java.sql.Timestamp time;
  private int money;


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


  public java.sql.Timestamp getTime() {
    return time;
  }

  public void setTime(java.sql.Timestamp time) {
    this.time = time;
  }


  public int getMoney() {
    return money;
  }

  public void setMoney(int money) {
    this.money = money;
  }

}
