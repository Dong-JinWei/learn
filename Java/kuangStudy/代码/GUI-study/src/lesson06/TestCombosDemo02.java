package lesson06;

import javax.swing.*;
import java.awt.*;
import java.util.Vector;

public class TestCombosDemo02 extends JFrame {
    public TestCombosDemo02(){
        Container container = this.getContentPane();

        //生成列表的内容
//        String[] contents = {"1","2","3"};
        Vector vectot = new Vector();

        //列表中需要放内容
        JList jList1 = new JList(vectot);

        vectot.add("JOJO");
        vectot.add("Dio");

        container.add(jList1);

        this.setVisible(true);
        this.setSize(400,700);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }

    public static void main(String[] args) {
        new TestCombosDemo02();
    }
}
