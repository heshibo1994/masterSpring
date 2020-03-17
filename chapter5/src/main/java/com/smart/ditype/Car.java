package com.smart.ditype;

public class Car {
    private String brand;
    private double price;
    private int maxSpeed;

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public String getBrand() {
        return brand;
    }

    public double getPrice() {
        return price;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }
}
