package syn;

//不安全的买票
public class UnsafeBuyTicket {
    public static void main(String[] args) {
        BuyTicket station = new BuyTicket();

        new Thread(station,"p1").start();
        new Thread(station,"p2").start();
        new Thread(station,"p3").start();
    }

}

class BuyTicket implements Runnable{

    private int ticketNums = 10;
    boolean flag = true;

    public void run(){
        while (flag){
            try {
                buy();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    private synchronized void buy() throws InterruptedException {
        if (ticketNums <= 0){
            flag = false;
            return;
        }
        Thread.sleep(100);
        System.out.println(Thread.currentThread().getName()+"拿到了"+ticketNums--);
    }
}