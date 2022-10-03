import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

@WebServlet(name = "DownloadServlet", value = "/DownloadServlet")
public class DownloadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取需要下载的文件名
        String file = request.getParameter("file");
        // 设置发送文件的格式和编码
        response.setHeader("Content-Disposition", "attachment;fileName=" + URLEncoder.encode(file, "utf-8"));
        // 根据文件名创建输入流对象
        FileInputStream in = new FileInputStream("D:\\ACGN\\Wallpaper\\" + file);
        // 根据response创建数据对象
        ServletOutputStream out = response.getOutputStream();
        byte[] bytes = new byte[1024];
        while (true) {
            int len = in.read(bytes);
            if (len <= 0) {
                break;
            }
            out.write(bytes, 0, len);
        }

        // 关闭资源
        out.close();
        in.close();


    }
}
