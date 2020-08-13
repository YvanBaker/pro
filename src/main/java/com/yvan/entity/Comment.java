package com.yvan.entity;


public class Comment {

  private int id;
  private String uid;
  private String bid;
  private String content;


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


  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

}
