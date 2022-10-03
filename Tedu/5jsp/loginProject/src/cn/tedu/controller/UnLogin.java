package cn.tedu.controller;

import cn.tedu.bean.User;
import cn.tedu.dao.UserDao;
import cn.tedu.dao.UserDaoImp;
import cn.tedu.service.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "UnLogin", value = "/UnLogin")
public class UnLogin extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie[] cookies = request.getCookies();
        String username = null;
        for (Cookie cookie : cookies) {
            String name = cookie.getName();
            if ("username".equals(name)){
                username = cookie.getValue();
            }
        }

        Cookie cookie = new Cookie("username", username);
        cookie.setMaxAge(0);
        cookie.setPath("/");
        response.addCookie(cookie);
        response.sendRedirect(request.getContextPath() + "/login.jsp");
    }
}
