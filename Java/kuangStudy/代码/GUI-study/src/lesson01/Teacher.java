package lesson01;

import javafx.scene.layout.Border;
import javafx.scene.layout.Pane;

import java.awt.*;

public class Teacher {
    public static void main(String[] args) {
        Frame frame = new Frame();

        Panel p1 = new Panel(new BorderLayout());
        Panel p2 = new Panel(new GridLayout(2,1));
        Panel p3 = new Panel(new BorderLayout());
        Panel p4 = new Panel(new GridLayout(2,2));


        frame.setVisible(true);
        frame.setSize(400,300);
        frame.setLayout(new GridLayout(2,1));

        p1.add(new Button("1"),BorderLayout.EAST);
        p1.add(new Button("2"),BorderLayout.WEST);
        p2.add(new Button("3"));
        p2.add(new Button("4"));
        p1.add(p2,BorderLayout.CENTER);

        p3.add(new Button("5"),BorderLayout.EAST);
        p3.add(new Button("6"),BorderLayout.WEST);
        for (int i = 7; i < 11; i++) {
            p4.add(new Button(""+i));
        }
        p3.add(p4,BorderLayout.CENTER);

        frame.add(p1);
        frame.add(p3);
    }
}
