package com.dowei.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class ContextServlet1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext context = getServletContext();

        System.out.println("赋值之前的context1 中的key1 的值是："+ context.getAttribute("key1"));

        context.setAttribute("key1","value1");

        System.out.println("context1 中的key1 的值是："+ context.getAttribute("key1"));
        System.out.println("context1 中的key1 的值是："+ context.getAttribute("key1"));
        System.out.println("context1 中的key1 的值是："+ context.getAttribute("key1"));
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }
}
