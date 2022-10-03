package com.tedu;

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
        String user = request.getParameter("user");
        String pwd = request.getParameter("pwd");
        String check = request.getParameter("check");
        if ("dowei".equals(user) && "123".equals(pwd)) {
            if (check != null) {
                Cookie cookie = new Cookie("user", user);
                cookie.setMaxAge(300);
                cookie.setPath("/");
                response.addCookie(cookie);
            }
            request.getRequestDispatcher("ok.jsp").forward(request, response);
        }

    }
}
