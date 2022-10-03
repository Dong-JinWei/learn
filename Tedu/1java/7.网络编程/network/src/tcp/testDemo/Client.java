package tcp.testDemo;


import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {

        Socket socket = new Socket("127.0.0.1", 4000);
        OutputStream out = socket.getOutputStream();
        InputStream inputStream = socket.getInputStream();

        MyAccept myAccept = new MyAccept(inputStream);
        MySend mySend = new MySend(out);

        myAccept.start();
        mySend.start();
    }
}

