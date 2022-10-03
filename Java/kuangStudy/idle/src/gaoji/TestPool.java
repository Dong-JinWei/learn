package gaoji;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//测试线程池
public class TestPool {
    public static void main(String[] args) {
       ExecutorService service = Executors.newFixedThreadPool(10);

       service.execute(new MyThread());
       service.execute(new MyThread());
       service.execute(new MyThread());
       service.execute(new MyThread());

       service.shutdown();
    }


}

class MyThread implements Runnable{
    public void run(){
        System.out.println(Thread.currentThread().getName());
    }
}