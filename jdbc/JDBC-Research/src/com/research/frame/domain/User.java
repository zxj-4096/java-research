package com.research.frame.domain;

public class User {
	 //ʵ��������Ժͱ���ֶ�����һһ��Ӧ
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
