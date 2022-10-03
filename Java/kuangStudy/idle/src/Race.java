import sun.awt.windows.ThemeReader;

import static java.lang.Thread.sleep;

public class Race implements Runnable{
    //胜利者
    private static String winner;
    @Override
    public void run() {
        for (int i = 0; i <= 100; i++) {
            //模拟兔子休息
            if (Thread.currentThread().getName().equals("兔子")&&i%55==0) {
                try {
                    sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            //判断比赛是否结束
            boolean flag = gameOver(i);
            if (flag){
                break;
            }
            System.out.println(Thread.currentThread().getName()+"跑了"+i+"米。");
        }
    }
    private boolean gameOver(int steps) {
        if (winner!=null){
            return true;
        }else{
            if (steps>=100){
                winner = Thread.currentThread().getName();
                System.out.println("胜者是"+winner);
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Race race = new Race();

        new Thread(race,"兔子").start();
        new Thread(race,"乌龟").start();
    }
}
