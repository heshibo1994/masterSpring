package com.smart.springboot06datambatis.mapper;

import com.smart.springboot06datambatis.entity.Employee;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EmployeeMapper {
    public Employee getEmpById(Integer id);

    public void insertEmp(Employee employee);

}
