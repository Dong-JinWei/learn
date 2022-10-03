package com.dowei.HttpServletRequest;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.Arrays;

public class ParameterServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String[] hobby = request.getParameterValues("hobby");

        System.out.println("用户名："+ username);
        System.out.println("密码："+ password);
        System.out.println("兴趣爱好："+ Arrays.asList(hobby));

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String[] hobby = request.getParameterValues("hobby");

        System.out.println("post用户名："+ username);
        System.out.println("post密码："+ password);
        System.out.println("post兴趣爱好："+ Arrays.asList(hobby));

    }
}
