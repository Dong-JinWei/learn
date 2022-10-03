package thread.methods;

public class MethodsTest {
    public static void main(String[] args) {
        System.out.println(Thread.MAX_PRIORITY);
        System.out.println(Thread.MIN_PRIORITY);
        System.out.println(Thread.NORM_PRIORITY);
        System.out.println("===========");

        MyThread t1 = new MyThread();
        MyThread t2 = new MyThread();

        t1.setName("线程1");
        t2.setName("线程2");

        t2.setPriority(10);
        t1.setPriority(1);
        System.out.println(t1.getState());
        System.out.println();


        t1.start();
        t2.start();

        System.out.println(t1.getState());


    }
}

class MyThread extends Thread{
    @Override
    public void run() {
        Thread thread = Thread.currentThread();
        System.out.println(thread.getName());
        System.out.println(thread);
    }
}
