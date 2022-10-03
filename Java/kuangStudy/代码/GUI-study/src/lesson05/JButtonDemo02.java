package lesson05;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class JButtonDemo02 extends JFrame {

    public JButtonDemo02(){
        Container container = this.getContentPane();
        URL resource = JButtonDemo01.class.getResource("tx.png");
        Icon icon = new ImageIcon(resource);

        //单选框
        JRadioButton radioButton1 = new JRadioButton("JRadioButton01");
        JRadioButton radioButton2 = new JRadioButton("JRadioButton02");
        JRadioButton radioButton3 = new JRadioButton("JRadioButton03");

        //由于单选框只能选一个，分组,一个组只能选择一个
        ButtonGroup group = new ButtonGroup();
        group.add(radioButton1);
        group.add(radioButton2);
        group.add(radioButton3);

        container.add(radioButton1,BorderLayout.CENTER);
        container.add(radioButton2,BorderLayout.NORTH);
        container.add(radioButton3,BorderLayout.SOUTH);

        this.setVisible(true);
        this.setSize(300,400);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
    public static void main(String[] args) {
        new JButtonDemo02();
    }
}
