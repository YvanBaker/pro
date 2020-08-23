package com.yvan.entity;


import java.sql.Timestamp;
import java.util.Objects;

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

    public Administrator(int id) {
        this.id = id;
    }

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

    public Administrator(int id, String name, String password, String type) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.type = type;
    }

    public Administrator(String name, String password, String type) {
        this.name = name;
        this.password = password;
        this.type = type;
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
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Administrator)) {
            return false;
        }
        Administrator that = (Administrator) o;
        return getId() == that.getId() &&
                Objects.equals(getName(), that.getName()) &&
                Objects.equals(getPassword(), that.getPassword()) &&
                Objects.equals(getType(), that.getType());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getPassword(), getType());
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
