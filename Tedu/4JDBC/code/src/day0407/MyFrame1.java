package day0407;

import javax.swing.*;

public class MyFrame1 extends JFrame {
    private JDialog jDialog;
    public MyFrame1(){
        //创建对话框对象
        jDialog = new JDialog();
        //设置标题
        jDialog.setTitle("对话框1");
        jDialog.setSize(400, 300);
        jDialog.setLocationRelativeTo(null);

        //模态对话框：弹出对话框时，窗体无法输入，可以保护窗体的数据
        jDialog.setModal(true);

        this.setTitle("测试对话框");
        this.setSize(800, 600);
        this.setLocationRelativeTo(null);

        //先显示窗体，然后显示对话框
        this.setVisible(true);
        jDialog.setVisible(true);

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
