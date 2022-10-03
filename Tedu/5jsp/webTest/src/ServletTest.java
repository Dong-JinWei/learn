import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Arrays;

@WebServlet(name = "ServletTest", value = "/test")
public class ServletTest extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        String user = request.getParameter("user");
        String pwd = request.getParameter("pwd");
        String sex = request.getParameter("sex");
        String[] joys = request.getParameterValues("joy");
        String city = request.getParameter("city");

        System.out.println(user);
        System.out.println(pwd);
        System.out.println(sex);
        System.out.println(Arrays.toString(joys));
        System.out.println(city);

        if ("dowei".equals(user) && "123".equals(pwd)){
            request.setAttribute("username", user);
            request.setAttribute("password", pwd);
            request.getRequestDispatcher("/ok.jsp").forward(request, response);
        }else {
            request.getRequestDispatcher("/false.jsp").forward(request, response);
        }
    }
}
