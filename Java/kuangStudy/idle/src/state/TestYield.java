package state;

public class TestYield {
    public static void main(String[] args){
        MyYield myYield = new MyYield();

        new Thread(myYield,"a").start();
        new Thread(myYield,"b").start();
    }

}


class MyYield implements Runnable{
    public void run(){
        System.out.println(Thread.currentThread().getName()+"线程开始运行");
        Thread.yield();
        System.out.println(Thread.currentThread().getName()+"线程停止执行");
        }
    }

