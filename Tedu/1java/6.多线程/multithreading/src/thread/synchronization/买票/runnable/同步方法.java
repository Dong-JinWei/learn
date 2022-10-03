package thread.synchronization.买票.runnable;

public class 同步方法 {
    public static void main(String[] args) {
        MyRunnable02 myRunnable = new MyRunnable02();
        Thread t1 = new Thread(myRunnable);
        Thread t2 = new Thread(myRunnable);

        t1.start();
        t2.start();
    }
}

class MyRunnable02 implements Runnable{
    private int ticket = 10;

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

    private synchronized int saleTicket() {
        if (ticket > 0) {
            ticket--;
            System.out.println(Thread.currentThread().getName() + "卖票，剩余" + ticket + "张");
        }
        return ticket;
    }
}