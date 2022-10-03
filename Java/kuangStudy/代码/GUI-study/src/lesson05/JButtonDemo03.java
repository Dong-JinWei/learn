package lesson05;

import javax.swing.*;
import java.awt.*;
import java.lang.String;

public class JButtonDemo03 extends JFrame {

    public JButtonDemo03(){

        Container container = this.getContentPane();

        JCheckBox jCheckBox1 = new JCheckBox("1");
        JCheckBox jCheckBox2 = new JCheckBox("2");

        container.add(jCheckBox1,BorderLayout.SOUTH);
        container.add(jCheckBox2,BorderLayout.NORTH);

        this.setVisible(true);
        this.setBounds(100,100,400,400);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new JButtonDemo03();
    }
}
