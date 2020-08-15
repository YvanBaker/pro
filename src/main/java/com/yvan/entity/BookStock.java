package com.yvan.entity;


/**
 * @author Yvan
 */

public class BookStock {

  private int id;
  private String bsid;
  private String name;
  private String type;
  private String count;
  private String hasLended;
  private String total;
  private String times;


  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }


  public String getBsid() {
    return bsid;
  }

  public void setBsid(String bsid) {
    this.bsid = bsid;
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


  public String getCount() {
    return count;
  }

  public void setCount(String count) {
    this.count = count;
  }


  public String getHasLended() {
    return hasLended;
  }

  public void setHasLended(String hasLended) {
    this.hasLended = hasLended;
  }


  public String getTotal() {
    return total;
  }

  public void setTotal(String total) {
    this.total = total;
  }


  public String getTimes() {
    return times;
  }

  public void setTimes(String times) {
    this.times = times;
  }

}
