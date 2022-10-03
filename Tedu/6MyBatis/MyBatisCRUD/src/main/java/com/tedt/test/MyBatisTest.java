package com.tedt.test;

import com.tedt.bean.Student;
import com.tedt.mapper.StudentMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;

public class MyBatisTest {
    public static void main(String[] args) throws IOException {
//        指定mybatis-config.xml的配置文件路径
        String resource = "mysql/mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        try (SqlSession session = sqlSessionFactory.openSession(true)) {
            StudentMapper mapper = session.getMapper(StudentMapper.class);
            Student student = new Student(null, "djw", "djw");
            int i = mapper.insertStudent(student);
            System.out.printf("增加了%d个学生\n", i);

            int i1 = mapper.insertStudentMore("zx", "zx");
            System.out.printf("增加了%d个学生\n", i1);

            HashMap<String, Object> map= new HashMap<>();
            map.put("id", 4);
            map.put("name", "jonny");
            map.put("pwd", "jonny");
            int i2 = mapper.updateStudent(map);
            System.out.printf("更新了%d个学生\n", i2);

        }
    }
}
