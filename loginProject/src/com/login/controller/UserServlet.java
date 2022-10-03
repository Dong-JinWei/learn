package com.login.controller;

import com.login.entity.vo.MessageModel;
import com.login.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class UserServlet extends HttpServlet {

    //实例化UserService对象
    private UserService userService = new UserService();

    @Override
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1. 接收客户端的请求（接收参数：姓名、密码）
        String uname = request.getParameter("uname");
        String upwd = request.getParameter("upwd");

        //2. 调用service层的方法，返回消息模型对象
        MessageModel messageModel = userService.userLogin(uname,upwd);

        //3. 判断消息模型的状态码
        if(messageModel.getCode() == 1) {
            // 将消息模型中的用户信息设置到session作用域中，重定像到index.jsp
            request.getSession().setAttribute("user",messageModel.getObject());
            response.sendRedirect("index.jsp");
        }else{
            request.setAttribute("messageModel",messageModel);
            request.getRequestDispatcher("login.jsp").forward(request,response);
        }
    }
}
