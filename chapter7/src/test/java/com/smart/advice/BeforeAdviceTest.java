package com.smart.advice;

import org.springframework.aop.BeforeAdvice;
import org.springframework.aop.framework.ProxyFactory;
import org.testng.annotations.Test;

import java.lang.reflect.Proxy;

public class BeforeAdviceTest {
    @Test
    public void before(){
        Waiter target = new NavieWaiter();
        BeforeAdvice advice = new GreetingBeforeAdvice();

        ProxyFactory pf = new ProxyFactory();
        //设定代理目标和增强内容
        pf.setTarget(target);
        pf.addAdvice(advice);
        //生成代理实例
        Waiter proxy = (Waiter) pf.getProxy();

        proxy.greetTo("tom");
        proxy.serverTo("jerry");
    }
}
