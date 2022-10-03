package com.dowei.empsys.view;

import com.dowei.empsys.dao.UserDao;
import com.dowei.empsys.entity.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginFrame extends JFrame {

    private JPanel jPanel;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JPanel jPanel3;

    private JLabel jLabel1;
    private JLabel jLabel2;

    private JTextField jTextField;
    private JPasswordField jPasswordField;

    private JButton jButton1;
    private JButton jButton2;

    private RegUserDialog regUserDialog;

    public LoginFrame(){
        regUserDialog = new RegUserDialog();
        jPanel = new JPanel();
        jPanel1 = new JPanel();
        jPanel2 = new JPanel();
        jPanel3 = new JPanel();
        jPanel.setLayout(new GridLayout(3, 1));

        jLabel1 = new JLabel("用户名");
        jLabel2 = new JLabel("密码");

        jTextField = new JTextField(20);
        jPasswordField = new JPasswordField(20);

        jButton1 = new JButton("登录");
        jButton2 = new JButton("注册");
        LoginFrameClick loginFrameClick = new LoginFrameClick();
        jButton1.addActionListener(loginFrameClick);
        jButton2.addActionListener(loginFrameClick);

        jPanel1.add(jLabel1);
        jPanel1.add(jTextField);
        jPanel2.add(jLabel2);
        jPanel2.add(jPasswordField);
        jPanel3.add(jButton1);
        jPanel3.add(jButton2);

        jPanel.add(jPanel1);
        jPanel.add(jPanel2);
        jPanel.add(jPanel3);

        this.add(jPanel);

        this.setTitle("欢迎使用Dxx管理系统");
        this.setSize(400, 200);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    private class LoginFrameClick implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == jButton1){
//                System.out.println("登录");
                String username = jTextField.getText();
                UserDao userDao = new UserDao();
                User oneUserByUsername = userDao.getOneUserByUsername(username);
                if (oneUserByUsername == null){
                    JOptionPane.showMessageDialog(jPanel2, "用户名不存在", "警告", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                String password = jPasswordField.getText();
                if (oneUserByUsername.getPassword().equals(password)){
//                    LoginFrame.this.setVisible(false);
                    setVisible(false);
                    new MainView();
                }else{
                    JOptionPane.showMessageDialog(jPanel2, "密码错误", "警告", JOptionPane.WARNING_MESSAGE);
                }
            }else if(e.getSource() == jButton2){
                System.out.println("注册");
                regUserDialog.setVisible(true);

            }
        }
    }

    private class RegUserDialog extends JDialog {
        private JPanel jPanel1, jPanel2, jPanel3, jPanel4, jPanel5;
        private JLabel jLabel1, jLabel2, jLabel3, jLabel4;
        private JTextField jTextField1, jTextField2;
        private JPasswordField jPasswordField1, jPasswordField2;
        private JButton jButton1, jButton2;

        public RegUserDialog() {
            this.setLayout(new GridLayout(5, 1));
            //初始化JPanel
            jPanel1 = new JPanel();
            jPanel2 = new JPanel();
            jPanel3 = new JPanel();
            jPanel4 = new JPanel();
            jPanel5 = new JPanel();
            //初始化JLable
            jLabel1 = new JLabel("用户名");
            jLabel2 = new JLabel("密码");
            jLabel3 = new JLabel("确认密码");
            jLabel4 = new JLabel("用户昵称");
            //初始化JTextField
            jTextField1 = new JTextField(20);
            jTextField2 = new JTextField(20);
            //初始化密码框
            jPasswordField1 = new JPasswordField(20);
            jPasswordField2 = new JPasswordField(20);
            //初始化按钮
            jButton1 = new JButton("确认增加");
            jButton2 = new JButton("重置数据");
            AddUserDialogClick addUserDialogClick = new AddUserDialogClick();
            jButton1.addActionListener(addUserDialogClick);
            jButton2.addActionListener(addUserDialogClick);

            //把组件放入面板中
            jPanel1.add(jLabel1);
            jPanel1.add(jTextField1);
            jPanel2.add(jLabel2);
            jPanel2.add(jPasswordField1);
            jPanel3.add(jLabel3);
            jPanel3.add(jPasswordField2);
            jPanel4.add(jLabel4);
            jPanel4.add(jTextField2);
            jPanel5.add(jButton1);
            jPanel5.add(jButton2);

            this.add(jPanel1);
            this.add(jPanel2);
            this.add(jPanel3);
            this.add(jPanel4);
            this.add(jPanel5);

            this.setTitle("增加用户");
            this.setSize(400, 500);
            this.setLocationRelativeTo(null);
            //设置模态对话框
            this.setModal(true);
        }

        //编写事件类，给对话框
        private class AddUserDialogClick implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == jButton1) {
                    //System.out.println("增加用户被点击了");
                    String username = jTextField1.getText().trim();
                    //校验数据
                    if (!(username.length() >= 1 && username.length() <= 8)) {
                        JOptionPane.showMessageDialog(jPanel3, "用户名必须再1到8个字符之间", "警告", JOptionPane.WARNING_MESSAGE);
                        return;
                    }
                    //连接数据库
                    UserDao userDao = new UserDao();
                    User oneUserByUsername = userDao.getOneUserByUsername(username);
                    if (oneUserByUsername != null) {
                        JOptionPane.showMessageDialog(jPanel3, "用户名已存在", "警告", JOptionPane.WARNING_MESSAGE);
                        return;
                    }
                    String password = jPasswordField1.getText();
                    String password2 = jPasswordField2.getText();
                    if (!(password.length() >= 6 && password.length() <= 18)) {
                        JOptionPane.showMessageDialog(jPanel3, "密码必须再6到18个字符之间", "警告", JOptionPane.WARNING_MESSAGE);
                        return;
                    } else if (!password.equals(password2)) {
                        JOptionPane.showMessageDialog(jPanel3, "两次密码不一致", "警告", JOptionPane.WARNING_MESSAGE);
                        return;
                    }
                    String nickname = jTextField2.getText();
                    if (!(nickname.length() >= 3 && nickname.length() <= 8)) {
                        JOptionPane.showMessageDialog(jPanel3, "用户昵称必须再3到8个字符之间", "警告", JOptionPane.WARNING_MESSAGE);
                        return;
                    }
                    int i = userDao.addUser((new User(null, username, password, nickname)));
                    if (i > 0) {
                        JOptionPane.showMessageDialog(jPanel3, "增加用户成功", "成功", JOptionPane.INFORMATION_MESSAGE);
                        regUserDialog.setVisible(false);

                    } else {
                        JOptionPane.showMessageDialog(jPanel3, "增加用户失败", "警告", JOptionPane.WARNING_MESSAGE);
                    }
                    clear();
                } else if (e.getSource() == jButton2) {
                    //System.out.println("重置");
                    clear();
                }
            }

            private void clear() {
                jTextField1.setText("");
                jTextField2.setText("");
                jPasswordField1.setText("");
                jPasswordField2.setText("");
            }

        }

    }
}
