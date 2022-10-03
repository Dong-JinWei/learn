package day0408;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Event1 implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        //通过e.getSource获取事件源（该事件又哪个组件触发的）
        System.out.println(e.getSource());
        System.out.println("按钮被点击了");
    }
}
