package thread.newThread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class NewThread03 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<String> task = new FutureTask<>(new MyCall());
        Thread thread = new Thread(task);
        thread.start();
        System.out.println(task.get());
        System.out.println("======");
    }

}

class MyCall implements Callable<String>{
    @Override
    public String call() throws Exception {
        System.out.println("***** ");
        Thread.sleep(5000);
        return "hello world!";
    }
}
