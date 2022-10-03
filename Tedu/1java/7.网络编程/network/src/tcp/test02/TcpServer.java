package tcp.test02;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class TcpServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(3000);
        Socket accept = serverSocket.accept();
        OutputStream out = accept.getOutputStream();
        InputStream input = accept.getInputStream();

        Scanner scanner = new Scanner(System.in);

        byte[] bytes = new byte[1024];
        int len;

        while(true){
            len = input.read(bytes);
            System.out.println("服务器接收到了：" + new String(bytes, 0, len));

            System.out.print("服务器说：");
            String next = scanner.next();
            out.write(next.getBytes());
        }

    }
}
