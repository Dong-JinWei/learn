import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ServletTest extends HttpServlet {
    int j = 0;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int i = 0;
        i++;
        j++;
        System.out.println("i = " + i);
        System.out.println("j = " + j);
        System.out.println("===========");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        doGet(req, resp);
        int i = 0;
        i++;
        j++;
        System.out.println("i = " + i);
        System.out.println("j = " + j);
        System.out.println("===========");
    }


}
