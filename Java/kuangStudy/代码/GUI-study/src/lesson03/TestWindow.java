package lesson03;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import static com.sun.glass.ui.Cursor.setVisible;

public class TestWindow {
    public static void main(String[] args) {
        new WindowFrame();
    }
}

class WindowFrame extends Frame {
    public WindowFrame() {
            setBackground(Color.blue);
            setBounds(100,100,200,300);
            setVisible(true);
            //addWindowListener(new MyWindowListener());

            this.addWindowListener(
                    //匿名内部类
                    new WindowAdapter() {
                        public void windowOpened(WindowEvent e){
                            System.out.println("windowOpened");
                        }
                        //关闭窗口
                        public void windowClosing(WindowEvent e){
                            System.out.println("windowClosing");
                            System.exit(0);
                        }
                        public void windowClosed(WindowEvent e){
                            System.out.println("windowClosed");
                        }
                        //激活窗户
                        public void windowActivated(WindowEvent e){
                            WindowFrame source =(WindowFrame) e.getSource();
                            source.setTitle("被激活了");
                            System.out.println("windowActivated");
                        }
                    }
            );
        }
}