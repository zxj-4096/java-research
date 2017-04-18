package com.research.frame.domain;

public class User {
	 //实体类的属性和表的字段名称一一对应
    private int uid;
    private String username;

    public int getId() {
        return uid;
    }

    public void setId(int id) {
        this.uid = id;
    }

    public String getName() {
        return username;
    }

    public void setName(String name) {
        this.username = name;
    }

    @Override
    public String toString() {
        return "User [id=" + uid + ", name=" + username + "]";
    }
}
