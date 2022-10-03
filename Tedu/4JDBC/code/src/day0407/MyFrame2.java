package day0407;

import javax.swing.*;

public class MyFrame2 extends JFrame {
    public MyFrame2(){
        this.setTitle("测试对话框");
        this.setSize(800, 600);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        //通知框
        //第一个参数表示，从哪弹出改对话框
        //第二个参数表示，对话框显示的内容
        //第三个参数表示，对话框的标题
        //第四个参数表示，对话框类型，INFORMATION_MESSAGE 表示通知
        //JOptionPane.showMessageDialog(this, "明天全员核酸", "通知", JOptionPane.INFORMATION_MESSAGE);
        //JOptionPane.showMessageDialog(this, "油漆未干", "通知", JOptionPane.WARNING_MESSAGE);
        JOptionPane.showMessageDialog(this, "用户名或密码错误", "通知", JOptionPane.ERROR_MESSAGE);

        //确认框
        //返回0，是
        //返回1，否
        //返回2，取消
        int i = JOptionPane.showConfirmDialog(this, "是否确认删除");
        System.out.println(i);

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
