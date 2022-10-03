package tcp.testDemo;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Scanner;

class MySend extends Thread {

    OutputStream out;

    MySend(OutputStream out) {
        this.out = out;
    }

    @Override
    public void run() {

        try {
            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.println("输入发送的内容：");
                out.write(scanner.nextLine().getBytes());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
