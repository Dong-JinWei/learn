package day0408;

import javax.swing.*;
import java.awt.*;

public class MyJFrame3 extends JFrame {
    private JPanel jPanel;
    private JButton jButton1, jButton2, jButton3, jButton4, jButton5;

    public MyJFrame3() {
        jPanel = new JPanel();
        jButton1 = new JButton("东");
        jButton2 = new JButton("南");
        jButton3 = new JButton("西");
        jButton4 = new JButton("北");
        jButton5 = new JButton("中");

        jPanel.add(jButton1);
        jPanel.add(jButton2);
        jPanel.add(jButton3);
        jPanel.add(jButton4);
        jPanel.add(jButton5);
        this.add(jPanel);
        this.setTitle("测试菜单");
        this.setSize(800, 600);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
