package thread.synchronization.买票.runnable;

public class 静态同步方法 {
    public static void main(String[] args) {
        MyRunnable03 r1 = new MyRunnable03();
        MyRunnable03 r2 = new MyRunnable03();

        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);

        t1.start();
        t2.start();
    }
}

class MyRunnable03 implements Runnable {
    private static int ticket = 10;

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            int temp = saleTicket();
            if (temp <= 0){
                break;
            }
        }
    }
    private static synchronized int saleTicket () {
        if (ticket > 0) {
            ticket--;
            System.out.println(Thread.currentThread().getName() + "卖票，剩余" + ticket + "张");
        }

        return ticket;
    }

}