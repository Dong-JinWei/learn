package thread;

import sun.plugin2.message.BestJREAvailableMessage;

import java.awt.*;
import java.rmi.MarshalException;

public class DeadLock {
    public static void main(String[] args) {
        Makeup g1 = new Makeup(0, "Dio");
        Makeup g2 = new Makeup(1, "JOJO");

        g1.start();
        g2.start();

    }
}

//口红
class Lipstick{

}

//镜子
class Mirror{

}

class Makeup extends Thread{

    static Lipstick lipstick = new Lipstick();
    static Mirror mirror = new Mirror();

    int choice;
    String girName;

    Makeup(int choice, String girName){
        this.choice = choice;
        this.girName = girName;
    }
    @Override
    public void run() {

        try {
            makeup();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
    private void makeup() throws InterruptedException {
        if (choice == 0){
            synchronized (lipstick){
                System.out.println(this.girName+"获得口红");
                Thread.sleep(1000);

            }
            synchronized (mirror){
                System.out.println(this.girName+"获得镜子");
            }
        }else {
            synchronized (mirror){
                System.out.println(this.girName+"获得镜子");
                Thread.sleep(2000);
            }
            synchronized (lipstick){
                System.out.println(this.girName+"获得口红");
            }
        }

    }
}