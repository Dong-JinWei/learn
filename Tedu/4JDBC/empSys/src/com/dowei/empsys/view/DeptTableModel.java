package com.dowei.empsys.view;

import com.dowei.empsys.dao.DeptDao;
import com.dowei.empsys.entity.Dept;

import javax.swing.table.AbstractTableModel;
import java.util.List;
import java.util.Vector;

public class DeptTableModel extends AbstractTableModel {

    private Vector<String> columnNames;
    private Vector<Vector<String>> rowData;


    public Vector<Vector<String>> getRowData() {
        return rowData;
    }

    public DeptTableModel(){
        columnNames = new Vector<>();
        rowData = new Vector<>();
        DeptDao deptDao = new DeptDao();
        columnNames.add("部门编号");
        columnNames.add("部门名称");
        columnNames.add("部门人数");

        List<Dept> allDept = deptDao.getAllDept();
        for(Dept dept : allDept){
            Vector<String> row = new Vector<>();
            row.add("" + dept.getDeptId());
            row.add(dept.getDeptName());
            row.add("" + deptDao.getCountDept(dept.getDeptId()));
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
