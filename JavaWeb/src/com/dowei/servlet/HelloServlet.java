package com.dowei.servlet;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class HelloServlet implements Servlet {

    public HelloServlet() {
        System.out.println("1 构造起方法被调用了");
    }

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("2、init方法被调用");

        System.out.println("HelloServlet 程序的别名是："+ servletConfig.getServletName());

        System.out.println("初始化参数Username的值是：" + servletConfig.getInitParameter("username"));
        System.out.println("初始化参数url的值是：" + servletConfig.getInitParameter("url"));

        System.out.println(servletConfig.getServletContext());

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    /**
     * server方法是专门处理请求和访问的
     */
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("3、servlet第一次被调用");



        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        String method = httpServletRequest.getMethod();

        if ("GET".equals(method)){
            doGet();
        }else if ("POST".equals(method)){
            doPost();
        }
    }
    public void doGet(){
        System.out.println("GET");
        System.out.println("GET");
    }
    public void doPost(){
        System.out.println("POST");
        System.out.println("POST");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {
        System.out.println("4、destroy方法被调用");

    }
}
