package snake;

import javax.swing.*;

//游戏的主启动类
public class StartGame {
    public static void main(String[] args) {
        JFrame frame = new JFrame();

        frame.setBounds(10,10,900,720);
        frame.setResizable(false);//不可改变大小
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


        //正常游戏界面都应该在面上
        frame.add(new GamePanel());

        frame.setVisible(true);
    }
}
