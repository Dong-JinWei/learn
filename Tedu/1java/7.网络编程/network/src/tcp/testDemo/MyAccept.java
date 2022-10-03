package tcp.testDemo;

import java.io.IOException;
import java.io.InputStream;

class MyAccept extends Thread {
    InputStream inputStream;

    MyAccept(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    @Override
    public void run() {

        try {
            while (true) {
                byte[] bytes = new byte[1024];
                int len = inputStream.read(bytes);
                System.out.println("收到了：" + new String(bytes, 0, len));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
