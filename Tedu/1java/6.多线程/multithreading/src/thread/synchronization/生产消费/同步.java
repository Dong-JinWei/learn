package thread.synchronization.生产消费;

public class 同步 {
    public static void main(String[] args) {
        Box box = new Box();
        Produce produce = new Produce(box);
        Consume consume = new Consume(box);

        produce.start();
        consume.start();
    }
}

class Box{
    int cake;
}

class Produce extends Thread{
    private Box box;
    Produce(Box box){
        this.box = box;
    }

    @Override
    public void run() {
        while (true){

            synchronized (box){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (box.cake <= 0){
                    box.cake++;
                    System.out.println("蛋糕+1");
                    box.notify();
                }else{
                    System.out.println("不能生产蛋糕");
                    try {
                        box.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

        }
    }
}

class Consume extends Thread{
    private Box box;
    Consume(Box box){
        this.box = box;
    }

    @Override
    public void run() {
        while(true){

            synchronized (box){
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (box.cake > 0){
                    box.cake--;
                    System.out.println("蛋糕-1");
                    box.notify();
                }else{
                    System.out.println("不能吃蛋糕");
                    try {
                        box.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

        }
    }
}

