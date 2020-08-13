package com.yvan.entity;

public enum UserType {
    USER("用户"), ADMINISTRATOR("普通管理"), SUPERADMINISTRATOR("超级管理");

    private String type;

    UserType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return type;
    }
}
