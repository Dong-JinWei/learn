import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/login")
public class LoginServer extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uname = req.getParameter("user");
        String pwd = req.getParameter("pwd");
        User user = new User(uname, pwd);
        UserDao userDao = new UserDao();
        int effect = userDao.selectUser(user);
        if (effect > 0){
            req.getRequestDispatcher("/loginOK.jsp").forward(req, resp);
        }else {
            req.getRequestDispatcher("/loginFail.jsp").forward(req, resp);
        }
    }
}
