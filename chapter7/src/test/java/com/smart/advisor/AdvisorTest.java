package com.smart.advisor;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

public class AdvisorTest {
    @Test
    public void advisor(){
        String configPath = "com.smart.advisor/beans.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(configPath);

        //静态
//        Waiter waiter = (Waiter)ctx.getBean("waiter");
//        Seller seller = (Seller)ctx.getBean("seller");
//        waiter.greetTo("John");
//        waiter.serverTo("John");
//        seller.greetTo("John");

        //动态
//        Waiter waiter = (Waiter)ctx.getBean("waiter2");
//        waiter.serverTo("Petet");
//        waiter.serverTo("Join");
        //流程
          Waiter waiter = (Waiter)ctx.getBean("waiter2");
          WaiterDelegate wd = new WaiterDelegate();
          wd.setWaiter(waiter);

          waiter.greetTo("tom");
          waiter.serverTo("tom");

          wd.service("tom");



    }
}
