package thread.newThread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NewThread04 {
    public static void main(String[] args) throws InterruptedException {

        ExecutorService pool = Executors.newFixedThreadPool(5);
        pool.execute(new Thread(){
            @Override
            public void run() {
                while(true){
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                System.out.println("=====");
                }
            }
        });
        while (true) {
            Thread.sleep(2000);
            System.out.println("******");
        }
    }
}
