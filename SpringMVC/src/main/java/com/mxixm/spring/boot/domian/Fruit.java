package com.mxixm.spring.boot.domian;

public class Fruit {
    private String name;
    private double price;
    private String location;

    public Fruit(String name, double price, String location) {
        this.name = name;
        this.price = price;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
