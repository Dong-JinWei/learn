package com.dowei.librarysys.view;

import com.dowei.librarysys.dao.AuthorDao;
import com.dowei.librarysys.entity.Author;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class AuthorPanel extends JPanel {
    private JPanel jPanel1, jPanel2, jPanel3;
    private JLabel jLabel;
    private JTable jTable;
    private JScrollPane jScrollPane;
    private JButton jButton1, jButton2, jButton3;
    private AddAuthorDialog addAuthorDialog;
    private UpdateAuthorDialog updateAuthorDialog;

    public AuthorPanel() {
        updateAuthorDialog = new UpdateAuthorDialog();
        addAuthorDialog = new AddAuthorDialog();
        this.setLayout(new BorderLayout());
        jPanel1 = new JPanel();
        jPanel2 = new JPanel();
        jPanel3 = new JPanel();
        jLabel = new JLabel("作者管理");
        jTable = new JTable(new AuthorTableModel());
        jScrollPane = new JScrollPane(jTable);
        jButton1 = new JButton("增加作者");
        jButton2 = new JButton("删除作者");
        jButton3 = new JButton("修改作者");
        AuthorPanelClick authorPanelClick = new AuthorPanelClick();
        jButton1.addActionListener(authorPanelClick);
        jButton2.addActionListener(authorPanelClick);
        jButton3.addActionListener(authorPanelClick);
        jPanel1.add(jLabel);
        jPanel2.add(jScrollPane);
        jPanel3.add(jButton1);
        jPanel3.add(jButton2);
        jPanel3.add(jButton3);
        this.add(jPanel1, BorderLayout.NORTH);
        this.add(jPanel2, BorderLayout.CENTER);
        this.add(jPanel3, BorderLayout.SOUTH);
    }

    private class AuthorPanelClick implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == jButton1) {
                System.out.println("增加作者");
                addAuthorDialog.setVisible(true);
            } else if (e.getSource() == jButton2) {
                System.out.println("删除作者");
                int[] rowNum = jTable.getSelectedRows();
                if (rowNum.length <= 0) {
                    JOptionPane.showMessageDialog(jPanel2, "请至少选择一行", "警告", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                AuthorTableModel authorTableModel = new AuthorTableModel();
                Vector<Vector<String>> rowData = authorTableModel.getRowData();
                AuthorDao authorDao = new AuthorDao();
                int choose = JOptionPane.showConfirmDialog(jPanel2, "确认是否删除");
                if (choose != 0){
                    return;
                }
                for (int row : rowNum) {
                    Author author = new Author(Integer.parseInt(rowData.get(row).get(0)), rowData.get(row).get(1));
                    System.out.println(author);
                    int effect = authorDao.delAuthor(author.getAuthorId());
                    if (effect <= 0) {
                        JOptionPane.showMessageDialog(jPanel2, "删除失败", "警告", JOptionPane.WARNING_MESSAGE);
                        return;
                    }
                }
                JOptionPane.showMessageDialog(jPanel2, "删除成功", "提示", JOptionPane.INFORMATION_MESSAGE);
                jTable.setModel(new AuthorTableModel());
            } else if (e.getSource() == jButton3) {
                System.out.println("修改作者");
                int rowNum = jTable.getSelectedRow();
                if (rowNum < 0) {
                    JOptionPane.showMessageDialog(jPanel2, "请至少选择一行", "警告", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                AuthorTableModel authorTableModel = new AuthorTableModel();
                Vector<Vector<String>> rowData = authorTableModel.getRowData();
                Vector<String> oneRow = rowData.get(rowNum);
                Author author = new Author(Integer.parseInt(oneRow.get(0)), oneRow.get(1));
                updateAuthorDialog.showDialog(author);
            }
        }
    }

    private class AddAuthorDialog extends JDialog {
        private JPanel jPanelAuthorName; //放置作者名的面板
        private JPanel jPanelJButton;  // 放置按钮的面板

        private JLabel jLabelAuthorName; //显示作者名字的文字
        private JTextField jTextFieldAuthorName; //输入框

        private JButton jButtonEnter; //确认按钮
        private JButton jButtonReset; //重置按钮

        public AddAuthorDialog() {
            this.setLayout(new GridLayout(2, 1));

            jPanelAuthorName = new JPanel();
            jPanelJButton = new JPanel();

            jLabelAuthorName = new JLabel("作者名字");
            jTextFieldAuthorName = new JTextField(20);

            jButtonEnter = new JButton("确认修改");
            jButtonReset = new JButton("重置数据");
            AddAuthorDialogClick addAuthorDialogClick = new AddAuthorDialogClick();
            jButtonEnter.addActionListener(addAuthorDialogClick);
            jButtonReset.addActionListener(addAuthorDialogClick);

            jPanelAuthorName.add(jLabelAuthorName);
            jPanelAuthorName.add(jTextFieldAuthorName);

            jPanelJButton.add(jButtonEnter);
            jPanelJButton.add(jButtonReset);

            this.add(jPanelAuthorName);
            this.add(jPanelJButton);

            this.setTitle("增加作者");
            this.setSize(400, 200);
            this.setLocationRelativeTo(null);
            this.setModal(true);
        }

        private void clear() {
            jTextFieldAuthorName.setText("");
        }

        private class AddAuthorDialogClick implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == jButtonEnter) {
                    System.out.println("确认修改");
                    String authorName = jTextFieldAuthorName.getText();
                    if (authorName.length() < 1 || authorName.length() > 8) {
                        JOptionPane.showMessageDialog(jPanel2, "作者名必须再1到8个字符之间", "警告", JOptionPane.WARNING_MESSAGE);
                        return;
                    }
                    AuthorDao authorDao = new AuthorDao();
                    if (authorDao.isAuthorExist(authorName)) {
                        JOptionPane.showMessageDialog(jPanel2, "作者已存在，无法添加", "警告", JOptionPane.WARNING_MESSAGE);
                        return;
                    }
                    int effect = authorDao.addAuthor(new Author(null, authorName));
                    if (effect <= 0) {
                        JOptionPane.showMessageDialog(jPanel2, "作者添加失败", "警告", JOptionPane.WARNING_MESSAGE);
                        return;
                    }
                    JOptionPane.showMessageDialog(jPanel2, "作者添加成功", "提示", JOptionPane.INFORMATION_MESSAGE);
                    addAuthorDialog.setVisible(false);
                    jTable.setModel(new AuthorTableModel());
                    clear();
                } else if (e.getSource() == jButtonReset) {
                    System.out.println("重置数据");
                    clear();
                }
            }
        }

    }

    private class UpdateAuthorDialog extends JDialog {
        private JPanel jPanelAuthorName; //放置作者名的面板
        private JPanel jPanelJButton;  // 放置按钮的面板

        private JLabel jLabelAuthorName; //显示作者名字的文字
        private JTextField jTextFieldAuthorName; //输入框

        private JButton jButtonEnter; //确认按钮
        private JButton jButtonReset; //重置按钮

        private Author author;

        public UpdateAuthorDialog() {
            this.setLayout(new GridLayout(2, 1));
            jPanelAuthorName = new JPanel();
            jPanelJButton = new JPanel();

            jLabelAuthorName = new JLabel("作者名");
            jTextFieldAuthorName = new JTextField(20);
            jButtonEnter = new JButton("确认修改");
            jButtonReset = new JButton("重置数据");
            UpdateAuthorDialogClick updateAuthorDialogClick = new UpdateAuthorDialogClick();
            jButtonEnter.addActionListener(updateAuthorDialogClick);
            jButtonReset.addActionListener(updateAuthorDialogClick);

            jPanelAuthorName.add(jLabelAuthorName);
            jPanelAuthorName.add(jTextFieldAuthorName);

            jPanelJButton.add(jButtonEnter);
            jPanelJButton.add(jButtonReset);

            this.add(jPanelAuthorName);
            this.add(jPanelJButton);

            this.setTitle("修改作者");
            this.setLocationRelativeTo(null);
            this.setSize(300, 200);
            this.setModal(true);
        }

        public void showDialog(Author author) {
            this.author = author;

            this.setTitle("修改" + author.getAuthorName() + "中");
            jTextFieldAuthorName.setText(author.getAuthorName());
            this.setVisible(true);
        }

        public class UpdateAuthorDialogClick implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == jButtonEnter) {
                    System.out.println("确认修改");
                    String authorName = jTextFieldAuthorName.getText();
                    if (authorName.length() < 1 || authorName.length() > 8) {
                        JOptionPane.showMessageDialog(jPanel2, "作者名字必须再1到8个字符之间", "警告", JOptionPane.WARNING_MESSAGE);
                        return;
                    }
                    AuthorDao authorDao = new AuthorDao();
                    if (authorDao.isAuthorExist(authorName)) {
                        JOptionPane.showMessageDialog(jPanel2, "作者已存在，请重新输入", "警告", JOptionPane.WARNING_MESSAGE);
                        return;
                    }
                    int effect = authorDao.updateAuthor(new Author(author.getAuthorId(), authorName));
                    if (effect < 0) {
                        JOptionPane.showMessageDialog(jPanel2, "修改失败", "警告", JOptionPane.WARNING_MESSAGE);
                        return;
                    }
                    JOptionPane.showMessageDialog(jPanel2, "修改成功", "提示", JOptionPane.INFORMATION_MESSAGE);
                    jTable.setModel(new AuthorTableModel());
                    updateAuthorDialog.setVisible(false);
                    clear();

                } else if (e.getSource() == jButtonReset) {
                    System.out.println("重置数据");
                    clear();
                }
            }

            public void clear() {
                jTextFieldAuthorName.setText(author.getAuthorName());
            }
        }

    }

}
