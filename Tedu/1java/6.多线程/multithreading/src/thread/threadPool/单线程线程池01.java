package thread.threadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class 单线程线程池01 {
    public static void main(String[] args) {
        ExecutorService pool = Executors.newSingleThreadExecutor();
        pool.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("1111");
            }
        });
        pool.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("222");
            }
        });
        pool.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("333");
            }
        });
        pool.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("444");
            }
        });
        pool.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("555");
            }
        });
    }
}
