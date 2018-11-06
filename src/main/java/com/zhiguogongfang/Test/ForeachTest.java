package com.zhiguogongfang.Test;

import com.zhiguogongfang.domain.Employee;
import com.zhiguogongfang.mapper.EmployeeMapper;
import org.apache.ibatis.session.SqlSession;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ForeachTest {
    public static void main(String[] args) {
        SqlSession session = FKSqlSessionFactory.getSqlSession();
        EmployeeMapper em = session.getMapper(EmployeeMapper.class);
        List<Integer> idList = new ArrayList<>();
        idList.add(1);
        idList.add(2);
        List<Employee> employees = em.selectEmployeeIn(idList);
        employees.forEach(e -> System.out.println(e));
    }
}