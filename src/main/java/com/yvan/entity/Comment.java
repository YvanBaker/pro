package com.yvan.entity;


/**
 * @author Yvan
 * @Description 评论的实体类
 */
public class Comment {

    private int id;
    private int uid;
    private int bid;
    private String content;

    public Comment(int id, int uid, int bid, String content) {
        this.id = id;
        this.uid = uid;
        this.bid = bid;
        this.content = content;
    }

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


    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
