package com.smart.context;

import com.smart.reflect.Car;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Beans {
    @Bean(name = "car1")
    public Car builder(){
        Car car = new Car();
        car.setBrand("法拉利1");
        car.setMaxSpeed(200);
        return car;
    }
}
