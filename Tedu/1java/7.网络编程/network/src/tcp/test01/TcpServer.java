package tcp.test01;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(3000);

        System.out.println(serverSocket.getLocalPort() + "::" + serverSocket.getInetAddress());
        System.out.println("准备接受请求");
        Socket accept = serverSocket.accept();
        System.out.println(accept.getInetAddress() + "::" + accept.getPort());
        System.out.println("建立了连接请求");

        InputStream inputStream = accept.getInputStream();

        byte[] bytes = new byte[1024];

        int read = inputStream.read(bytes);

        System.out.println(new String(bytes, 0, read));

        inputStream.close();
        accept.close();
        serverSocket.close();

    }
}
