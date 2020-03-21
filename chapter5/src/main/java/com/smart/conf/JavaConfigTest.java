package com.smart.conf;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JavaConfigTest {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConf.class);
        LogonService logonServer = ctx.getBean(LogonService.class);
        logonServer.printHello();
    }
}
