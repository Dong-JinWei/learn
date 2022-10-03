package com.tedt.test;

import com.tedt.bean.Student;
import com.tedt.mapper.ResultMapMapper;
import com.tedt.mapper.StudentMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ResultMapTest {
    public static void main(String[] args) throws IOException {
//        指定mybatis-config.xml的配置文件路径
        String resource = "mysql/mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        try (SqlSession session = sqlSessionFactory.openSession(true)) {
            ResultMapMapper mapper = session.getMapper(ResultMapMapper.class);
            Student studentById = mapper.findStudentById(2);
            System.out.println(studentById);


            Map<String, Object> partById = mapper.findPartById(1);
            System.out.println(partById);

            List<Student> all = mapper.findAll();
            System.out.println(all);

            Student student = new Student(null, "JoJo", "JoJo");
            int i = mapper.insertStudent(student);
            System.out.println(i);
            System.out.println(student.getsId());

        }
    }
}
