package lesson01;

import java.awt.*;

//GUI的第一个界面
public class TeatFrame {
    public static void main(String[] args) {
        //Fame
        Frame frame = new Frame("我的第一个Java窗口");
        //需要设置可见性
        frame.setVisible(true);

        //设置窗口大小
        frame.setSize(400,400);

        //设置颜色
        frame.setBackground(new Color(213, 115, 115));

        //弹出初始位置
        frame.setLocation(200,200);

        //设置大小固定
        frame.setResizable(false);
    }
}
