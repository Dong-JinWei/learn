import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "TestSession1", value = "/TestSession1")
public class TestSession1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Object requestName = request.getAttribute("name");
        HttpSession session = request.getSession();
        Object sessionName = session.getAttribute("name");
        System.out.println("requestName" + ":" + requestName);
        System.out.println("sessionName" + ":" + sessionName);
    }
}
