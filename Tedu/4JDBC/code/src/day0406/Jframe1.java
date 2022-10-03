package day0406;

import javax.swing.*;

public class Jframe1 {
    public static void main(String[] args) {
        //创建窗体对象
        JFrame frame = new JFrame();
        //设置标题
        frame.setTitle("第一个窗体");
        //设置大小
        frame.setSize(800, 600);
        //设置窗体位置
        frame.setLocationRelativeTo(null);
        //窗体默认是隐藏的
        frame.setVisible(true);
        //关闭时能退出，默认关闭时隐藏，程序并没有结束
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    }
}
