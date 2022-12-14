package com.login.test;

import com.login.entity.User;
import com.login.mapper.UserMapper;
import com.login.util.GetSqlSession;
import org.apache.ibatis.session.SqlSession;


public class Test {
    public static void main(String[] args) {
        //sqlSession对象
        SqlSession session = GetSqlSession.createSqlSession();
        //得到对应Mapper
        UserMapper userMapper = session.getMapper(UserMapper.class);
        //调用方法，返回用户对象
        User user = userMapper.queryUserByName("admin");
        System.out.println(user);
    }
}
