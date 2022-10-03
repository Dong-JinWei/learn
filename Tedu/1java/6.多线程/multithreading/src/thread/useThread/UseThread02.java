package thread.useThread;

public class UseThread02 {
    public static void main(String[] args) {
        Box box = new Box();
        Producer producer = new Producer(box);
        Consume consume = new Consume(box);

        producer.start();
        consume.start();
    }
}

class Box{
    int cake;
}

class Producer extends Thread{
    Box box;

    Producer(Box box){
        this.box = box;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (box.cake <= 0){
                box.cake++;
                System.out.println("生产了一个蛋糕");
            }
        }

    }
}

class Consume extends Thread{
    Box box;

    Consume(Box box){
        this.box = box;
    }

    @Override
    public void run() {
        while (true){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (box.cake > 0){
                box.cake--;
                System.out.println("消费了一个蛋糕");
            }
        }
    }
}