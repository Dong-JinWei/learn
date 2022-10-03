package gaoji;

import java.util.concurrent.locks.ReentrantLock;

public class TestLock {
    public static void main(String[] args) {
        TestLock2 testLock2 = new TestLock2();

        new Thread(testLock2, "p1").start();
        new Thread(testLock2, "p2").start();
        new Thread(testLock2, "p3").start();
    }
}

class TestLock2 implements Runnable {
    int ticketNums = 10;

    private final ReentrantLock lock = new ReentrantLock();

    public void run() {
        while (true) {
            try {
                lock.lock();
                if (ticketNums > 0) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "=" + ticketNums--);
                } else{
                break;
            }
        } finally{
            lock.unlock();
        }
    }
    }
}
