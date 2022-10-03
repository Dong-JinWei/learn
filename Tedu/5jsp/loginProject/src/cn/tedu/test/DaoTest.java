package cn.tedu.test;

import cn.tedu.bean.User;
import cn.tedu.dao.UserDao;
import cn.tedu.dao.UserDaoImp;
import org.testng.annotations.Test;

public class DaoTest {
    UserDao dao = new UserDaoImp();
    @Test
    public void findUser(){
        User user = new User("admin", "admin");
        int res = dao.findUser(user);
        System.out.println(res);
    }

    @Test
    public void addUser(){
        User user = new User("qwe", "qwe");
        int i = dao.addUser(user);
        System.out.println(i);
    }

    @Test
    public void findUserByName(){
        int ok = dao.findUserByName("admin");
        System.out.println(ok);
    }
}
