package com.smart.advice;

public class NavieWaiter implements Waiter {

    @Override
    public void greetTo(String name) {
        System.out.println("greet to:"+name);
    }

    @Override
    public void serverTo(String name) {
        System.out.println("server to:"+name);
    }
}
