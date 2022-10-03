package lesson02;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TeatActionEvent {
    public static void main(String[] args) {
        //按下按钮，触发事件
        Frame frame = new Frame();
        Button button = new Button();

        //因为,addActionListener()需要一个ActionListener,所以我们要构造一个 ActionListener
        MyActionListener myActionListener = new MyActionListener();
        button.addActionListener(myActionListener);

        frame.add(button,BorderLayout.CENTER);
        frame.pack();
        frame.setVisible(true);

        windowClose(frame); //关闭窗口
    }

    //关闭窗体的事件
    private static void windowClose(Frame frame){
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
}

class MyActionListener implements ActionListener{
    public void actionPerformed(ActionEvent e){
        System.out.println("AAA");
    }
}
