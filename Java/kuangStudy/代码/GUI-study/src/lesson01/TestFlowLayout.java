package lesson01;

import java.awt.*;

public class TestFlowLayout {
    public static void main(String[] args) {
        Frame frame = new Frame();

        //组件-按钮
        Button button1 = new Button("button1");
        Button button2 = new Button("button2");
        Button button3 = new Button("button3");

        //设置为流式布局
        //frame.setLayout(new FlowLayout());  //按钮居中
        //frame.setLayout(new FlowLayout(FlowLayout.LEFT));  //按钮靠左
        frame.setLayout(new FlowLayout(FlowLayout.RIGHT));   //按钮靠右

        frame.setVisible(true);
        frame.setSize(200,200);

        //添加按钮
        frame.add(button1);
        frame.add(button2);
        frame.add(button3);
    }
}
