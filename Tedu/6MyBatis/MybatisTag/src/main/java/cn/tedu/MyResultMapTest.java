package cn.tedu;

import cn.tedu.bean.User;
import cn.tedu.mapper.ResultMapMapper;
import cn.tedu.mapper.UserMapper;
import cn.tedu.mapper.UserMapperMore;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

public class MyResultMapTest {
    public static void main(String[] args) throws IOException {
        //        指定mybatis-config.xml的配置文件路径
        String resource = "mysql/mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        try (SqlSession session = sqlSessionFactory.openSession(true)) {
            ResultMapMapper mapper = session.getMapper(ResultMapMapper.class);

            User user = mapper.findUserByName("admin");
            System.out.println(user);

            User insertUser = new User("jk", "jk");
            int effectInsert = mapper.insertUser(insertUser);
            System.out.println(effectInsert);
            String name = insertUser.getuName();
            System.out.println(name);

            Map<String, Object> admin = mapper.findPartByName("admin");
            System.out.println(admin);


            List<User> userAll = mapper.findUserAll();
            System.out.println(userAll);


        }
    }
}
