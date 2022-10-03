package thread.newThread;

public class NewThread01 {
    public static void main(String[] args) throws InterruptedException {
        MyThread myThread = new MyThread();

        myThread.start();
        while(true){
            Thread.sleep(1000);
            System.out.println("============= ");
        }



    }
}

class MyThread extends Thread{

    @Override
    public void run() {
       while(true){
           try {
               Thread.sleep(1000);
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
           System.out.println("******** ");
        }

    }
}
