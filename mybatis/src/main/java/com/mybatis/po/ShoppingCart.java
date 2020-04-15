package com.mybatis.po;

public class ShoppingCart {
    private int scartId;
    private String pname;
    private User user;

    public ShoppingCart(int scartId, String pname, User user) {
        this.scartId = scartId;
        this.pname = pname;
        this.user = user;
    }

    public int getScartId() {
        return scartId;
    }

    public void setScartId(int scartId) {
        this.scartId = scartId;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
