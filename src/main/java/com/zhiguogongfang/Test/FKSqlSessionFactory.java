package com.zhiguogongfang.Test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.*;
import java.io.InputStream;


public class FKSqlSessionFactory {
    private static SqlSessionFactory sqlSessionFactory=null;
    static {
        try {
            String resource = "mybatis-config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            sqlSessionFactory =new SqlSessionFactoryBuilder().build(inputStream);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public static SqlSession getSqlSession(){
        return sqlSessionFactory.openSession(false);
    }
    public static SqlSessionFactory getSqlSessionFactory(){
        return sqlSessionFactory;
    }
}
