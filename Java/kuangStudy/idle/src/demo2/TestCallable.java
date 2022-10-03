package demo2;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.*;

public class TestCallable implements Callable<Boolean>{
    private String url;
    private String name;

    public TestCallable(String url, String name) {
        this.url = url;
        this.name = name;
    }

    public Boolean call() {
        WebDownloader webDownloader = new WebDownloader();
        webDownloader.downloader(url,name);
        System.out.println("下载了文件名为："+name);
        return true;

    }
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        TestCallable t1 = new TestCallable("https://img2020.cnblogs.com/blog/2333782/202104/2333782-20210410165536904-4318293.png","1.jpg");
        TestCallable t2 = new TestCallable("https://img2020.cnblogs.com/blog/2333782/202104/2333782-20210410163350855-2009176698.png","2.jpg");
        TestCallable t3 = new TestCallable("https://img2020.cnblogs.com/blog/2333782/202104/2333782-20210410165249314-996454098.png","3.jpg");

        //1. 创建执行服务：
        ExecutorService ser = Executors.newFixedThreadPool(3);
        //2. 提交执行：
        Future<Boolean> r1 = ser.submit(t1);
        Future<Boolean> r2 = ser.submit(t2);
        Future<Boolean> r3 = ser.submit(t3);
        //3. 获取结果：
        boolean rs1 = r1.get();
        boolean rs2 = r2.get();
        boolean rs3 = r3.get();

        System.out.println(rs1);
        System.out.println(rs2);
        System.out.println(rs3);

        //4. 关闭服务：
        ser.shutdownNow();
    }
}

class WebDownloader{
    public void downloader(String url, String name) {
        try {
            FileUtils.copyURLToFile(new URL(url), new File(name));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("IO异常，downloader方法出现问题");
        }
    }
}