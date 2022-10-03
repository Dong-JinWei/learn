package cn.tedu.bean;

import cn.tedu.bean.Aoon.AnnoUser;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserTest {

    @Test
    public void userTest(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        User user01 = context.getBean("user01", User.class);
        System.out.println(user01);
    }

    @Test
    public void annoTest(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("Annotation.xml");

        AnnoUser user = context.getBean("AnnoUser", AnnoUser.class);
        System.out.println(user);
    }

    @Test
    public void scopeAnnoTest(){
        ApplicationContext context = new ClassPathXmlApplicationContext("Annotation.xml");
        AnnoUser annoUser1 = context.getBean("AnnoUser", AnnoUser.class);
        AnnoUser annoUser2 = context.getBean("AnnoUser", AnnoUser.class);
        System.out.println(annoUser1 == annoUser2);
        //context.close();
        ((ClassPathXmlApplicationContext) context).close();
    }


}
