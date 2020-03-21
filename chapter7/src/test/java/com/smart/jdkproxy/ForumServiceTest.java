package com.smart.jdkproxy;

import org.testng.annotations.Test;

import java.lang.reflect.Proxy;

public class ForumServiceTest {
    @Test
    public void proxy(){
        ForumService target = new ForumServiceImpl();
        PerformanceHandler handler = new PerformanceHandler(target);
        ForumService proxy = (ForumService) Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),handler);
        proxy.removeForum(10);
        proxy.removeTopic(1010);
    }
}
