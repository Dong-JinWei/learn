package cn.tedu.test;

import cn.tedu.bean.Student;
import cn.tedu.mapper.StudentMapper;
import com.sun.corba.se.impl.javax.rmi.CORBA.StubDelegateImpl;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MyBatisTest {
    public static void main(String[] args) throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("mysql/mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        try (SqlSession session = sqlSessionFactory.openSession(true)){
            StudentMapper mapper = session.getMapper(StudentMapper.class);
            // 使用$时，会有 sql 注入问题
            // 使用#时，没有 sql 注入
            List<Student> stuByName = mapper.findStuByName("'admin' or 'b' = 'b'");
            for (Student student : stuByName) {
                System.out.println(student);
            }


            // ${} 的使用场景1
            //  OrderBy排序时，desc和asc都是关键字，如果使用#{} 那么，系统会自动将它识别为字符串此时就会报错
            //      如果使用${} 系统不会将关键字转换为字符串，就可以实现排序
            List<Student> desc = mapper.findUserOrderBy("desc");
            for (Student student : desc) {
                System.out.println(student);
            }

            // ${} 的使用场景2
            // 使用模糊查询时，LIKE('%${like}%') 单引号已经写好了，所以使用#传参数时，会报错
            //      而使用$时，传入的值不会转换，所以并不会报错
            List<Student> userByLike = mapper.findUserByLike("d");
            for (Student student : userByLike) {
                System.out.println(student);
            }

        }
    }
}
