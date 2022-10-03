package com.dowei.empsys.view;

import com.dowei.empsys.dao.DeptDao;
import com.dowei.empsys.dao.EmpDao;
import com.dowei.empsys.entity.Dept;
import com.dowei.empsys.entity.Emp;
import com.dowei.empsys.utils.MyUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;

public class EmpPanel extends JPanel {
    //准备三个面板
    private JPanel jPanel1, jPanel2, jPanel3;
    private JLabel jLabel;
    private JTable jTable;//表格
    private JScrollPane jScrollPane;
    private JButton jButton1, jButton2, jButton3;
    private AddEmpDialog addEmpDialog;
    private UpdateEmpDialog updateEmpDialog;

    public EmpPanel() {
        updateEmpDialog = new UpdateEmpDialog();
        addEmpDialog = new AddEmpDialog();
        //设置布局：边框布局
        this.setLayout(new BorderLayout());
        jPanel1 = new JPanel(); //放文字
        //存放表格的面板
        jPanel2 = new JPanel();
        //存放按钮的面板
        jPanel3 = new JPanel();//放按钮

        jLabel = new JLabel("员工信息管理");

        jTable = new JTable(new EmpTableModel());
        jScrollPane = new JScrollPane(jTable);

        jButton1 = new JButton("增加员工");
        jButton2 = new JButton("删除员工");
        jButton3 = new JButton("修改员工");

        EmpPanelClick empPanelClick = new EmpPanelClick();
        jButton1.addActionListener(empPanelClick);
        jButton2.addActionListener(empPanelClick);
        jButton3.addActionListener(empPanelClick);

        jPanel1.add(jLabel);
        jPanel2.add(jScrollPane);
        jPanel3.add(jButton1);
        jPanel3.add(jButton2);
        jPanel3.add(jButton3);
        this.add(jPanel1, BorderLayout.NORTH);
        this.add(jPanel2, BorderLayout.CENTER);
        this.add(jPanel3, BorderLayout.SOUTH);
    }

    private class EmpPanelClick implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == jButton1) {
                //System.out.println("增加员工");
                addEmpDialog.setVisible(true);

            } else if (e.getSource() == jButton2) {
                //System.out.println("删除员工");
                int[] rows = jTable.getSelectedRows();
                if (rows.length < 0) {
                    JOptionPane.showMessageDialog(jPanel2, "请选择一行", "警告", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                int choose = JOptionPane.showConfirmDialog(jPanel2, "确认是否删除");
                if (choose != 0){
                    return;
                }
                int effect = -1;
                EmpDao empDao = new EmpDao();
                EmpTableModel empTableModel = new EmpTableModel();
                Vector<Vector<String>> rowData = empTableModel.getRowData();
                for (int row : rows) {
                    effect = empDao.deleteEmp(Integer.parseInt(rowData.get(row).get(0)));
                    if (effect <= 0) {
                        JOptionPane.showMessageDialog(jPanel2, "删除第" + (row + 1) + "行失败", "警告", JOptionPane.WARNING_MESSAGE);
                        return;
                    }
                }
                JOptionPane.showMessageDialog(jPanel2, "删除成功", "提示", JOptionPane.INFORMATION_MESSAGE);
                jTable.setModel(new EmpTableModel());
            } else if (e.getSource() == jButton3) {
                System.out.println("修改员工");
                int rowNum = jTable.getSelectedRow();
                if (rowNum < 0) {
                    JOptionPane.showMessageDialog(jPanel2, "请选择一行", "警告", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                EmpTableModel empTableModel = new EmpTableModel();
                Vector<Vector<String>> rowData = empTableModel.getRowData();
                Vector<String> oneRow = rowData.get(rowNum);
                Emp emp = new Emp(Integer.parseInt(oneRow.get(0)), new Dept(Integer.parseInt(oneRow.get(4)), oneRow.get(5)), oneRow.get(1), oneRow.get(2), Double.parseDouble(oneRow.get(3)));
                updateEmpDialog.showDialog(emp);
            }
        }
    }

    private class AddEmpDialog extends JDialog {
        private JPanel jPanel1, jPanel2, jPanel3, jPanel4, jPanel5;
        private JLabel jLabel1, jLabel2, jLabel3, jLabel4;
        private JTextField jTextField1, jTextField3;
        private JButton jButton1, jButton2;

        private JRadioButton jRadioButtonMan;
        private JRadioButton jRadioButtonWoman;
        private ButtonGroup buttonGroupGender;

        private JComboBox jComboBoxDept;

        public AddEmpDialog() {
            this.setLayout(new GridLayout(5, 1));
            jPanel1 = new JPanel();
            jPanel2 = new JPanel();
            jPanel3 = new JPanel();
            jPanel4 = new JPanel();
            jPanel5 = new JPanel();

            jLabel1 = new JLabel("员工姓名");
            jLabel2 = new JLabel("员工性别");
            jLabel3 = new JLabel("员工工资");
            jLabel4 = new JLabel("部门名称");

            jTextField1 = new JTextField(20);

            //jTextField2 = new JTextField(20);
            jRadioButtonMan = new JRadioButton("男");
            jRadioButtonWoman = new JRadioButton("女");
            buttonGroupGender = new ButtonGroup();
            buttonGroupGender.add(jRadioButtonMan);
            buttonGroupGender.add(jRadioButtonWoman);

            jTextField3 = new JTextField(20);
            //jTextField4 = new JTextField(20);

            DeptDao deptDao = new DeptDao();
            List<Dept> allDept = deptDao.getAllDept();
            Vector<String> deptNames = new Vector<>();
            for (Dept dept : allDept) {
                deptNames.add(dept.getDeptName());
            }
            jComboBoxDept = new JComboBox(deptNames);

            jButton1 = new JButton("增加员工");
            jButton2 = new JButton("重置");

            AddEmpDialogClick addEmpDialogClick = new AddEmpDialogClick();
            jButton1.addActionListener(addEmpDialogClick);
            jButton2.addActionListener(addEmpDialogClick);

            jPanel1.add(jLabel1);
            jPanel1.add(jTextField1);
            jPanel2.add(jLabel2);

            jPanel2.add(jRadioButtonMan);
            jPanel2.add(jRadioButtonWoman);

            jPanel3.add(jLabel3);
            jPanel3.add(jTextField3);
            jPanel4.add(jLabel4);

            jPanel4.add(jComboBoxDept);

            jPanel5.add(jButton1);
            jPanel5.add(jButton2);

            this.add(jPanel1);
            this.add(jPanel2);
            this.add(jPanel3);
            this.add(jPanel4);
            this.add(jPanel5);

            this.setTitle("增加员工");
            this.setSize(400, 500);
            this.setLocationRelativeTo(null);
            this.setModal(true);
            //this.setVisible(true);
        }

        private class AddEmpDialogClick implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (jButton1 == e.getSource()) {
                    //System.out.println("增加员工");
                    String empName = jTextField1.getText();
                    if (!(empName.length() >= 1 && empName.length() <= 10)) {
                        JOptionPane.showMessageDialog(jPanel3, "员工名必须再1到10个字符之间", "警告", JOptionPane.WARNING_MESSAGE);
                        return;
                    }
                    String empGender = null;
                    if (jRadioButtonWoman.isSelected()){
                        empGender = jRadioButtonWoman.getText();
                    }else if (jRadioButtonMan.isSelected()){
                        empGender = jRadioButtonMan.getText();
                    }
                    String empSalaryStr = jTextField3.getText();
                    if (!MyUtils.isDouble(empSalaryStr)) {
                        JOptionPane.showMessageDialog(jPanel3, "工资必须是数字", "警告", JOptionPane.WARNING_MESSAGE);
                        return;
                    }
                    double empSalary = Double.parseDouble(empSalaryStr);
                    if (empSalary < 0) {
                        JOptionPane.showMessageDialog(jPanel3, "工资不能为负数", "警告", JOptionPane.WARNING_MESSAGE);
                        return;
                    }

                    int selectedIndex = jComboBoxDept.getSelectedIndex();
                    String deptName = (String)jComboBoxDept.getItemAt(selectedIndex);

                    DeptDao deptDao = new DeptDao();
                    Dept oneDeptByDeptName = deptDao.getOneDeptByDeptName(deptName);
                    if (oneDeptByDeptName == null) {
                        JOptionPane.showMessageDialog(jPanel3, "不能不存在", "警告", JOptionPane.WARNING_MESSAGE);
                        return;
                    }
                    Integer deptId = oneDeptByDeptName.getDeptId();

                    EmpDao empDao = new EmpDao();
                    int effect = empDao.addEmp(new Emp(null, new Dept(deptId, deptName), empName, empGender, empSalary));
                    if (effect <= 0) {
                        JOptionPane.showMessageDialog(jPanel3, "插入失败", "警告", JOptionPane.WARNING_MESSAGE);
                        return;
                    }
                    JOptionPane.showMessageDialog(jPanel3, "插入成功", "警告", JOptionPane.INFORMATION_MESSAGE);
                    addEmpDialog.setVisible(false);
                    jTable.setModel(new EmpTableModel());
                    clear();

                } else if (jButton2 == e.getSource()) {
                    //System.out.println("重置");
                    clear();
                }
            }

            private void clear() {
                jTextField1.setText("");
                jRadioButtonMan.setSelected(false);
                jRadioButtonWoman.setSelected(false);
                jTextField3.setText("");
                //jTextField4.setText("");
            }
        }



    }

    private class UpdateEmpDialog extends JDialog {
        private JPanel jPanelName;
        private JPanel jPanelGender;
        private JPanel jPanelSalary;
        private JPanel jPanelDept;
        private JPanel jPanelButton;


        private JLabel jLabelName;
        private JLabel jLabelGender;
        private JLabel jLabelSalary;
        private JLabel jLabelDept;

        private JTextField jTextFieldName;
        private JRadioButton jRadioButtonMan;
        private JRadioButton jRadioButtonWoman;
        private ButtonGroup buttonGroupGender;
        private JTextField jTextFieldSalary;
        //private JTextField jTextFieldDept;
        private JComboBox jComboBoxDept;

        private JButton jButtonEnter;
        private JButton jButtonReset;

        private Emp emp;
        private Vector<String> deptNames;

        public UpdateEmpDialog() {
            this.setLayout(new GridLayout(5, 1));

            jPanelName = new JPanel();
            jPanelGender = new JPanel();
            jPanelSalary = new JPanel();
            jPanelDept = new JPanel();
            jPanelButton = new JPanel();

            jLabelName = new JLabel("员工姓名");
            jLabelGender = new JLabel("员工性别");
            jLabelSalary = new JLabel("员工工资");
            jLabelDept = new JLabel("员工部门");

            jTextFieldName = new JTextField(20);
            buttonGroupGender = new ButtonGroup();
            jRadioButtonMan = new JRadioButton("男");
            jRadioButtonWoman = new JRadioButton("女");
            buttonGroupGender.add(jRadioButtonMan);
            buttonGroupGender.add(jRadioButtonWoman);

            jTextFieldSalary = new JTextField(20);

            //部门下拉列表
            DeptDao deptDao = new DeptDao();
            List<Dept> allDept = deptDao.getAllDept();
            deptNames = new Vector<>();
            for(Dept dept : allDept){
                deptNames.add(dept.getDeptName());
            }
            jComboBoxDept = new JComboBox(deptNames);

            jButtonEnter = new JButton("确认修改");
            jButtonReset = new JButton("重置数据");
            UpdateDialogClick updateDialogClick = new UpdateDialogClick();
            jButtonEnter.addActionListener(updateDialogClick);
            jButtonReset.addActionListener(updateDialogClick);


            jPanelName.add(jLabelName);
            jPanelName.add(jTextFieldName);
            jPanelGender.add(jLabelGender);
            jPanelGender.add(jRadioButtonMan);
            jPanelGender.add(jRadioButtonWoman);
            jPanelSalary.add(jLabelSalary);
            jPanelSalary.add(jTextFieldSalary);
            jPanelDept.add(jLabelDept);
            jPanelDept.add(jComboBoxDept);
            jPanelButton.add(jButtonEnter);
            jPanelButton.add(jButtonReset);

            this.add(jPanelName);
            this.add(jPanelGender);
            this.add(jPanelSalary);
            this.add(jPanelDept);
            this.add(jPanelButton);

            this.setTitle("修改用户");
            this.setSize(400, 500);
            this.setLocationRelativeTo(null);
            this.setModal(true);
        }


        //回显
        private void showDialog(Emp emp) {
            this.emp = emp;
            this.setTitle("正在修改 " + emp.getEmpName() + " 员工的数据");
            jTextFieldName.setText(emp.getEmpName());
            String gender = emp.getEmpGender();
            if ("男".equals(gender)) {
                jRadioButtonMan.setSelected(true);
                jRadioButtonWoman.setSelected(false);
            } else if ("女".equals(gender)) {
                jRadioButtonMan.setSelected(false);
                jRadioButtonWoman.setSelected(true);
            }
            jTextFieldSalary.setText(emp.getEmpSalary() + "");

            for(int i = 0; i < deptNames.size(); i++){
                if (deptNames.get(i).equals(emp.getDept().getDeptName())){
                    jComboBoxDept.setSelectedIndex(i);
                }
            }
            //jTextFieldDept.setText(oneRow.get(5));
            this.setVisible(true);
        }

        private class UpdateDialogClick implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == jButtonEnter) {
                    System.out.println("确认修改");
                    String empName = jTextFieldName.getText();
                    if (empName.length() < 1 && empName.length() > 8) {
                        JOptionPane.showMessageDialog(jPanel2, "员工姓名必须再1到8个字符之间", "警告", JOptionPane.WARNING_MESSAGE);
                        return;
                    }

                    String gender = null;
                    if(jRadioButtonMan.isSelected()){
                        gender = jRadioButtonMan.getText();
                    }else if(jRadioButtonWoman.isSelected()){
                        gender = jRadioButtonWoman.getText();
                    }

                    String salaryStr = jTextFieldSalary.getText();
                    if (!MyUtils.isDouble(salaryStr)){
                        JOptionPane.showMessageDialog(jPanel2, "工资必须是数字", "警告", JOptionPane.WARNING_MESSAGE);
                        return;
                    }
                    double salary = Double.parseDouble(salaryStr);

                    int selectedIndex = jComboBoxDept.getSelectedIndex();
                    String deptName = (String)jComboBoxDept.getItemAt(selectedIndex);

//                    System.out.println(deptName);
//                    System.out.println(emp.getDept().getDeptId());

                    EmpDao empDao = new EmpDao();
                    DeptDao deptDao = new DeptDao();
                    Dept oneDeptByDeptName = deptDao.getOneDeptByDeptName(deptName);
                    int effect = empDao.updateEmp(new Emp(emp.getEmpId(), new Dept(oneDeptByDeptName.getDeptId(), deptName), empName, gender, salary));
                    if (effect <= 0){
                        JOptionPane.showMessageDialog(jPanel2, "修改失败", "警告", JOptionPane.WARNING_MESSAGE);
                        return;
                    }
                    JOptionPane.showMessageDialog(jPanel2, "修改成功", "提示", JOptionPane.INFORMATION_MESSAGE);
                    jTable.setModel(new EmpTableModel());
                    updateEmpDialog.setVisible(false);
                    clear();
                } else if (e.getSource() == jButtonReset) {
                    //System.out.println("重置数据");
                    clear();
                }
            }

            private void clear() {
                jTextFieldName.setText(emp.getEmpName());
                String gender = emp.getEmpGender();
                if ("男".equals(gender)) {
                    jRadioButtonMan.setSelected(true);
                    jRadioButtonWoman.setSelected(false);
                } else if ("女".equals(gender)) {
                    jRadioButtonMan.setSelected(false);
                    jRadioButtonWoman.setSelected(true);
                }
                //jTextFieldGender.setText(oneRow.get(2));
                jTextFieldSalary.setText(emp.getEmpSalary() + "");
                //jTextFieldDept.setText(oneRow.get(5));
                for(int i = 0; i < deptNames.size(); i++){
                    if (deptNames.get(i).equals(emp.getDept().getDeptName())){
                        jComboBoxDept.setSelectedIndex(i);
                    }
                }
            }

        }
    }

    public void refresh(){
        this.jTable.setModel(new EmpTableModel());
    }
}