package com.dowei.empsys.view;

import com.dowei.empsys.dao.UserDao;
import com.dowei.empsys.entity.User;
import com.dowei.empsys.utils.MyUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

/**
 * 用户面板
 */
public class UserPanel extends JPanel {
    //准备三个面板
    private JPanel jPanel1, jPanel2, jPanel3;
    private JLabel jLabel;
    private JTable jTable;//表格
    private JScrollPane jScrollPane;
    private JButton jButton1, jButton2, jButton3;
    private AddUserDialog addUserDialog;
    private UpdateUserDialog updateUserDialog;

    public UserPanel() {
        addUserDialog = new AddUserDialog();
        updateUserDialog = new UpdateUserDialog();
        //设置布局：边框布局
        this.setLayout(new BorderLayout());
        jPanel1 = new JPanel(); //放文字
        //存放表格的面板
        jPanel2 = new JPanel();
        //存放按钮的面板
        jPanel3 = new JPanel();//放按钮

        jLabel = new JLabel("用户信息管理");

        jTable = new JTable(new UserTableModel());
        jScrollPane = new JScrollPane(jTable);

        jButton1 = new JButton("增加用户");
        jButton2 = new JButton("删除用户");
        jButton3 = new JButton("修改用户");

        UserPanelClick userPanelClick = new UserPanelClick();
        jButton1.addActionListener(userPanelClick);
        jButton2.addActionListener(userPanelClick);
        jButton3.addActionListener(userPanelClick);

        jPanel1.add(jLabel);
        jPanel2.add(jScrollPane);
        jPanel3.add(jButton1);
        jPanel3.add(jButton2);
        jPanel3.add(jButton3);

        this.add(jPanel1, BorderLayout.NORTH);
        this.add(jPanel2, BorderLayout.CENTER);
        this.add(jPanel3, BorderLayout.SOUTH);
    }
    private class UserPanelClick implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == jButton1) {
                //System.out.println("增加用户");
                addUserDialog.setVisible(true);
            } else if (e.getSource() == jButton2) { // 删除用户
                //System.out.println("删除用户");
                //当row = -1 时，说明未选择行
                //int row = jTable.getSelectedRow();
                int[] rows = jTable.getSelectedRows();
                if (rows == null) {
                    JOptionPane.showMessageDialog(jPanel2, "请选择一行", "警告", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                //删除需要确认框
                int choose = JOptionPane.showConfirmDialog(jPanel2, "确认是否删除");
                //System.out.println("choose=" + choose);
                if (choose == 0) {
                    //UserTableModel中提供getRowData方法
                    Vector<Vector<String>> rowData = new UserTableModel().getRowData();
                    int effect = -1;
                    for (int row : rows) {
                        int userId = Integer.parseInt(rowData.get(row).get(0));
                        UserDao userDao = new UserDao();
                        effect = userDao.deleteUser(userId);
                    }
                    if (effect > 0) {
                        JOptionPane.showMessageDialog(jPanel2, "删除成功", "通知", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(jPanel2, "删除失败", "警告", JOptionPane.WARNING_MESSAGE);
                    }
                    //System.out.println("row = " + row);
                    //System.out.println(userId);
                }
                jTable.setModel(new UserTableModel());

            } else if (e.getSource() == jButton3) {
                //System.out.println("修改用户");
                int row = jTable.getSelectedRow();
                if (-1 == row) {
                    JOptionPane.showMessageDialog(jPanel2, "请选择一行", "警告", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                Vector<Vector<String>> rowData = new UserTableModel().getRowData();
                //用于回显修改前的数据
                Vector<String> oneRow = rowData.get(row);
                updateUserDialog.showDialog(oneRow);
                System.out.println(oneRow);

            }
        }
    }
    //创建增加用户的对话框
    private class AddUserDialog extends JDialog {
        private JPanel jPanel1, jPanel2, jPanel3, jPanel4, jPanel5;
        private JLabel jLabel1, jLabel2, jLabel3, jLabel4;
        private JTextField jTextField1, jTextField2;
        private JPasswordField jPasswordField1, jPasswordField2;
        private JButton jButton1, jButton2;

        public AddUserDialog() {
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
                    if (!(username.length() >= 6 && username.length() <= 18)) {
                        JOptionPane.showMessageDialog(jPanel3, "用户名必须再6到18个字符之间", "警告", JOptionPane.WARNING_MESSAGE);
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
                        addUserDialog.setVisible(false);
                    } else {
                        JOptionPane.showMessageDialog(jPanel3, "增加用户失败", "警告", JOptionPane.WARNING_MESSAGE);
                    }
                    jTable.setModel(new UserTableModel());
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

    //修改用户对话框
    private class UpdateUserDialog extends JDialog {

        private JPanel jPanelNickname;
        private JPanel jPanelPassword;
        private JPanel jPanelPassword2;
        private JPanel jPanelButton;
        private JLabel jLabelNickname;
        private JLabel jLabelPassword;
        private JLabel jLabelPassword2;
        private JButton jButtonEnter;
        private JButton jButtonReset;
        private JTextField jTextFieldNickname;
        private JPasswordField jPasswordField1;
        private JPasswordField jPasswordField2;
        private Vector<String> oneRow;


        public UpdateUserDialog() {
            this.setLayout(new GridLayout(4, 1));
            jPanelNickname = new JPanel();
            jPanelPassword = new JPanel();
            jPanelPassword2 = new JPanel();
            jPanelButton = new JPanel();
            jLabelNickname = new JLabel("用户昵称");
            jLabelPassword = new JLabel("密码");
            jLabelPassword2 = new JLabel("确认密码");
            jTextFieldNickname = new JTextField(20);
            jPasswordField1 = new JPasswordField(20);
            jPasswordField2 = new JPasswordField(20);
            jButtonEnter = new JButton("确认修改");
            jButtonReset = new JButton("重置数据");
            UpdateDialogClick updateDialogClick = new UpdateDialogClick();
            jButtonEnter.addActionListener(updateDialogClick);
            jButtonReset.addActionListener(updateDialogClick);

            jPanelNickname.add(jLabelNickname);
            jPanelNickname.add(jTextFieldNickname);

            jPanelPassword.add(jLabelPassword);
            jPanelPassword.add(jPasswordField1);

            jPanelPassword2.add(jLabelPassword2);
            jPanelPassword2.add(jPasswordField2);

            jPanelButton.add(jButtonEnter);
            jPanelButton.add(jButtonReset);

            this.add(jPanelNickname);
            this.add(jPanelPassword);
            this.add(jPanelPassword2);
            this.add(jPanelButton);

            //this.setTitle("增加用户");
            this.setSize(400, 500);
            this.setLocationRelativeTo(null);
            //设置模态对话框
            this.setModal(true);
        }

        public void showDialog(Vector<String> oneRow){
            this.oneRow = oneRow;
            //设置对话框的标题
            this.setTitle("正在修改" + oneRow.get(1) + "用户");

            //密码不回现
            //回显用户昵称
            jTextFieldNickname.setText(oneRow.get(3));
            this.setVisible(true);
        }

        private class UpdateDialogClick implements ActionListener{

            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == jButtonEnter){
                    //System.out.println("修改");
                    String nickname = jTextFieldNickname.getText();
                    if (!(nickname.length() >= 1 && nickname.length() <= 8)) {
                        JOptionPane.showMessageDialog(jPanel2, "用户昵称必须再1到8个字符之间", "警告", JOptionPane.WARNING_MESSAGE);
                        return;
                    }
                    String password = jPasswordField1.getText();
                    String password2 = jPasswordField2.getText();
                    if (MyUtils.isEmpty(password) || MyUtils.isEmpty(password2)) {
                        JOptionPane.showMessageDialog(jPanel2, "密码或确认密码不能为空", "警告", JOptionPane.WARNING_MESSAGE);
                        return;
                    }
                    if(oneRow.get(2).equals(password)){
                        JOptionPane.showMessageDialog(jPanel2, "新密码不能与旧密码相同", "警告", JOptionPane.WARNING_MESSAGE);
                        return;
                    }
                    if(!password.equals(password2)){
                        JOptionPane.showMessageDialog(jPanel2, "两次密码不一致", "警告", JOptionPane.WARNING_MESSAGE);
                        return;
                    }
                    UserDao userDao = new UserDao();
                    int effect = userDao.updateUser(new User(Integer.parseInt(oneRow.get(0)), oneRow.get(1), password, nickname));
                    if (effect > 0 ){
                        JOptionPane.showMessageDialog(jPanel2, "修改成功", "提示", JOptionPane.INFORMATION_MESSAGE);
                    }else{
                        JOptionPane.showMessageDialog(jPanel2, "修改失败，请检查数据后重试", "警告", JOptionPane.WARNING_MESSAGE);
                        return;
                    }
                    jTable.setModel(new UserTableModel());
                    updateUserDialog.setVisible(false);
                    clear();
                }else if(e.getSource() == jButtonReset){
                    //System.out.println("重置");
                    clear();
                }
            }

            public void clear(){
                jTextFieldNickname.setText(oneRow.get(3));
                jPasswordField1.setText("");
                jPasswordField2.setText("");
            }
        }

    }

    public void refresh(){
        this.jTable.setModel(new UserTableModel());
    }

}
