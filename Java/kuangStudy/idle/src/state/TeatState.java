package state;

//观察测试线程的状态
public class TeatState {
    public static void main(String[] args) throws InterruptedException{
        Thread thread = new Thread(()->{
            for (int i = 0; i < 5; i++) {
                try {
                    Thread.sleep(1000);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
            System.out.println("/////////");
        });

        //观察测试线程的状态
        Thread.State state = thread.getState();
        System.out.println(state); //NEW

        //Run
        thread.start();
        state = thread.getState();
        System.out.println(state);

        while(state != Thread.State.TERMINATED){
            Thread.sleep(100);
            state = thread.getState();
            System.out.println(state);
        }

    }
}
