package com.dowei.empsys.view;

import com.dowei.empsys.dao.DeptDao;
import com.dowei.empsys.entity.Dept;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

/**
 * 用户面板
 */
public class DeptPanel extends JPanel {
    //准备三个面板
    private JPanel jPanel1, jPanel2, jPanel3;
    private JLabel jLabel;
    private JTable jTable;//表格
    private JScrollPane jScrollPane;
    private JButton jButton1, jButton2, jButton3;
    private AddDeptDialog addDeptDialog;
    private DeptTableModel deptTableModel;
    private UpdateDialog updateDialog;

    public DeptPanel() {
        addDeptDialog = new AddDeptDialog();
        updateDialog = new UpdateDialog();
        //设置布局：边框布局
        this.setLayout(new BorderLayout());
        jPanel1 = new JPanel(); //放文字
        //存放表格的面板
        jPanel2 = new JPanel();
        //存放按钮的面板
        jPanel3 = new JPanel();//放按钮

        jLabel = new JLabel("部门信息管理");

        jTable = new JTable(new DeptTableModel());
        jScrollPane = new JScrollPane(jTable);

        jButton1 = new JButton("增加部门");
        jButton2 = new JButton("删除部门");
        jButton3 = new JButton("修改部门");

        DeptPanelClick addDeptPanelClick = new DeptPanelClick();
        jButton1.addActionListener(addDeptPanelClick);
        jButton2.addActionListener(addDeptPanelClick);
        jButton3.addActionListener(addDeptPanelClick);

        jPanel1.add(jLabel);
        jPanel2.add(jScrollPane);
        jPanel3.add(jButton1);
        jPanel3.add(jButton2);
        jPanel3.add(jButton3);
        this.add(jPanel1, BorderLayout.NORTH);
        //此处放表格
        this.add(jScrollPane);
        this.add(jPanel3, BorderLayout.SOUTH);
    }

    private class DeptPanelClick implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == jButton1) {
                //System.out.println("增加部门");
                addDeptDialog.setVisible(true);
            } else if (e.getSource() == jButton2) {
                System.out.println("删除部门");
                int[] rows = jTable.getSelectedRows();
                if (rows.length <= 0) {
                    JOptionPane.showMessageDialog(jPanel2, "请至少选择一行", "警告", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                int choose = JOptionPane.showConfirmDialog(jPanel2, "确认是否删除");
                if (choose != 0){
                    return;
                }
                DeptDao deptDao = new DeptDao();
                deptTableModel = new DeptTableModel();
                Vector<Vector<String>> rowData = deptTableModel.getRowData();
                int effect = -1;
                for (int row : rows) {
                    if (Integer.parseInt(rowData.get(row).get(2)) > 0){
                        JOptionPane.showMessageDialog(jPanel2, "部门内有员工，无法删除", "警告", JOptionPane.WARNING_MESSAGE);
                        return;
                    }
                    effect = deptDao.deleteDept(Integer.parseInt(rowData.get(row).get(0)));
                    if (effect <= 0) {
                        JOptionPane.showMessageDialog(jPanel2, "第" + (row + 1) + "行删除错误", "警告", JOptionPane.WARNING_MESSAGE);
                        return;
                    }
                }
                JOptionPane.showMessageDialog(jPanel2, "删除成功", "通知", JOptionPane.INFORMATION_MESSAGE);
                jTable.setModel(new DeptTableModel());
            } else if (e.getSource() == jButton3) {
                //System.out.println("修改部门");
                int rowNum = jTable.getSelectedRow();
                if (rowNum < 0){
                    JOptionPane.showMessageDialog(jPanel2, "请选择一行", "警告", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                deptTableModel = new DeptTableModel();
                Vector<Vector<String>> rowData = deptTableModel.getRowData();
//                updateDialog.showDialog(rowData.get(rowNum));

                Vector<String> oneRow = rowData.get(rowNum);
                Dept dept = new Dept(Integer.parseInt(oneRow.get(0)), oneRow.get(1));
                updateDialog.showDialog(dept);
            }
        }
    }

    private class AddDeptDialog extends JDialog {
        private JPanel jPanel1, jPanel2;
        private JLabel jLabel1;
        private JTextField jTextField1;
        private JButton jButton1, jButton2;

        public AddDeptDialog() {
            this.setLayout(new GridLayout(2, 1));
            jPanel1 = new JPanel();
            jPanel2 = new JPanel();

            jLabel1 = new JLabel("部门名");
            jTextField1 = new JTextField(20);
            jPanel1.add(jLabel1);
            jPanel1.add(jTextField1);
            jButton1 = new JButton("增加部门");
            jButton2 = new JButton("重置数据");
            AddDeptDialogClick addDeptDialogClick = new AddDeptDialogClick();
            jButton1.addActionListener(addDeptDialogClick);
            jButton2.addActionListener(addDeptDialogClick);

            jPanel2.add(jButton1);
            jPanel2.add(jButton2);

            this.add(jPanel1);
            this.add(jPanel2);

            this.setTitle("增加部门");
            this.setSize(400, 500);
            this.setLocationRelativeTo(null);
            this.setModal(true);
        }

        private class AddDeptDialogClick implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == jButton1) {
                    //System.out.println("增加部门11");
                    String deptName = jTextField1.getText().trim();
                    if (!(deptName.length() >= 1 && deptName.length() <= 10)) {
                        JOptionPane.showMessageDialog(jPanel2, "部门名必须再1到10个字符之间", "警告", JOptionPane.WARNING_MESSAGE);
                        return;
                    }
                    DeptDao deptDao = new DeptDao();
                    if (deptDao.isDeptNameExists(deptName)) {
                        JOptionPane.showMessageDialog(jPanel2, "部门已存在", "警告", JOptionPane.WARNING_MESSAGE);
                        return;
                    }
                    int effect = deptDao.addDept(new Dept(null, deptName));
                    if (effect <= 0) {
                        JOptionPane.showMessageDialog(jPanel2, "添加失败", "警告", JOptionPane.WARNING_MESSAGE);
                        return;
                    }
                    addDeptDialog.setVisible(false);
                    jTable.setModel(new DeptTableModel());
                    clear();
                } else if (e.getSource() == jButton2) {
                    System.out.println("重置数据");
                    clear();
                }
            }

            private void clear() {
                jTextField1.setText("");
            }
        }
    }

    private class UpdateDialog extends JDialog {
        private JPanel jPanel1;
        private JPanel jPanel2;
        private JLabel jLabel1;
        private JTextField jTextField1;
        private JButton jButton1;
        private JButton jButton2;
        private Dept dept; //回显和重置数据

        public UpdateDialog() {
            this.setLayout(new GridLayout(2, 1));
            jPanel1 = new JPanel();
            jPanel2 = new JPanel();
            jLabel1 = new JLabel("部门名");
            jTextField1 = new JTextField(20);
            jButton1 = new JButton("确认修改");
            jButton2 = new JButton("重置数据");
            UpdateDialogClick updateDialogClick = new UpdateDialogClick();
            jButton1.addActionListener(updateDialogClick);
            jButton2.addActionListener(updateDialogClick);

            jPanel1.add(jLabel1);
            jPanel1.add(jTextField1);
            jPanel2.add(jButton1);
            jPanel2.add(jButton2);

            this.add(jPanel1);
            this.add(jPanel2);

            this.setSize(400, 500);
            this.setLocationRelativeTo(null);
            this.setModal(true);
        }

        private class UpdateDialogClick implements ActionListener{

            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource() == jButton1){
                    System.out.println("确认修改");
                    String deptName = jTextField1.getText();
                    if (deptName.length() <= 0 && deptName.length() > 8){
                        JOptionPane.showMessageDialog(jPanel2, "部门名必须大于1并且小于8", "警告", JOptionPane.WARNING_MESSAGE);
                        return;
                    }
                    DeptDao deptDao = new DeptDao();
                    if (deptDao.isDeptNameExists(deptName)){
                        JOptionPane.showMessageDialog(jPanel2, "部门已经存在，无法修改", "警告", JOptionPane.WARNING_MESSAGE);
                        return;
                    }
                    int effect = deptDao.updateDept(new Dept(dept.getDeptId(), deptName));
                    if (effect <= 0 ){
                        JOptionPane.showMessageDialog(jPanel2, "修改失败", "警告", JOptionPane.WARNING_MESSAGE);
                        return;
                    }
                    JOptionPane.showMessageDialog(jPanel2, "修改成功", "信息", JOptionPane.INFORMATION_MESSAGE);
                    updateDialog.setVisible(false);
                    jTable.setModel(new DeptTableModel());
                    clear();
                } else if (e.getSource() == jButton2) {
                    //System.out.println("重置数据");
                    clear();
                }
            }
            public void clear(){
//                jTextField1.setText(oneRow.get(1));
                jTextField1.setText(dept.getDeptName());
            }
        }
//        public void showDialog(Vector<String> oneRow){
//            this.oneRow = oneRow;
//            this.setTitle("正在修改" + oneRow.get(1) + "部门");
//            jTextField1.setText(oneRow.get(1));
//            this.setVisible(true);
//        }

        public void showDialog(Dept dept){
            this.dept = dept;
            this.setTitle("正在修改" + dept.getDeptId() + "部门");
            jTextField1.setText(dept.getDeptName());
            this.setVisible(true);
        }
    }

    public void refresh(){
        this.jTable.setModel(new DeptTableModel());
    }


}
