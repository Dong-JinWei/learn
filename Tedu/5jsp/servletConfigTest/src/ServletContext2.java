import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ServletContext2", value = "/ServletContext2")
public class ServletContext2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext servletContext = this.getServletContext();
        String u8 = servletContext.getInitParameter("charset");
        String gbk = servletContext.getInitParameter("charset_GBK");
        System.out.println("u8: " + u8);
        System.out.println("gbk: " + gbk);
    }
}
