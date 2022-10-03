package com.dowei.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class ContextServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext context = getServletConfig().getServletContext();

        //获取上下文
        System.out.println("context 的username 是：" + context.getInitParameter("username"));
        System.out.println("context 的password 是：" + context.getInitParameter("password"));

        //获取工程路径
        System.out.println("工程部署的路径是："+ context.getContextPath());
        System.out.println("工程的真实路径是："+ context.getRealPath("/"));



    }
}
