package thread.useThread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class UseThread03 {
    public static void main(String[] args) {
        Box box = new Box();
        Producer producer = new Producer(box);
        Consume consume = new Consume(box);

        ExecutorService pool = Executors.newFixedThreadPool(5);
        pool.execute(producer);
        pool.execute(consume);
        pool.shutdown();
    }
}