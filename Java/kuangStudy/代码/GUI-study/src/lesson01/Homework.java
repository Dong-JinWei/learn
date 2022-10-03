package lesson01;

import javax.swing.border.Border;
import java.awt.*;

public class Homework {
    public static void main(String[] args) {
        Frame frame = new Frame();
        Panel panel1 = new Panel();
        Panel panel2 = new Panel();
        Panel panel3 = new Panel();
        Panel panel4 = new Panel();

        frame.setLayout(null);



        Button button1 = new Button("Button1");
        Button button2 = new Button("Button2");
        Button button3 = new Button("Button3");
        Button button4 = new Button("Button4");
        Button button5 = new Button("Button5");
        Button button6 = new Button("Button6");
        Button button7 = new Button("Button7");
        Button button8 = new Button("Button8");
        Button button9 = new Button("Button9");
        Button button10 = new Button("Button10");

        frame.setVisible(true);
        frame.setSize(600,400);

        //左边两个
        panel1.setBounds(1,1,100,400);
        frame.add(panel1);
        panel1.setLayout(new GridLayout(2,1));
        panel1.add(button1);
        panel1.add(button2);

        //中上两个
        panel2.setBounds(101,1,400,200);
        frame.add(panel2);
        panel2.setLayout(new GridLayout(2,1));
        panel2.add(button3);
        panel2.add(button4);

        //中下四个
        panel3.setBounds(102,202,400,200);
        frame.add(panel3);
        panel3.setLayout(new GridLayout(2,2));
        panel3.add(button5);
        panel3.add(button6);
        panel3.add(button7);
        panel3.add(button8);

        //左边两个
        panel4.setBounds(503,1,101,400);
        frame.add(panel4);
        panel4.setBackground(Color.orange);
        panel4.setLayout(new GridLayout(2,1));
        panel4.add(button9);
        panel4.add(button10);




    }
}
