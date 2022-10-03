package cn.tedu;

import javax.servlet.*;
import javax.servlet.annotation.*;

@WebListener
public class ApplicationListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("ApplicationListener---init-------");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println("ApplicationListener----destroy-----");
    }
}
