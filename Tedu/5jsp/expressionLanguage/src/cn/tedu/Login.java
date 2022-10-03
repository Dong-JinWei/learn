package cn.tedu;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/Login")
public class Login extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String pwd = req.getParameter("pwd");
        String check = req.getParameter("check");
        if ("dowei".equals(username) && "123".equals(pwd)){
            if(check != null){
                Cookie cookie = new Cookie("name", "dowei");
                cookie.setMaxAge(300);
                cookie.setPath("/");
                resp.addCookie(cookie);
            }
            req.getRequestDispatcher("ok.jsp").forward(req,resp);
        }else {
            req.getRequestDispatcher("error.jsp").forward(req,resp);
        }
    }
}
