package com.smart.springboot04webrestfulcrud.config;

import com.smart.springboot04webrestfulcrud.servlet.MyServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyServerConfig {

    @Bean
    public ServletRegistrationBean myServelt(){
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(new MyServlet(),"/myServlet");
        return registrationBean;

    }
}
