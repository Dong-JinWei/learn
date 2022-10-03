package thread.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

class MyLock{
    public static final ReentrantLock lock = new ReentrantLock();
}
class MyThread01 extends Thread{
    @Override
    public void run() {
        MyLock.lock.lock();
        System.out.println("线程一上锁了");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        MyLock.lock.unlock();
        System.out.println("线程一解锁了");
    }
}
class MyThread02 extends Thread{
    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        boolean ok;
        try {
            ok = MyLock.lock.tryLock(1000, TimeUnit.MILLISECONDS);
            if (ok) {
                System.out.println("线程二上锁了");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                MyLock.lock.unlock();
                System.out.println("线程二解锁了");
            }else{
                System.out.println("线程二没有拿到锁");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
public class LockTest02 {
    public static void main(String[] args) {
        MyThread01 th01 = new MyThread01();
        MyThread02 th02 = new MyThread02();
        th01.start();
        th02.start();
    }
}


