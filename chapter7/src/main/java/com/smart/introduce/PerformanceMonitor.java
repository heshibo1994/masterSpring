package com.smart.introduce;

import com.smart.jdkproxy.MethodPerformace;

public class PerformanceMonitor {
    private static ThreadLocal<MethodPerformace> performaceRecord = new ThreadLocal<MethodPerformace>();

    public static void begin(String method) {
        System.out.println("开始监控");
        MethodPerformace mp = new MethodPerformace(method);
        performaceRecord.set(mp);
    }

    public static void end() {
        System.out.println("结束监控");
        MethodPerformace mp = performaceRecord.get();
        mp.printPerformance();
    }
}
