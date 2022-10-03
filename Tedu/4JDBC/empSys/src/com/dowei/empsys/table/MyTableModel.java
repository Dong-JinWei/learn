package com.dowei.empsys.table;

import com.dowei.empsys.dao.UserDao;
import com.dowei.empsys.entity.User;

import javax.swing.table.AbstractTableModel;
import java.util.List;
import java.util.Vector;

public class MyTableModel extends AbstractTableModel {

    //申明表格需要的数据
    private Vector<String> columnNames;
    private Vector<Vector<String>> rowData;

    //创建构造方法初始化表格数据
    public MyTableModel(){
        columnNames = new Vector<> ();
        columnNames.add("用户编号");
        columnNames.add("用户名称");
        columnNames.add("用户密码");
        columnNames.add("用户昵称");

        //准备空的rowData
        rowData = new Vector<>();
        //创建UserDao对象
        UserDao userDao = new UserDao();
        List<User> allUser = userDao.getAllUser();
        for(User user : allUser){
            Vector<String> row = new Vector<>();
            row.add("" + user.getUserId());
            row.add(user.getUsername());
            row.add(user.getPassword());
            row.add(user.getNickname());
            rowData.add(row);
        }
    }
    //创建表格是会自动调用一下三个方法
    //获取行数
    @Override
    public int getRowCount() {
        return rowData.size();
    }

    //获取列数
    @Override
    public int getColumnCount() {
        return columnNames.size();
    }

    //获取值
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return rowData.get(rowIndex).get(columnIndex);
    }

    //获取列名是非抽象方法，默认提供的列名是A, B, C，需要手动来实现吗获取列名的方法

    @Override
    public String getColumnName(int column) {
        return columnNames.get(column);
    }
}
