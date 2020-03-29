package com.smart.aspectj.fun;

import com.smart.Waiter;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

public class PointcutFunTest {
    @Test
    public void pointcut(){
        ApplicationContext act = new ClassPathXmlApplicationContext("com.smart.aspectj.fun/beans.xml");
        Waiter naiveWaiter = (Waiter)act.getBean("naiveWaiter");
        Waiter naughtyWaiter = (Waiter)act.getBean("naughtyWaiter");
        naiveWaiter.greetTo("Join");
        naughtyWaiter.greetTo("Join");
    }
}
