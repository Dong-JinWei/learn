import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "TestSession2", value = "/TestSession2")
public class TestSession2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Object sessUser = session.getAttribute("sessUser");
        Object reqUser = request.getAttribute("reqUser");

        System.out.println("sessUser: " + sessUser);
        System.out.println("reqUser: " + reqUser);
    }
}
