package lesson04;

import javax.swing.*;
import java.awt.*;

public class JFrameDemo {

    //init();初始化
    public void init(){
        JFrame jf = new JFrame("这是一个JFrame窗口");
        jf.setVisible(true);
        jf.setBounds(200,200,200,200);
        jf.setBackground(Color.GRAY);
        
        //设置文字label
        JLabel lable = new JLabel("欢迎来到JAVA");
        jf.add(lable);

        //容器实例化



        //关闭事件
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
    }

    public static void main(String[] args) {
        new JFrameDemo().init();

    }//建立一个窗口

}
