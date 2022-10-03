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
//        response.getWriter().write("{username:'dowei', password:'123'}");
        String username = request.getParameter("user");
        String pwd = request.getParameter("pwd");
        System.out.println(username + " " +pwd);
        if("dowei".equals(username) && "123".equals(pwd)){
            response.getWriter().write("true");
        }else{
            response.getWriter().write("false");
        }
    }
}
