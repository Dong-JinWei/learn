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
        // 弹出窗口，显示下载的文件名，选择保存文件的目录
        response.setHeader("Content-Disposition", "attachment;fileName="+URLEncoder.encode(file,"utf-8"));
        // 根据文件名创建输入流对象
        FileInputStream in = new FileInputStream("D:\\ACGN\\Wallpaper\\" + file);
        // 根据response创建输入了对象
        ServletOutputStream out = response.getOutputStream();
        // 通过输入流对象从文件读数据
        // 通过输出流对象，将读取的数据发送给客户端
        // 循环操作，直到将文件的数据发送完成
        byte[] b = new byte[1024];
        while (true){
            int len = in.read(b);
            if (len <= 0){
                break;
            }else {
                out.write(b, 0, len);
            }
        }
        // 关闭资源
        out.close();
        in.close();
    }
}
