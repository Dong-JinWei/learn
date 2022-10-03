package tcp.testDemo;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {

        ServerSocket socket = new ServerSocket(4000);
        Socket accept = socket.accept();
        OutputStream out = accept.getOutputStream();
        InputStream inputStream = accept.getInputStream();

        MyAccept myAccept = new MyAccept(inputStream);
        MySend mySend = new MySend(out);

        mySend.start();
        myAccept.start();
    }
}


