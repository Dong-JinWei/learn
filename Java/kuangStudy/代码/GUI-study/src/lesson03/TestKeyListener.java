package lesson03;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.FileReader;

//键
public class TestKeyListener {
    public static void main(String[] args) {
        new KeyFrame();

    }
}

class KeyFrame extends Frame {
    public KeyFrame(){
        setBounds(1,2,300,400);
        setVisible(true);

        this.addKeyListener(new KeyAdapter() {
            //键盘按下
            @Override
            public void keyPressed(KeyEvent e) {
                //获得键盘下的一个键是哪一个,当前的码
                int keyCode = e.getKeyCode();
                System.out.println(keyCode);
                if (keyCode == KeyEvent.VK_UP){
                    System.out.println("你按下了上键");
                }
                //根据按下不同操作,产生不同结果
            }
        });
    }
}