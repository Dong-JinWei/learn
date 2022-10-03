import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

@WebServlet(value = "/request")
public class TestRequest extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String user = req.getParameter("user");
        String pwd = req.getParameter("pwd");
        String sex = req.getParameter("sex");
        String book = req.getParameter("book");
        String city = req.getParameter("city");
        String[] joys = req.getParameterValues("joy");

        System.out.println("**********");
        System.out.println(user);
        System.out.println(pwd);
        System.out.println(sex);
        System.out.println(book);
        System.out.println(city);
        System.out.println(Arrays.toString(joys));

        // 页面跳转
        if ("djw".equals(user) && "123".equals(pwd)){
            req.setAttribute("name", user);
            req.getRequestDispatcher("/ok.jsp").forward(req,resp);
        }else {
            req.getRequestDispatcher("/false.jsp").forward(req, resp);
        }

        Student student = new Student("1", "djw");
        req.setAttribute("stu", student);
        Object stu = req.getAttribute("stu");
        System.out.println(stu);
    }
}
