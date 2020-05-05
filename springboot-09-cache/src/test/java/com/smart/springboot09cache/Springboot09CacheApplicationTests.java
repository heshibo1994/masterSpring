package com.smart.springboot09cache;

import com.smart.springboot09cache.entity.Employee;
import com.smart.springboot09cache.mapper.EmployeeMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Springboot09CacheApplicationTests {

    @Autowired
    EmployeeMapper employeeMapper;


    @Test
    void contextLoads() {
        Employee employee = employeeMapper.getEmpById(1);
        System.out.println(employee);
    }

}
