package state;

//测试守护线程
public class TestDaemon {
    public static void main(String[] args) {
        God god = new God();
        You you = new You();

        Thread thread = new Thread(god);
        thread.setDaemon(true);

        thread.start();

        new Thread(you).start();

    }

}

//上帝
class God implements Runnable{
    public void run(){
        while (true){
            System.out.println("上帝在看着你");
        }
    }
}

//你
class You implements Runnable{
    public void run(){
        for (int i = 0; i < 36500; i++) {
            System.out.println("你开心的活着");
        }
        System.out.println("==========goodbye world================");

    }

}
