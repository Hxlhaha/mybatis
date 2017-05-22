package com.ujn.hxl.test;

import com.ujn.hxl.inter.IUserOperation;
import com.ujn.hxl.model.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.Reader;

/**
 * Created by lss on 2017/5/21.
 */
public class Test {
    private static SqlSessionFactory sqlSessionFactory;
    private static Reader reader;
    static {
        try {
            reader = Resources.getResourceAsReader("mybatis-config.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static SqlSessionFactory getSession(){
        return sqlSessionFactory;
    }

    public static void test1(){
        SqlSession session = sqlSessionFactory.openSession();
        try {
            User user = (User)session.selectOne("com.ujn.hxl.models.UserMapper.selectUserByID",1);
            System.out.println(user.getUserName());
            System.out.println(user.getUserAddress());
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(session!=null){
                session.close();
            }
        }
    }

    public static void test2(){
        SqlSession session = sqlSessionFactory.openSession();
        try {
            IUserOperation userOperation  = session.getMapper(IUserOperation.class);
            User user = userOperation.selectUserByID(1);
            System.out.println(user.getUserName());
            System.out.println(user.getUserAddress());
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(session!=null){
                session.close();
            }
        }
    }

    public static void main(String[] args) {
        test2();
    }
}
