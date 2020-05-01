package com.smart.springboot04webrestfulcrud.dao;

import com.smart.springboot04webrestfulcrud.entity.Department;
import com.smart.springboot04webrestfulcrud.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class EmployeeDao {
    private static Map<Integer, Employee> employees = null;

    @Autowired
    private DepartmentDao departmentDao;
    static{
        employees = new HashMap<Integer, Employee>();
        employees.put(1,new Employee(1,"e_AA","e_AA_1@163.com",1,new Department(101,"d_AA"),new Date(2014, 1, 1)));
        employees.put(1,new Employee(2,"e_BB","e_BB_2@163.com",0,new Department(102,"d_BB"),new Date(2015, 2, 2)));
        employees.put(1,new Employee(3,"e_CC","e_CC_3@163.com",0,new Department(103,"d_CC"),new Date(2016, 4, 4)));
        employees.put(1,new Employee(4,"e_DD","e_DD_4@163.com",1,new Department(104,"d_DD"),new Date(2017, 5, 5)));
    }
    private static Integer initId = 4;

    public void save(Employee employee){
        if(employee.getId() == null){
            employee.setId(initId++);
        }

        employee.setDepartment(departmentDao.getDepartment(employee.getDepartment().getId()));
        employees.put(employee.getId(), employee);
    }

    //查询所有员工
    public Collection<Employee> getAll(){
        return employees.values();
    }

    public Employee get(Integer id){
        return employees.get(id);
    }

    public void delete(Integer id){
        employees.remove(id);
    }
}
