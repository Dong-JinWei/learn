package com.dowei.empsys.view;

import com.dowei.empsys.dao.UserDao;
import com.dowei.empsys.entity.User;

import javax.swing.table.AbstractTableModel;
import java.util.List;
import java.util.Vector;

public class UserTableModel extends AbstractTableModel {
    Vector<String> columnNames;

    public Vector<Vector<String>> getRowData() {
        return rowData;
    }

    Vector<Vector<String>> rowData;

    public UserTableModel(){
        columnNames = new Vector<>();
        columnNames.add("用户编号");
        columnNames.add("用户名字");
        columnNames.add("用户密码");
        columnNames.add("用户昵称");

        UserDao userDao = new UserDao();
        List<User> allUser = userDao.getAllUser();
        rowData = new Vector<>();
        for(User user: allUser){
            Vector<String> row = new Vector<>();
            row.add("" + user.getUserId());
            row.add(user.getUsername());
            row.add(user.getPassword());
            row.add(user.getNickname());
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
