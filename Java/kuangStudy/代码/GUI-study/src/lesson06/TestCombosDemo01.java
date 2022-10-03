package lesson06;

import javax.swing.*;
import java.awt.*;

public class TestCombosDemo01 extends JFrame {
    public TestCombosDemo01(){
        Container container = this.getContentPane();

        JComboBox status = new JComboBox();

        status.addItem(null);
        status.addItem("ing");
        status.addItem("finish");
        status.addItem("ed");

        container.add(status);


        this.setVisible(true);
        this.setSize(600,700);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }

    public static void main(String[] args) {
        new TestCombosDemo01();

    }
}
