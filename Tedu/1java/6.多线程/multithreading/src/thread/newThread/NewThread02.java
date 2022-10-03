package thread.newThread;

public class NewThread02 {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new MyRunnable());
        thread.start();
        while (true){
            Thread.sleep(1000);
            System.out.println("=====");
        }
    }

}

class MyRunnable implements Runnable{

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("******");
        }
    }
}