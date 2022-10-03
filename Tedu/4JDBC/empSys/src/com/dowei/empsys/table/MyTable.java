package com.dowei.empsys.table;

import com.dowei.empsys.dao.UserDao;
import com.dowei.empsys.entity.User;

import javax.swing.*;
import java.util.List;
import java.util.Vector;

public class MyTable extends JFrame {
    private JPanel jPanel;
    private JTable jTable;
    UserDao dao = new UserDao();

    //用于显示表头
    private JScrollPane jScrollPane;
    public MyTable(){

        //准备表格数据
        Vector<String> columnNames = new Vector<>();
        //给几个方济各内容，就有几列
        columnNames.add("用户名");
        columnNames.add("密码");
        columnNames.add("用户昵称");
        List<User> allUser = dao.getAllUser();


        //准备每一行的数据
        //Vector<String> row1 = new Vector<>();
        //row1.add("admin");
        //row1.add("123456");
        //row1.add("管理员");

        //Vector<String> row2 = new Vector<>();
        //row2.add("dowei");
        //row2.add("abc123");
        //row2.add("VIP");

        //Vector<String> row3 = new Vector<>();
        //row3.add("djw");
        //row3.add("abc456");
        //row3.add("普通用户");

        //把以上数据放到一个集合中
        Vector<Vector<String>> rowData = new Vector<>();
        //rowData.add(row1);
        //rowData.add(row2);
        //rowData.add(row3);
        for (User user : allUser) {
            String username = user.getUsername();
            String password = user.getPassword();
            String nickname = user.getNickname();
            Vector<String> row = new Vector<>();
            row.add(username);
            row.add(password);
            row.add(nickname);
            rowData.add(row);
        }


        //把列名和行数放到JTable构造器中
        //第一个参数是行数据，第二个参数是列数据
        //必须把表格方法到JScrollPane这个容器中才会显示表头
        jTable = new JTable(rowData, columnNames);
        jScrollPane = new JScrollPane(jTable);
        jPanel = new JPanel();
        jPanel.add(jScrollPane);
        this.add(jPanel);
        this.setTitle("测试表格");
        this.setSize(800, 600);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new MyTable();
    }
}
