package com.tedu.test;

import com.tedu.dao.UserDao;
import com.tedu.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/*测试类，测试Mybatis环境*/
public class TestMybatis {

    private UserDao userDao;

    @Test
    public void testMybatis() throws IOException {
        //1.读取核心配置文件
        InputStream in =
                Resources.getResourceAsStream(
                        "mybatis/mybatis-config.xml");
        //2.获取SqlsessionFactory工厂
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        //3.获取session
        SqlSession session = factory.openSession();
        //4.获取mapper接口
        UserDao userDao = session.getMapper(UserDao.class);
        //5.调用方法查询.
        //List<User> users = userDao.findAll();
//        for(User user:users){
//            System.out.println(user);
//        }


     }

}
