import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(value = "/req")
public class ServletReqRes extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取客户端发送的数据
        String user = req.getParameter("user");
        String pwd = req.getParameter("pwd");
        System.out.println(user + ":" + pwd);

        // 给客户端响应数据
        PrintWriter out = resp.getWriter();
//        out.write("abc");
//        out.write("<p style='color:red;'>zzz</p>");
        out.write(user + ":" + pwd);
    }
}
