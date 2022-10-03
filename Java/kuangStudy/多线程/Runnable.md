# Runnable接口

```java
//创建线程方式2：实现runnable接口，重写run方法，执行线程需要丢入runnable接口实现类，调用tart方法。
public class TestThread3 implements Runnable{
    public void run(){
        //run方法线程体
        for(int i = 0; i < 200; i++){
            System.out.println("我在看代码--"+i);
        }
    }
    public static void main(String[] args) {
        //创建Runnbale接口实现类对象
        TestThread3 testThread3 = new TestThread3();
        //创建线程对象，通过线程对象来开启我们的线程，代理
        new Thread(testThread3).start();

        for (int i = 0; i < 1000; i++) {
            System.out.println("我在学习多线程--"+i);
        }
    }
}

```

- 继承Thread类
  - 子类继承Thread类具备多线程能力
  - 启动线程：子类对象.start()
  - 不建议使用，避免OOP单继承局限性
- 实现`Runnalbe`接口
  - 实现接口Runnable具有多线程能力
  - 启动多线程：传入目标对象+Thread对象.start()
  - 推荐使用：避免单继承局限性，灵活方便，方便同一个对象被多个线程使用。