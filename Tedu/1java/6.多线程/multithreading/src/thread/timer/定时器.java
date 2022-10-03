package thread.timer;

import java.util.Timer;
import java.util.TimerTask;

public class 定时器 {
    public static void main(String[] args) throws InterruptedException {
        Timer timer = new Timer("定时器");
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("====");
            }
        }, 2000, 1000);

    }
}