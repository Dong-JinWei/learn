package com.dowei.empsys.view;

import com.dowei.empsys.dao.EmpDao;
import com.dowei.empsys.entity.Emp;

import javax.swing.table.AbstractTableModel;
import java.util.List;
import java.util.StringTokenizer;
import java.util.Vector;

public class EmpTableModel extends AbstractTableModel {

    private Vector<String> columnNames;
    private Vector<Vector<String>> rowData;

    public Vector<Vector<String>> getRowData() {
        return rowData;
    }

    public EmpTableModel() {
        columnNames = new Vector<>();
        rowData = new Vector<>();
        columnNames.add("员工编号");
        columnNames.add("员工姓名");
        columnNames.add("员工性别");
        columnNames.add("员工工资");
        columnNames.add("部门编号");
        columnNames.add("部门名称");

        EmpDao empDao = new EmpDao();
        List<Emp> allEmp = empDao.getAllEmp();
        for (Emp emp : allEmp) {
            Vector<String> row = new Vector<>();
            row.add(emp.getEmpId() + "");
            row.add(emp.getEmpName());
            row.add(emp.getEmpGender());
            row.add(emp.getEmpSalary() + "");
            row.add(emp.getDept().getDeptId() + "");
            row.add(emp.getDept().getDeptName());
            rowData.add(row);
        }

    }

    @Override
    public int getRowCount() {
        return rowData.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return rowData.get(rowIndex).get(columnIndex);
    }

    @Override
    public String getColumnName(int column) {
        return columnNames.get(column);
    }


}
