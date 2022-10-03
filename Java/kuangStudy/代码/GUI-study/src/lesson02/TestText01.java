package lesson02;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLOutput;

public class TestText01 {
    public static void main(String[] args) {
        //启动!
        new MyFrame();
    }
}
class MyFrame extends Frame{
    public MyFrame(){
        TextField textField = new TextField();
        add(textField);

        //监听这个文本框输入的文字
        MyActionListener2 actionListener2 = new MyActionListener2();
        //按下回车,就会触发输入框事件
        textField.addActionListener(actionListener2);

        //设置替换编码
        textField.setEchoChar('*');

        pack();
        setVisible(true);
    }
}

class MyActionListener2 implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        TextField filed = (TextField) e.getSource();//获得一些资源,返回的一个对象
        System.out.println(filed.getText());//获取输入框中的文本
        filed.setText("");
    }
}