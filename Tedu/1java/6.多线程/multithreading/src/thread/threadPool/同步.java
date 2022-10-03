package thread.threadPool;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class 同步 {
    public static void main(String[] args) {
        Box box = new Box();
        Lock lock = new ReentrantLock();
        Condition condition = lock.newCondition();

        Produce produce = new Produce(box, lock, condition);
        Consume consume = new Consume(box, lock, condition);

        produce.start();
        consume.start();
    }
}

class Box{
    int cake;
}

class Produce extends Thread{
    private Box box;
    Lock lock;
    Condition condition;

    Produce(Box box, Lock lock, Condition condition){
        this.box = box;
        this.lock = lock;
        this.condition = condition;
    }

    @Override
    public void run() {
        while(true){
            try {
                lock.lock();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (box.cake == 0){
                    box.cake++;
                    System.out.println("蛋糕+1");
                    //唤醒处于等待的线程，解除阻塞，转换为可运行状态
                    condition.signal();
                }else {
                    System.out.println("已有蛋糕");
                    try {
                        //等待---解锁 阻塞
                        condition.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            } finally {
                lock.unlock();
            }
        }
    }
}



class Consume extends Thread{
    private Box box;
    Lock lock;
    Condition condition;

    public Consume(Box box, Lock lock, Condition condition) {
        this.box = box;
        this.lock = lock;
        this.condition = condition;
    }

    @Override
    public void run() {
        while (true){
            try {
                lock.lock();
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (box.cake > 0){
                    box.cake--;
                    System.out.println("蛋糕-1");
                    //唤醒处于等待的线程，解除阻塞，转换为可运行状态
                    condition.signal();
                }else{
                    System.out.println("没有蛋糕");
                    //等待---解锁  阻塞
                    try {
                        condition.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            } finally {
                lock.unlock();
            }
        }

    }
}