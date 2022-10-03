package cn.tedu;

import cn.tedu.bean.User;
import cn.tedu.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MyBatisTest {
    public static void main(String[] args) throws IOException {
        //        指定mybatis-config.xml的配置文件路径
        String resource = "mysql/mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        try (SqlSession session = sqlSessionFactory.openSession(true)) {
            UserMapper mapper = session.getMapper(UserMapper.class);
            User user = mapper.findUser("admin");
            System.out.println("用户名："+ user.getuName() + "密码：" + user.getuPassword());
            int i = mapper.insertUser("djw");
            System.out.println("插入了"+i);
            int effect = mapper.delUser("djw");
            System.out.println(effect);

        }
    }
}
