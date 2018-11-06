package com.zhiguogongfang.Test;

import com.zhiguogongfang.domain.Employee;
import com.zhiguogongfang.mapper.EmployeeMapper;
import org.apache.ibatis.session.SqlSession;

import java.util.HashMap;
import java.util.List;

public class WhereTest {
    public static void main(String[] args) {
    SqlSession session = FKSqlSessionFactory.getSqlSession();
    EmployeeMapper em = session.getMapper(EmployeeMapper.class);
    HashMap<String, Object> params = new HashMap<String, Object>();
    params.put("id", 1);
    List<Employee> list =em.selectEmployeeByIdWhere(params);

}
}
