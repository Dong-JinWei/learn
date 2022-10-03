package cn.tedu;

import cn.tedu.bean.User;
import cn.tedu.mapper.UserMapper;
import cn.tedu.mapper.UserMapperMore;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyBatisMoreTest {
    public static void main(String[] args) throws IOException {
        //        指定mybatis-config.xml的配置文件路径
        String resource = "mysql/mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        try (SqlSession session = sqlSessionFactory.openSession(true)) {
            UserMapperMore mapper = session.getMapper(UserMapperMore.class);
//            int i = mapper.insertUserMore("ala", "ala");
//            System.out.println("插入了："+i);
//
//            int i2 = mapper.insertUserMoreParam("ala1", "ala1");
//            System.out.println("插入了："+i2);

//            User user = new User("ala", "1232133");
//            int i1 = mapper.updateUserMore(user);
//            System.out.println("update了：" + i1);
//
//            User user1 = new User("zxcv", "qwerasdfzsdv");
//            int i2 = mapper.updateUserMore(user1);
//            System.out.println("update了：" + i2);
//
//            User user2 = new User("ala", "1232133");
//            int i3 = mapper.deleteUserMoreParam(user2);
//            System.out.println("delete: " + i3);

            HashMap<String, Object> map = new HashMap<>();
            map.put("uName", "ala");
            map.put("uPassword", "qwe");
            int mapEffect = mapper.updateUserMoreMap(map);
            System.out.println(mapEffect);

            HashMap<String, Object> mapParam = new HashMap<>();
            mapParam.put("uName", "ala");
            mapParam.put("uPassword", "asd");
            int mapEffectParam = mapper.updateUserMoreMapParam(mapParam);
            System.out.println(mapEffectParam);

            List<String> list = new ArrayList<>();
            list.add("djw");
            list.add("djw");
            int effectList = mapper.insertUserMoreList(list);
            System.out.println(effectList);

        }
    }
}
