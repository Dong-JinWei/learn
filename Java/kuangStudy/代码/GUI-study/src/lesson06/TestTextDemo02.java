package lesson06;

import javax.swing.*;
import java.awt.*;

public class TestTextDemo02 extends JFrame{
    public TestTextDemo02(){
        Container container = this.getContentPane();

        JPasswordField passwordField = new JPasswordField();
        passwordField.setEchoChar('x');

        container.add(passwordField);

        this.setVisible(true);
        this.setSize(400,700);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new TestTextDemo02();
    }
}