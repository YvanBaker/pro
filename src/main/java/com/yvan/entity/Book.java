package com.yvan.entity;


public class Book {

  private int id;
  private String bid;
  private String name;
  private String type;
  private String author;
  private String times;
  private String islend;


  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }


  public String getBid() {
    return bid;
  }

  public void setBid(String bid) {
    this.bid = bid;
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }


  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }


  public String getTimes() {
    return times;
  }

  public void setTimes(String times) {
    this.times = times;
  }


  public String getIslend() {
    return islend;
  }

  public void setIslend(String islend) {
    this.islend = islend;
  }

}
