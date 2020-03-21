package com.smart.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConf {
    @Bean
    public UserDao userDao(){
        return new UserDao();
    }

    @Bean
    public LogDao logDao(){
        return new LogDao();
    }

    @Bean
    public LogonService logonService(){
        LogonService logonServer = new LogonService();
        logonServer.setLogDao(logDao());
        logonServer.setUserDao(userDao());
        return logonServer;
    }
}
