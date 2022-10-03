import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class TestThread2 extends Thread{
    private String url;
    private String name;

    public TestThread2(String url, String name) {
        this.url = url;
        this.name = name;
    }

    public void run() {
        WebDownloader webDownloader = new WebDownloader();
        webDownloader.downloader(url,name);
        System.out.println("下载了文件名为："+name);

    }
    public static void main(String[] args) {
        TestThread2 t1 = new TestThread2("https://img2020.cnblogs.com/blog/2333782/202104/2333782-20210410165536904-4318293.png","1.jpg");
        TestThread2 t2 = new TestThread2("https://img2020.cnblogs.com/blog/2333782/202104/2333782-20210410163350855-2009176698.png","2.jpg");
        TestThread2 t3 = new TestThread2("https://img2020.cnblogs.com/blog/2333782/202104/2333782-20210410165249314-996454098.png","3.jpg");

        t1.start();
        t2.start();
        t3.start();
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