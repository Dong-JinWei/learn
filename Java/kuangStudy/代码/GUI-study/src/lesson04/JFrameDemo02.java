package lesson04;

import javax.swing.*;
import java.awt.*;

public class JFrameDemo02 {
    public static void main(String[] args) {
        new  MyJFrame2().init();
    }
}

class MyJFrame2 extends JFrame {
    public void init(){
        this.setBounds(100,100,500,500);
        this.setVisible(true);

        //设置文字label
        JLabel lable = new JLabel("欢迎来到JAVA");
        this.add(lable);

        //让文本居中
        lable.setHorizontalAlignment(SwingConstants.CENTER);

        Container container = this.getContentPane();
        container.setBackground(Color.BLUE);
    }
}
