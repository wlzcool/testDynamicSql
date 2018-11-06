package com.zhiguogongfang.Test;

import com.zhiguogongfang.domain.Employee;
import com.zhiguogongfang.mapper.EmployeeMapper;
import org.apache.ibatis.session.SqlSession;

import java.util.HashMap;
import java.util.List;

public class IfTest {
    public static void main(String[] args) {
        SqlSession session = FKSqlSessionFactory.getSqlSession();
        EmployeeMapper em = session.getMapper(EmployeeMapper.class);
        HashMap<String, Object> params = new HashMap<String, Object>();
        params.put("id", 1);
        List<Employee> list =em.selectEmployeeByIdLike(params);
        list.forEach(e->System.out.println(e));
        HashMap<String, Object> paramsForLoginName = new HashMap<String, Object>();
        paramsForLoginName.put("loginname", "C#");
        paramsForLoginName.put("password", "123456");
        List<Employee> employees =em.selectEmployeeByLoginNameLike(paramsForLoginName);
        employees.forEach(e->System.out.println(e));

    }
}
