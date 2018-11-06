package com.zhiguogongfang.Test;

import com.zhiguogongfang.domain.Employee;
import com.zhiguogongfang.mapper.EmployeeMapper;
import org.apache.ibatis.session.SqlSession;

import java.util.HashMap;
import java.util.List;

public class SetTest {
    public static void main(String[] args) {
        SqlSession session = FKSqlSessionFactory.getSqlSession();
        EmployeeMapper em = session.getMapper(EmployeeMapper.class);
        Employee employee=new Employee();
        employee.setName("test");
        employee.setId(1);
        em.updateEmployeeIfNecessary(employee);
        //session.commit();
        session.close();
    }
}
