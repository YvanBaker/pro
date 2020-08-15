package com.yvan.entity;

/**
 * @author Yvan
 */

public class Record {

  private int id;
  private String uid;
  private String bid;
  private String lendTime;
  private String returnTime;
  private String returnTerm;
  private String isrenew;


  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }


  public String getUid() {
    return uid;
  }

  public void setUid(String uid) {
    this.uid = uid;
  }


  public String getBid() {
    return bid;
  }

  public void setBid(String bid) {
    this.bid = bid;
  }


  public String getLendTime() {
    return lendTime;
  }

  public void setLendTime(String lendTime) {
    this.lendTime = lendTime;
  }


  public String getReturnTime() {
    return returnTime;
  }

  public void setReturnTime(String returnTime) {
    this.returnTime = returnTime;
  }


  public String getReturnTerm() {
    return returnTerm;
  }

  public void setReturnTerm(String returnTerm) {
    this.returnTerm = returnTerm;
  }


  public String getIsrenew() {
    return isrenew;
  }

  public void setIsrenew(String isrenew) {
    this.isrenew = isrenew;
  }

}
