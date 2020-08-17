package com.yvan.entity;


public class Record {

  private int id;
  private int uid;
  private int bid;
  private java.sql.Timestamp lendTime;
  private java.sql.Timestamp returnTime;
  private float deposit;
  private float returnTerm;
  private java.sql.Timestamp actualTime;
  private boolean isRenew;
  private boolean isReturn;


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


  public boolean getIsRenew() {
    return isRenew;
  }

  public void setIsRenew(boolean isRenew) {
    this.isRenew = isRenew;
  }


  public boolean getIsReturn() {
    return isReturn;
  }

  public void setIsReturn(boolean isReturn) {
    this.isReturn = isReturn;
  }

}
