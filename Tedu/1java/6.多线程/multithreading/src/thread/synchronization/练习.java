package thread.synchronization;

/**
 * 要求：子线程运行执行 10 次后，主线程再运行 5 次。这样交替执行三遍
 */
public class 练习 {
    public static void main(String[] args) {
        MyRunnable myRunnable = new MyRunnable();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 3; i++) {
                    myRunnable.sunMethod();
                }
            }
        }).start();

        for (int i = 0; i < 3; i++) {
            myRunnable.mainMethod();
        }
    }
}

class MyRunnable{
    private boolean subFlag = true;

    public synchronized void mainMethod() {
        Thread.currentThread().setName("主方法");
        while (subFlag) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + i);
        }
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        subFlag = true;
        notify();
    }

    public synchronized void sunMethod() {
        Thread.currentThread().setName("子方法");
        while (!subFlag) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + i);
        }
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        subFlag = false;
        notify();

    }
}