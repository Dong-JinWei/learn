package day0406;

import javax.swing.*;

public class MyFrame2 extends JFrame {
    private JButton jButton;
    private JButton jButton2;

    public MyFrame2(){
        jButton = new JButton("登录");
        jButton2 = new JButton("注册");
        this.add(jButton);
        this.add(jButton2);
        this.setTitle("测试按钮");
        this.setSize(800, 600);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

    }
}
