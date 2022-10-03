package cn.tedu.test;

import cn.tedu.dao.AccountDao;
import cn.tedu.domain.Account;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class Test01Mybatis {
    public static void main(String[] args) throws IOException {
        // 1. 创建sqlSessionFactoryBuilder
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();

        // 2. 加载核心配置文件
        InputStream in = Resources.getResourceAsStream("mybatis-config.xml");

        // 3. 创建sqlSessionFactory对象
        SqlSessionFactory factory = sqlSessionFactoryBuilder.build(in);
        // 4. 获取session对象
        SqlSession sqlSession = factory.openSession(true);
        // 5. 执行sqlSession对象进行查询结果
        AccountDao mapper = sqlSession.getMapper(AccountDao.class);
        List<Account> all = mapper.findAll();
        System.out.println(all);
        sqlSession.close();
    }

}
