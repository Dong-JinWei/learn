package cn.tedu.test;

import cn.tedu.bean.User;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanTest {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        //// 单例模式
        //User userBead = context.getBean("userBean", User.class);
        //User userBead2 = context.getBean("userBean", User.class);
        //System.out.println(userBead == userBead2); // true
        //
        //// 非单例模式
        //User userBead = context.getBean("userBean", User.class);
        //User userBead2 = context.getBean("userBean", User.class);
        //System.out.println(userBead == userBead2); // false

        // 单例模式，延迟初始化 true
        //User userBead = context.getBean("userBean", User.class);

        // 使用有参构造
        User userBead = context.getBean("userBean", User.class);
        System.out.println(userBead);





    }
}
