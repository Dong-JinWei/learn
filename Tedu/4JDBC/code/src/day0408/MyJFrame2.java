package day0408;

import javax.swing.*;
import java.awt.*;

public class MyJFrame2 extends JFrame {
    private JButton jButton1, jButton2, jButton3, jButton4, jButton5;

    public MyJFrame2() {
        jButton1 = new JButton("东");
        jButton2 = new JButton("南");
        jButton3 = new JButton("西");
        jButton4 = new JButton("北");
        jButton5 = new JButton("中");

        this.add(jButton1, BorderLayout.EAST);
        this.add(jButton2, BorderLayout.SOUTH);
        this.add(jButton3, BorderLayout.WEST);
        this.add(jButton4, BorderLayout.NORTH);
        this.add(jButton5, BorderLayout.CENTER);
        this.setTitle("测试菜单");
        this.setSize(800, 600);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
