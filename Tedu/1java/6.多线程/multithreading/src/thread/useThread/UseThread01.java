package thread.useThread;

public class UseThread01 {
    public static void main(String[] args) {
        Ticket ticket = new Ticket();
        Thread thread1 = new Thread(ticket);
        Thread thread2 = new Thread(ticket);

        thread1.start();
        thread2.start();

    }
}

class Ticket implements Runnable{
    int ticket = 10;

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (ticket > 0){
                ticket--;
                System.out.printf("出售一张票，剩余%d张\n", ticket);
            }else{
                break;
            }
        }
    }
}