package cn.tedu;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/login")
public class Login extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String user = req.getParameter("user");
        String pwd = req.getParameter("pwd");
        String check = req.getParameter("check");
        if ("dowei".equals(user) && "123".equals(pwd)){
            if (check != null){
                Cookie cookie = new Cookie("user", user);
                cookie.setMaxAge(300);
                cookie.setPath("/");
                resp.addCookie(cookie);
            }
            req.getRequestDispatcher("ok.jsp").forward(req,resp);
        }
    }
}
