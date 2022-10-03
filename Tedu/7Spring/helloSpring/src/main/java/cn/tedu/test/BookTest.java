package cn.tedu.test;

import cn.tedu.bean.BookDaoImp;
import cn.tedu.service.BookServiceImp;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BookTest {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        BookDaoImp bookDao = context.getBean("bookDao", BookDaoImp.class);
        BookServiceImp bookService = context.getBean("bookService", BookServiceImp.class);

        bookDao.save();
        bookService.save();


    }
}
