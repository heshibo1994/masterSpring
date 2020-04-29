package com.smart.springboot02config.config;


import com.smart.springboot02config.service.HelloService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyAppConfig {
    // 将方法的放回值添加到容器中，容器中这个组件默认id就是方法名
    @Bean
    public HelloService helloService(){
        return new HelloService();
    }
}
