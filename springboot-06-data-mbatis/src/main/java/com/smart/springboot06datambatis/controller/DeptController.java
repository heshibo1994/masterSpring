package com.smart.springboot06datambatis.controller;

import com.smart.springboot06datambatis.entity.Department;
import com.smart.springboot06datambatis.entity.Employee;
import com.smart.springboot06datambatis.mapper.DepartmentMapper;
import com.smart.springboot06datambatis.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeptController {
   @Autowired(required = false)
    DepartmentMapper departmentMapper;

   @Autowired(required = false)
    EmployeeMapper employeeMapper;

   @GetMapping("/dept/{id}")
   public Department getDepartment(@PathVariable("id") Integer id){
       return departmentMapper.getDepartment(id);
   }

    @GetMapping("/dept")
    public Department insertDept(Department department){
        departmentMapper.insertDept(department);
        return department;
    }

    @GetMapping("/employee/{id}")
    public Employee getEmployee(@PathVariable("id") Integer id){
        return employeeMapper.getEmpById(id);
    }


    @GetMapping("/employee")
    public Employee insertEmployee(Employee employee){
        employeeMapper.insertEmp(employee);
        return employee;
    }

}
