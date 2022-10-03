package thread.threadPool;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class 固定周期线程池04 {
    public static void main(String[] args) {
        ScheduledExecutorService pool = Executors.newScheduledThreadPool(5);

        pool.scheduleWithFixedDelay(new Runnable() {
            @Override
            public void run() {
                System.out.println("====");
            }
        }, 2000, 1000, TimeUnit.MILLISECONDS);

    }
}
