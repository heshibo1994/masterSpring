package com.smart.springboot09cache;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class Springboot09CacheApplication {

    public static void main(String[] args) {
        SpringApplication.run(Springboot09CacheApplication.class, args);
    }

}
