package com.smart.jdkproxy;

public class MethodPerformace {
    private long begin;
    private long end;
    private String serviceMethod;
    public MethodPerformace(String serviceMethod) {
        this.serviceMethod = serviceMethod;
        this.begin = System.currentTimeMillis();
    }

    public void printPerformance() {
        end = System.currentTimeMillis();
        long delta = end-begin;
        System.out.println(serviceMethod+"耗时： "+delta+"毫秒");
    }
}
