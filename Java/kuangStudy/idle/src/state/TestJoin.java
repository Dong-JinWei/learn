package state;

public class TestJoin implements Runnable{

    public void run(){
        for(int i = 0; i<=500; i++)
        System.out.println("vip线程来了"+i++);
    }

    public static void main(String[] args)throws InterruptedException{
        TestJoin testJoin = new TestJoin();
        Thread thread = new Thread(testJoin);
        thread.start();


        for (int i = 0; i < 1000; i++) {
            if (i==200){
                thread.join();
            }
            System.out.println("mian"+i);
        }
    }
}
