package lesson04;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

public class UrlDown {
    public static void main(String[] args) throws Exception{
        //1.下载地址
        URL url = new URL("http://localhost:8080/dowei/Dio.txt");

        //2. 连接到这个资源 HTTP
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();

        InputStream inputStream = urlConnection.getInputStream();

        FileOutputStream fos = new FileOutputStream("Dio.txt");

        byte[] buffer = new byte[1024];
        int len;
        while ((len=inputStream.read(buffer))!=-1){
            fos.write(buffer,0,len);
        }
        fos.close();
        inputStream.close();
        urlConnection.disconnect();//断开连接
    }
}
