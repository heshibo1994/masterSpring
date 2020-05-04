package com.smart.springboot06datambatis.mapper;

import com.smart.springboot06datambatis.entity.Department;
import org.apache.ibatis.annotations.*;

@Mapper
public interface DepartmentMapper {

    @Select("select * from department where id=#{id}")
    public Department getDepartment(Integer id);

    @Delete("delete from department where id=#{id}")
    public int deleteDepartment(Integer id);

    @Options(useGeneratedKeys = true,keyProperty = "id")
    @Insert("insert into department(departmentName)values(#{departmentName}) ")
    public int insertDept(Department department);

    @Update("update department set departmentName=#{departmentName} where id=#{id}")
    public int updateDepartment(Department department);
}
