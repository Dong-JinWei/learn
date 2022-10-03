package lesson03;

import java.awt.*;

public class TestPaint {
    public static void main(String[] args) {
        new MyPaint().loadFrame();
    }
}

class MyPaint extends Frame{

    public void loadFrame(){
        setVisible(true);
        setBounds(200,200,600,600);
    }
    public void paint(Graphics g){
        //画笔，需要有颜色，可以画画
        g.setColor(Color.red);
        g.fillOval(200,200,100,100);//实心

        g.setColor(Color.gray);
        g.drawRect(100,100,100,100);//空心

        //养成习惯，用完画笔，将他还原到最初的颜色
    }
}