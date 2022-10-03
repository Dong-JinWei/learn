import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "UploadServlet", value = "/UploadServlet")
public class UploadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        // 检查客户端发送的是否是多媒体文件
        if (!ServletFileUpload.isMultipartContent(request)) {
            PrintWriter out = response.getWriter();
            out.print("Error:表单必须包含文件");
            out.flush();
            out.close();
            return;
        }
        try {
            // 创建磁盘工厂对象
            DiskFileItemFactory factory = new DiskFileItemFactory();
            // 创建文件上传工具对象
            ServletFileUpload upload = new ServletFileUpload(factory);
            // 通过上传工具接收request对象中的内容
            List<FileItem> list = upload.parseRequest(request);

            //从list中读取文件内容
            for (FileItem item: list){
                String filename = item.getName();
                if (filename == null || filename.length() == 0){
                    System.out.println("没有上传");
                    continue;
                }
                File f = new File("D:\\Project\\Tedu\\jsp\\upload\\" + filename);
                item.write(f);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
