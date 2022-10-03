package thread.threadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class 缓存线程池03 {
    public static void main(String[] args) {
        ExecutorService pool = Executors.newCachedThreadPool();

        for (int i = 0; i < 1000; i++) {
            int finalI = i;
            pool.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(finalI + "----");
                }
            });
        }
        pool.shutdown();
    }
}
