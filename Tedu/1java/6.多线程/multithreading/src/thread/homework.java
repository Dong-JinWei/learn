package thread;

public class homework {
    public static void main(String[] args) {
        Box box = new Box();
        MakeEggCone eggCone = new MakeEggCone(box);
        MakeIceCream iceCream = new MakeIceCream(box);
        Eat eat = new Eat(box);

        eggCone.start();
        iceCream.start();
        eat.start();

    }
}

class Box{
    int eggCone; // 蛋筒
    int iceCream; // 冰淇淋
}

class MakeEggCone extends Thread{
    private Box box;

    MakeEggCone(Box box){
        this.box = box;
    }

    @Override
    public void run() {
        while(true){

            synchronized (box){
                try {
                    sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (box.eggCone == 0){
                    box.eggCone++;
                    System.out.println("生产了一个蛋筒");
                    box.notify();
                }else{
                    System.out.println("已有蛋筒，不能生产");
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

class MakeIceCream extends Thread{
    private Box box;

    MakeIceCream(Box box){
        this.box = box;
    }

    @Override
    public void run() {
        while(true){

            synchronized (box){
                try {
                    sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (box.eggCone == 1 && box.iceCream == 0){
                    box.iceCream++;
                    box.eggCone--;
                    System.out.println("生产了一个冰激凌");
                    box.notify();
                }else if (box.eggCone == 0 || box.iceCream == 1){
                    System.out.println("冰激凌，不能生产");
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

class Eat extends Thread{
    private Box box;

    Eat(Box box){
        this.box = box;
    }

    @Override
    public void run() {
        while(true){

            synchronized (box){
                try {
                    sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (box.iceCream == 1){
                    box.iceCream--;
                    System.out.println("吃了一个冰激凌");
                    box.notify();
                }else{
                    System.out.println("没有冰激凌，不能吃");
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