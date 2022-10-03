package day0407;

import javax.swing.*;

public class MyFrame3 extends JFrame {
    private JPanel jPanel; // 面板
    private JButton jButton1, jButton2; // 按钮

    public MyFrame3() {
        jPanel = new JPanel();
        jButton1 = new JButton("登录");
        jButton2 = new JButton("注册");
        //先把按钮放到面板中
        jPanel.add(jButton1);
        jPanel.add(jButton2);
        //再把面板放到窗口中
        this.add(jPanel);
        this.setTitle("测试面板");
        this.setSize(800, 600);
        this.setLocationRelativeTo(null);
        this.setVisible(true);


        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
