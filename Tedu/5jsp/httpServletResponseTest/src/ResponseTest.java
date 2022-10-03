import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ResponseTest", value = "/ResponseTest")
public class ResponseTest extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.write("<html>\n" + "  <head>\n" + "    <title>$Title$</title>\n" + "  </head>\n" + "  <body>\n" + "  <p style=\"font-size: 30px; color: red\">$END$</p>\n" + "hello world" + "你好" + "  </body>\n" + "</html>");
        // response.sendRedirect("/httpServletResponseTest_war_exploded/ok.jsp");
        String user = request.getParameter("user");
        request.setAttribute("user", user);
        // 转发可以获取数据
        // request.getRequestDispatcher("ok.jsp").forward(request, response);

        // 重定向无法获取数据
        response.sendRedirect("/httpServletResponseTest_war_exploded/ok.jsp");
        out.close();
    }
}
