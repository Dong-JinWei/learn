package thread.newThread;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.util.Timer;
import java.util.TimerTask;

public class NewThread05 {
    public static void main(String[] args) throws InterruptedException {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run(){
                while (true) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("******");
                }
            }
        }, 2000);

        while (true) {
            Thread.sleep(1000);
            System.out.println("=========");
        }
    }

}