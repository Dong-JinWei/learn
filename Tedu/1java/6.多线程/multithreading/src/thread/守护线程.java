package thread;

public class 守护线程 {
    public static void main(String[] args) {
        MyThread01 t1 = new MyThread01();
        MyThread02 t2 = new MyThread02();

        t1.setDaemon(true);
        t1.start();
        t2.start();
        System.out.println("t1守护线程：" + t1.isDaemon());
        System.out.println("t2守护线程：" + t2.isDaemon());
    }
}

class MyThread01 extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("********");
        }
    }
}

class MyThread02 extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 2; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(i + "============");
        }
    }
}

