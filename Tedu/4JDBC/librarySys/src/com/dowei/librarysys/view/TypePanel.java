package com.dowei.librarysys.view;

import com.dowei.librarysys.dao.TypeDao;
import com.dowei.librarysys.entity.Book;
import com.dowei.librarysys.entity.BookType;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Type;
import java.util.Vector;

public class TypePanel extends JPanel {
    private JPanel jPanel1, jPanel2, jPanel3;
    private JLabel jLabel;
    private JTable jTable;
    private JScrollPane jScrollPane;
    private JButton jButton1, jButton2, jButton3;
    private AddTypeDialog addTypeDialog;
    private UpdateTypeDialog updateTypeDialog;

    public TypePanel() {
        updateTypeDialog = new UpdateTypeDialog();
        addTypeDialog = new AddTypeDialog();
        this.setLayout(new BorderLayout());
        jPanel1 = new JPanel();
        jPanel2 = new JPanel();
        jPanel3 = new JPanel();
        jLabel = new JLabel("类型管理");
        jTable = new JTable(new TypeTableModel());
        jScrollPane = new JScrollPane(jTable);
        jButton1 = new JButton("增加类型");
        jButton2 = new JButton("删除类型");
        jButton3 = new JButton("修改类型");
        TypePanelClick typePanelClick = new TypePanelClick();
        jButton1.addActionListener(typePanelClick);
        jButton2.addActionListener(typePanelClick);
        jButton3.addActionListener(typePanelClick);


        jPanel1.add(jLabel);
        jPanel2.add(jScrollPane);
        jPanel3.add(jButton1);
        jPanel3.add(jButton2);
        jPanel3.add(jButton3);
        this.add(jPanel1, BorderLayout.NORTH);
        this.add(jPanel2, BorderLayout.CENTER);
        this.add(jPanel3, BorderLayout.SOUTH);
    }

    private class TypePanelClick implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == jButton1) {
                System.out.println("增加类型");
                addTypeDialog.setVisible(true);
            } else if (e.getSource() == jButton2) {
                System.out.println("删除类型");
                int[] rows = jTable.getSelectedRows();
                if (rows.length <= 0) {
                    JOptionPane.showMessageDialog(jPanel2, "请至少选择一行", "警告", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                int choose = JOptionPane.showConfirmDialog(jPanel2, "确认是否删除");
                if (choose != 0) {
                    return;
                }
                TypeDao typeDao = new TypeDao();
                TypeTableModel typeTableModel = new TypeTableModel();
                Vector<Vector<String>> rowData = typeTableModel.getRowData();
                for (int row : rows) {
                    BookType bookType = new BookType(Integer.parseInt(rowData.get(row).get(0)), rowData.get(row).get(1));
                    int effect = typeDao.delType(bookType.getTypeId());
                    if (effect <= 0) {
                        JOptionPane.showMessageDialog(jPanel2, "删除失败", "警告", JOptionPane.WARNING_MESSAGE);
                        return;
                    }
                    JOptionPane.showMessageDialog(jPanel2, "删除成功", "提示", JOptionPane.INFORMATION_MESSAGE);
                    jTable.setModel(new TypeTableModel());
                }
            } else if (e.getSource() == jButton3) {
                System.out.println("修改类型");
                int rowNum = jTable.getSelectedRow();
                if (rowNum < 0){
                    JOptionPane.showMessageDialog(jPanel2, "请至少选择一行", "警告", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                TypeTableModel typeTableModel = new TypeTableModel();
                Vector<Vector<String>> rowData = typeTableModel.getRowData();
                BookType bookType = new BookType(Integer.parseInt(rowData.get(rowNum).get(0)), rowData.get(rowNum).get(1));
                updateTypeDialog.showDialog(bookType);
            }
        }
    }

    private class AddTypeDialog extends JDialog {
        private JPanel jPanelTypeName; //放置作者名的面板
        private JPanel jPanelJButton;  // 放置按钮的面板

        private JLabel jLabelTypeName; //显示作者名字的文字
        private JTextField jTextFieldTypeName; //输入框

        private JButton jButtonEnter; //确认按钮
        private JButton jButtonReset; //重置按钮

        public AddTypeDialog() {
            this.setLayout(new GridLayout(2, 1));

            jPanelTypeName = new JPanel();
            jPanelJButton = new JPanel();
            jLabelTypeName = new JLabel("类型名");
            jTextFieldTypeName = new JTextField(20);
            jButtonEnter = new JButton("确认增加");
            jButtonReset = new JButton("重置数据");
            AddTypeDialogClick addTypeDialogClick = new AddTypeDialogClick();
            jButtonEnter.addActionListener(addTypeDialogClick);
            jButtonReset.addActionListener(addTypeDialogClick);

            jPanelTypeName.add(jLabelTypeName);
            jPanelTypeName.add(jTextFieldTypeName);


            jPanelJButton.add(jButtonEnter);
            jPanelJButton.add(jButtonReset);

            this.add(jPanelTypeName);
            this.add(jPanelJButton);

            this.setTitle("增加类型");
            this.setSize(400, 200);
            this.setLocationRelativeTo(null);
            this.setModal(true);
        }

        public class AddTypeDialogClick implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == jButtonEnter) {
                    System.out.println("确认增加");
                    String typeName = jTextFieldTypeName.getText();
                    if (typeName.length() < 1 || typeName.length() > 8) {
                        JOptionPane.showMessageDialog(jPanel2, "类型名必须再1到8个字符之间", "警告", JOptionPane.WARNING_MESSAGE);
                        return;
                    }
                    TypeDao typeDao = new TypeDao();
                    if (typeDao.isTypeExistByTypeName(typeName)) {
                        JOptionPane.showMessageDialog(jPanel2, "类型名存在", "警告", JOptionPane.WARNING_MESSAGE);
                        return;
                    }
                    int effect = typeDao.addType(new BookType(null, typeName));
                    if (effect < 0) {
                        JOptionPane.showMessageDialog(jPanel2, "增加失败", "警告", JOptionPane.WARNING_MESSAGE);
                        return;
                    }
                    JOptionPane.showMessageDialog(jPanel2, "增加成功", "提示", JOptionPane.INFORMATION_MESSAGE);
                    jTable.setModel(new TypeTableModel());
                    addTypeDialog.setVisible(false);
                    clear();
                } else if (e.getSource() == jButtonReset) {
                    System.out.println("重置数据");
                    clear();
                }
            }

            public void clear() {
                jTextFieldTypeName.setText("");
            }
        }
    }

    private class UpdateTypeDialog extends JDialog{
        private JPanel jPanelTypeName; //放置作者名的面板
        private JPanel jPanelJButton;  // 放置按钮的面板

        private JLabel jLabelTypeName; //显示作者名字的文字
        private JTextField jTextFieldTypeName; //输入框

        private JButton jButtonEnter; //确认按钮
        private JButton jButtonReset; //重置按钮
        private BookType bookType;

        private UpdateTypeDialog(){
            this.setLayout(new GridLayout(2, 1));

            jPanelTypeName = new JPanel();
            jPanelJButton = new JPanel();
            jLabelTypeName = new JLabel("类型名");
            jTextFieldTypeName = new JTextField(20);
            jButtonEnter = new JButton("确认修改");
            jButtonReset = new JButton("重置数据");

            jPanelTypeName.add(jLabelTypeName);
            jPanelTypeName.add(jTextFieldTypeName);


            jPanelJButton.add(jButtonEnter);
            jPanelJButton.add(jButtonReset);
            UpdateTypeDialogClick updateTypeDialogClick = new UpdateTypeDialogClick();
            jButtonEnter.addActionListener(updateTypeDialogClick);
            jButtonReset.addActionListener(updateTypeDialogClick);

            this.add(jPanelTypeName);
            this.add(jPanelJButton);

            this.setTitle("修改类型");
            this.setSize(400, 200);
            this.setLocationRelativeTo(null);
            this.setModal(true);
        }

        private class UpdateTypeDialogClick implements ActionListener{
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == jButtonEnter) {
                    System.out.println("修改类型");
                    String typeName = jTextFieldTypeName.getText();
                    if (typeName.length() < 1 || typeName.length() > 8){
                        JOptionPane.showMessageDialog(jPanel2, "类型名必须大于1小于8", "警告", JOptionPane.WARNING_MESSAGE);
                        return;
                    }
                    TypeDao typeDao = new TypeDao();
                    if (typeDao.isTypeExistByTypeName(typeName)) {
                        JOptionPane.showMessageDialog(jPanel2, "该类型已存在，无法添加", "警告", JOptionPane.WARNING_MESSAGE);
                        return;
                    }
                    int effect = typeDao.updateType(new BookType(bookType.getTypeId(), typeName));
                    if (effect <= 0){
                        JOptionPane.showMessageDialog(jPanel2, "修改失败", "警告", JOptionPane.WARNING_MESSAGE);
                        return;
                    }
                    JOptionPane.showMessageDialog(jPanel2, "修改成功", "提示", JOptionPane.INFORMATION_MESSAGE);
                    jTable.setModel(new TypeTableModel());
                    updateTypeDialog.setVisible(false);
                    clear();
                }else if (e.getSource() == jButtonReset){
                    System.out.println("重置数据");
                    clear();
                }
            }
        }

        public void clear(){
            jTextFieldTypeName.setText(bookType.getTypeName());
        }

        public void showDialog(BookType bookType){
            this.bookType = bookType;
            this.setTitle("修改" + bookType.getTypeName() + "中");
            jTextFieldTypeName.setText(bookType.getTypeName());

            setVisible(true);
        }

    }

}
