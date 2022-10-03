import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/register")
public class RegisterFail extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String uname = req.getParameter("user");
        String pwd = req.getParameter("pwd");
        User user = new User(uname, pwd);
        UserDao userDao = new UserDao();

        int effect = userDao.addUser(user);

        if (effect > 0){
            req.getRequestDispatcher("/registerOk.jsp").forward(req, resp);
        }else {
            req.getRequestDispatcher("/registerFail.jsp").forward(req, resp);
        }
    }
}
