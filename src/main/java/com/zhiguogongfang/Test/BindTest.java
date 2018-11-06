package com.zhiguogongfang.Test;

import com.zhiguogongfang.domain.Employee;
import com.zhiguogongfang.mapper.EmployeeMapper;
import org.apache.ibatis.session.SqlSession;

import java.util.HashMap;
import java.util.List;

public class BindTest {
    public static void main(String[] args) {
        SqlSession session = FKSqlSessionFactory.getSqlSession();
        EmployeeMapper em = session.getMapper(EmployeeMapper.class);
        HashMap<String,Object> param =new HashMap<>();
        param.put("name","te");
        //Employee e =new Employee();
        //e.setName("te");
        List<Employee> list = em.selectEmployeeLike(param);
        list.forEach(ea -> System.out.println(ea));
    }
}
