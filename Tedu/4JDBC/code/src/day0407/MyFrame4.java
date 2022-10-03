package day0407;

import javax.swing.*;

public class MyFrame4 extends JFrame {
    private JPanel jPanel; // 面板
    private JLabel jLabel; //文字
    private JTextField jTextField; //文本框
    private JPasswordField jPasswordField; //密码框
    private JLabel jLabel2; // 密码文字

    public MyFrame4() {
        jPanel = new JPanel();
        jLabel = new JLabel("用户名");
        jLabel2 = new JLabel("密码");
        //参数是文本框的长度
        jTextField = new JTextField(20);
        jPasswordField = new JPasswordField(20);

        jPanel.add(jLabel);
        jPanel.add(jTextField);
        jPanel.add(jLabel2);
        jPanel.add(jPasswordField);
        //再把面板放到窗口中
        this.add(jPanel);
        this.setTitle("测试面板");
        this.setSize(800, 600);
        this.setLocationRelativeTo(null);
        this.setVisible(true);


        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
