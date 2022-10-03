package tcp.test02;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class TcpClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 3000);
        OutputStream out = socket.getOutputStream();
        InputStream input = socket.getInputStream();
        Scanner scanner = new Scanner(System.in);

        byte[] bytes = new byte[1024];
        int len;

        while(true){
            System.out.print("客户端说：");
            String next = scanner.next();
            out.write(next.getBytes());

            len = input.read(bytes);

            System.out.println("客户端收到：" + new String(bytes, 0, len));
        }

    }
}
