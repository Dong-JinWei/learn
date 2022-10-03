import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.*;

@WebServlet(name = "Login", value = "/Login")
public class Login extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取用户名和密码
        String user = request.getParameter("user");
        String pwd = request.getParameter("pwd");
        int num = -1;
        // 加载驱动
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            // 建立连接
            String url = "jdbc:mysql://localhost:3306/mysql0327?serverTimezone=UTC&characterEncoding=utf8&useUnicode=true&useSSL=false";
            String dbUser = "root";
            String dbPwd = "123456";
            Connection conn = DriverManager.getConnection(url, dbUser, dbPwd);
            String sql = "select count(*) from user WHERE username=? and password=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, user);
            ps.setString(2, pwd);
            ResultSet rs = ps.executeQuery();

            if (rs.next()){
                num = rs.getInt("count(*)");
            }

            if (num > 0){
                request.getRequestDispatcher("/ok.jsp").forward(request, response);
            }else {
                request.getRequestDispatcher("/WEB-INF/error.jsp").forward(request, response);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        // 创建preparedstatement对象
        // 执行execueQue
        // 获取记录数
        // 更具记录数进行跳转
    }
}
