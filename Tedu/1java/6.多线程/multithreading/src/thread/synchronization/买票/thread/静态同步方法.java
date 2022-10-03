package thread.synchronization.买票.thread;

/**
 * 继承Thread类，实现买票操作
 */
public class 静态同步方法 {
    public static void main(String[] args) {
        Thread t1 = new MyThread();
        Thread t2 = new MyThread();

        t1.start();
        t2.start();
    }
}

class MyThread extends Thread{
    private static int ticket = 10;
    @Override
    public void run() {
        while(true){
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            int temp = saleTicket();
            if (temp <= 0){
                break;
            }
        }
    }

    private static synchronized int saleTicket(){
        if (ticket > 0){
            ticket--;
            System.out.println(Thread.currentThread().getName() + "卖票，剩余" + ticket + "张");
        }
        return ticket;
    }
}