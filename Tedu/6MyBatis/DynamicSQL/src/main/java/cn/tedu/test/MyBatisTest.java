package cn.tedu.test;

import cn.tedu.bean.Student;
import cn.tedu.mapper.StudentMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class MyBatisTest {
    public static void main(String[] args) throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("mysql/mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        try (SqlSession session = sqlSessionFactory.openSession(true)) {
            StudentMapper mapper = session.getMapper(StudentMapper.class);

            //List<Student> userById = mapper.findUserById(1);
            //System.out.println(userById);
            //
            //List<Student> student = mapper.findStudent(2, "dowei", "dowei");
            //System.out.println(student);
            //
            //int effect = mapper.updateStudentBySet(17, "DIO", "DIO");
            //System.out.println(effect);
            //
            //List<Student> studentByTrim = mapper.findStudentByTrim(null, null, null);
            //System.out.println(student);

            //int i = mapper.updateStudentByTrim(17, null, "JoJo");
            //System.out.println(i);

            int i = mapper.deleteStudentByList(new ArrayList<Integer>() {
                {
                    add(8);
                    add(9);
                    add(10);
                    add(11);
                }
            });
            System.out.println(i);
        }
    }
}
