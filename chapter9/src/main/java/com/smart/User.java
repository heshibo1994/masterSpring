package com.smart;

public class User {
    private String name;
    private int credit;


    public boolean isVipMember(String userName){
        return "tom".equals(userName) || "jony".equals(userName);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }
}
