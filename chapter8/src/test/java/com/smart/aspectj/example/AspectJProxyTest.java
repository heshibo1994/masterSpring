package com.smart.aspectj.example;

import com.smart.NaiveWaiter;
import com.smart.Waiter;
import com.smart.aspectj.aspectj.PreGreetAspect;
import org.springframework.aop.aspectj.annotation.AspectJProxyFactory;
import org.testng.annotations.Test;


public class AspectJProxyTest {
    @Test
    public void proxy(){
        Waiter waiter = new NaiveWaiter();

        AspectJProxyFactory factory = new AspectJProxyFactory();

        factory.setTarget(waiter);
        factory.addAspect(PreGreetAspect.class);

        Waiter proxy = factory.getProxy();
        proxy.greetTo("Join");
        proxy.serveTo("tom");
    }
}
