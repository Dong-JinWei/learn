package thread.lock;

import java.util.concurrent.locks.ReentrantLock;

public class LockTest01 {
    public static void main(String[] args) {
        MyRunnable myRunnable = new MyRunnable();
        Thread t1 = new Thread(myRunnable);
        Thread t2 = new Thread(myRunnable);

        t1.start();
        t2.start();
    }

}

class MyRunnable implements Runnable{
    private int ticket = 10;
    private ReentrantLock lock = new ReentrantLock();
    @Override
    public void run() {
        while(true){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            try {
                lock.lock();
                if (ticket > 0){
                    ticket--;
                    System.out.println(Thread.currentThread().getName() + "卖票" + "剩余" + ticket + "张");
                } else{
                    break;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        }
    }
}
