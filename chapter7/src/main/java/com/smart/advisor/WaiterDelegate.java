package com.smart.advisor;

public class WaiterDelegate {
    private Waiter waiter;

    public void setWaiter(Waiter waiter) {
        this.waiter = waiter;
    }

    public void service(String name ){
        waiter.serverTo(name);
        waiter.serverTo(name);
    }
}
