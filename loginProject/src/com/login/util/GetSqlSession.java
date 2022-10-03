package com.login.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.*;
import java.io.*;

public class GetSqlSession {
    /**
     * 获取SqlSession对象
     * @return
     */

    public static SqlSession createSqlSession(){
        SqlSessionFactory sqlSessionFactory = null;
        InputStream input = null;
        SqlSession session = null;

        try {
            //获得mybatis的环境配置文件
            String resource = "mybatis-config.xml";
            //以流的方式获取recource（mybatis的环境配置文件）
            input = Resources.getResourceAsStream(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(input);
            session = sqlSessionFactory.openSession();
            return session;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        System.out.println(createSqlSession());
    }

}
