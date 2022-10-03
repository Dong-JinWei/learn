package tcp.file;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 图片文件接收-服务器端
 * @author 陈浩翔
 *
 * 2016-5-10
 */
public class UploadPicServer {

    public static void main(String[] args) {

        try {
            ServerSocket server = new ServerSocket(10007);
            while(true){
                Socket s = server.accept();//阻塞方法
                //只负责和客户端进行握手
                new Thread(new  UploadThread(s) ).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class UploadThread implements Runnable{
    private Socket s;
    public UploadThread(Socket s) {
        this.s = s;
    }

    @Override
    public void run() {

        String ip = s.getInetAddress().getHostAddress();
        System.out.println(ip+"...发来图片");

        try {
            BufferedInputStream bin = new BufferedInputStream(s.getInputStream());

            File dir = new File("g:\\mypic");

            if(!dir.exists()){
                dir.mkdir();//文件夹不存在,创建mypic文件夹
            }

            int count=1;
            //我觉得这里的后缀名，需要通过发送方也发过来的
            File file = new File(dir, ip+".jpg");

            while(file.exists()){
                file = new File(dir,ip+"("+(count++) +")"+".jpg"); //带号的文件名
            }

            FileOutputStream fout = new FileOutputStream(file);

            //从socket流中读取数据，存储到本地文件。相当于对拷
            byte buf[] = new byte[1024];
            int len=0;
            while( (len=bin.read(buf))!=-1){
                fout.write(buf, 0, len);
            }
            //图片接收完毕

            //向客户端发送回馈信息
            OutputStream out = s.getOutputStream();
            out.write( "上传成功".getBytes() );

            fout.close();
            s.close();

        } catch (IOException e) {
            e.printStackTrace();
        }



    }
}