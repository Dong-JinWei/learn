package day0408;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyJFrame4 extends JFrame {
    private JPanel jPanel;
    private JButton jButton1, jButton2, jButton3, jButton4, jButton5, jButton6;

    public MyJFrame4() {
        jPanel = new JPanel();
        //可以通过setLayout设置布局
        //GridLayout表格布局，然后指定rows（行数），cols（列数）
        jPanel.setLayout(new GridLayout(3, 2));
        //给jButton1添加事件
        jButton1 = new JButton("东");
        jButton2 = new JButton("南");
        jButton3 = new JButton("西");
        jButton4 = new JButton("北");
        jButton5 = new JButton("中");
        jButton6 = new JButton("发");

        //添加点击事件
        jButton1.addActionListener(new Event1());
        jButton2.addActionListener(new Event1());
        jButton3.addActionListener(new Event1());
        jButton4.addActionListener(new Event1());
        jButton5.addActionListener(new Event1());
        jButton6.addActionListener(new Event1());

        jPanel.add(jButton1);
        jPanel.add(jButton2);
        jPanel.add(jButton3);
        jPanel.add(jButton4);
        jPanel.add(jButton5);
        jPanel.add(jButton6);
        this.add(jPanel);

        this.setTitle("测试菜单");
        this.setSize(800, 600);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

}
