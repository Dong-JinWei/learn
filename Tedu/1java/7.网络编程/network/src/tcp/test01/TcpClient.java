package tcp.test01;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class TcpClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 3000);
        System.out.println(socket.getInetAddress() + "::" + socket.getPort());
        System.out.println(socket.getLocalAddress() + "::" + socket.getLocalPort());

        OutputStream out = socket.getOutputStream();

        out.write("Hello World!".getBytes());

        out.close();
        socket.close();
    }
}
