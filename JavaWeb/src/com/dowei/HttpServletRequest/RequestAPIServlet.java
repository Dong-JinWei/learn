package com.dowei.HttpServletRequest;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RequestAPIServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //getRequestUTI()
        System.out.println("获取统一资源标识符URI："+ req.getRequestURI());

        //getRequestUTL()
        System.out.println("获取统一资源定位符："+ req.getRequestURL());

        //getRemoteHost()
        System.out.println("获取客户端的ip地址："+ req.getRemoteHost());

        //getHeader()
        System.out.println("获取请求头User-Agent：" + req.getHeader("User-Agent"));

        //getMethod()
        System.out.println("获取当前的请求方式：" + req.getMethod());
    }
}
