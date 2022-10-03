package cn.tedu.controller;

import cn.tedu.bean.User;
import cn.tedu.dao.UserDao;
import cn.tedu.dao.UserDaoImp;
import cn.tedu.service.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "Login", value = "/Login")
public class Login extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String check = request.getParameter("check");
        User user = new User(username, password);
        UserService userService = new UserService();
        boolean ok = userService.findUser(user);
        if (ok){
            if (Boolean.parseBoolean(check)){
                Cookie cookie = new Cookie("username", username);
                cookie.setMaxAge(2592000);
                cookie.setPath("/");
                response.addCookie(cookie);
            }
        }
        response.getWriter().write(ok+"");
    }
}
