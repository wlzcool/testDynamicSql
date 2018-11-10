package com.zhiguogongfang.Test;

import com.zhiguogongfang.domain.Employee;
import com.zhiguogongfang.mapper.EmployeeMapper;
import org.apache.ibatis.session.SqlSession;

import java.util.HashMap;
import java.util.List;

public class OneLevelCacheTest {
    public static void main(String[] args) {
        SqlSession session = FKSqlSessionFactory.getSqlSession();
        EmployeeMapper em = session.getMapper(EmployeeMapper.class);
        HashMap<String, Object> params = new HashMap<String, Object>();
        params.put("id", 1);
        List<Employee> list = em.selectEmployeeByIdLike(params);
        list.forEach(e -> System.out.println(e));
        HashMap<String, Object> paramsForLoginName = new HashMap<String, Object>();
        paramsForLoginName.put("loginname", "C#");
        paramsForLoginName.put("password", "123456");
        List<Employee> employees = em.selectEmployeeByLoginNameLike(paramsForLoginName);
        employees.forEach(e -> System.out.println(e));
        //有一级缓存，不会查询数据库
        System.out.println("有一级缓存，不会查询数据库");
        HashMap<String, Object> params2 = new HashMap<String, Object>();
        params2.put("id", 1);
        List<Employee> list2 = em.selectEmployeeByIdLike(params2);
        list2.forEach(e -> System.out.println(e));
        //更新数据
        Employee employee = new Employee();
        employee.setName("ttt123");
        employee.setId(1);
        em.updateEmployeeIfNecessary(employee);
        //奇怪，这里的update会自动提交到数据库。。。
//        session.commit();
        //session.rollback();
        //缓存被清，会重新查询数据库（貌似不论提交没有提交数据库，一级缓存都会被清）
        System.out.println("缓存被清，会重新查询数据库");


        List<Employee> list3 = em.selectEmployeeByIdLike(params2);
        list3.forEach(e -> System.out.println(e));
        session.close();
        System.out.println("一级缓存不会起效果，会重新查询数据");
        SqlSession session2 = FKSqlSessionFactory.getSqlSession();
        EmployeeMapper em2 = session2.getMapper(EmployeeMapper.class);
        List<Employee> list4 = em2.selectEmployeeByIdLike(params2);
        list4.forEach(e -> System.out.println(e));

    }
}
