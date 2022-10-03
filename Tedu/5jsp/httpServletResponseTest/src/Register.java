import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(name = "Register", value = "/Register")
public class Register extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String user = request.getParameter("user");
        String pwd = request.getParameter("pwd");
        int num = -1;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            // 建立连接
            String url = "jdbc:mysql://localhost:3306/mysql0327?serverTimezone=UTC&characterEncoding=utf8&useUnicode=true&useSSL=false";
            String dbUser = "root";
            String dbPwd = "123456";
            Connection conn = DriverManager.getConnection(url, dbUser, dbPwd);
            String sql = "insert into user(username, password) values(?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, user);
            ps.setString(2, pwd);
            num = ps.executeUpdate();


            if (num > 0){
                request.getRequestDispatcher("/registerOK.jsp").forward(request, response);
            }else {
                request.getRequestDispatcher("/registerOK.jsp").forward(request, response);
            }


        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
