package com.yvan.entity;


import java.sql.Timestamp;

/**
 * @author Yvan
 */
public class Administrator {

  private int id;
  private String name;
  private String password;
  private String type;
  private boolean del;
  private Timestamp createTime;

    public Administrator(String name, String password, String type, boolean del, Timestamp createTime) {
        this.name = name;
        this.password = password;
        this.type = type;
        this.del = del;
        this.createTime = createTime;
    }

    public Administrator(int id, String name, String password, String type, boolean del) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.type = type;
        this.del = del;
    }

    public Administrator(String name, String password, String type, boolean del) {
        this.name = name;
        this.password = password;
        this.type = type;
        this.del = del;
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


  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }


  public boolean getDel() {
    return del;
  }

  public void setDel(boolean del) {
    this.del = del;
  }


  public java.sql.Timestamp getCreateTime() {
    return createTime;
  }

  public void setCreateTime(java.sql.Timestamp createTime) {
    this.createTime = createTime;
  }

    @Override
    public String toString() {
        return "Administrator{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", type='" + type + '\'' +
                ", del=" + del +
                ", createTime=" + createTime +
                '}';
    }
}
