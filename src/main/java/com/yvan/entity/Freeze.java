package com.yvan.entity;


/**
 * @author Yvan
 */
public class Freeze {

  private int id;
  private int uid;
  private java.sql.Timestamp freezeTime;
  private java.sql.Timestamp unfreezeTime;
  private boolean flag;


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


  public java.sql.Timestamp getUnfreezeTime() {
    return unfreezeTime;
  }

  public void setUnfreezeTime(java.sql.Timestamp unfreezeTime) {
    this.unfreezeTime = unfreezeTime;
  }


  public boolean getFlag() {
    return flag;
  }

  public void setFlag(boolean flag) {
    this.flag = flag;
  }

}
