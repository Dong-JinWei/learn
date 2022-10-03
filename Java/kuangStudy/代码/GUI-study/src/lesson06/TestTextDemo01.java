package lesson06;

import javax.swing.*;
import java.awt.*;

public class TestTextDemo01 extends JFrame {
    public TestTextDemo01(){
        Container container = this.getContentPane();

        JTextField textField = new JTextField("world");
        JTextField textField2 = new JTextField("hello",20);

        container.add(textField,BorderLayout.EAST);
        container.add(textField2,BorderLayout.WEST);

        this.setVisible(true);
        this.setSize(400,700);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new TestTextDemo01();
    }
}