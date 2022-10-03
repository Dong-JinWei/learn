package cn.tedu.test;

import cn.tedu.bean.User;
import cn.tedu.service.UserService;
import org.testng.annotations.Test;

public class ServiceTest {
    UserService service = new UserService();

    @Test
    public void userService(){
        User user = new User("admin", "admin");
        boolean ok = service.findUser(user);
        System.out.println(ok);
    }

    @Test
    public void addUserService(){
        User user = new User("2", "2");
        boolean b = service.addUser(user);
        System.out.println(b);
    }
}
