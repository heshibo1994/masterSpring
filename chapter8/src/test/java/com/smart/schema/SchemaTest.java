package com.smart.schema;

import com.smart.Waiter;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

public class SchemaTest {
    @Test
    public void schema(){
        ApplicationContext act = new ClassPathXmlApplicationContext("com/smart/schema/beans.xml");
        Waiter naiveWaiter = (Waiter)act.getBean("naiveWaiter");
        Waiter naughtWaiter = (Waiter)act.getBean("naughtWaiter");

        naiveWaiter.serveTo("Join");
        naughtWaiter.serveTo("Join");
    }
}
