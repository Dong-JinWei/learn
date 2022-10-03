package thread.threadPool;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class VolatileTest {
    public static volatile int inc=0;
    static Lock lock = new ReentrantLock();
    public static void main(String[] args) {
        for (int i=0; i<10; i++){
            (new Thread(){
                @Override
                public void run() {
                    for (int j=0; j<100; j++){
                        try {
                            Thread.sleep(10);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        lock.lock();
                        VolatileTest.inc = VolatileTest.inc + 1;
                        lock.unlock();
                    }
                }
            }).start();
        }

        //保证创建的线程全部执行结束
        while (true) {
            int num = Thread.activeCount();
            //System.out.println(num);
            if (num > 2)
                Thread.yield();
            else
                break;
        }
        System.out.println(VolatileTest.inc);
    }
}
