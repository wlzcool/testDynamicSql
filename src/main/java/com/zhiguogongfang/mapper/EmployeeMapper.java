package com.zhiguogongfang.mapper;

import com.zhiguogongfang.domain.Employee;

import java.util.HashMap;
import java.util.List;

public interface EmployeeMapper {
    List<Employee> selectEmployeeByIdLike(HashMap<String,Object> param);
    List<Employee> selectEmployeeByLoginNameLike(HashMap<String,Object> param);
    List<Employee> selectEmployeeChoose(HashMap<String,Object> param);
    List<Employee> selectEmployeeByIdWhere(HashMap<String,Object> param);
    List<Employee> selectEmployeeIn(List<Integer> idList);
    List<Employee> selectEmployeeLike(HashMap<String,Object> param);
    void updateEmployeeIfNecessary(Employee employee);
}
