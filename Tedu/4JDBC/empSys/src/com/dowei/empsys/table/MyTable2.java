package com.dowei.empsys.table;

import com.dowei.empsys.dao.UserDao;
import com.dowei.empsys.entity.User;

import javax.swing.*;
import java.util.List;
import java.util.Vector;

public class MyTable2 extends JFrame {
    private JPanel jPanel;
    private JTable jTable;
    private JScrollPane jScrollPane;
    public MyTable2(){
        jPanel = new JPanel();
        //把MyTableModel添加到jTable中，即可自动显示数据
        jTable = new JTable(new MyTableModel());
        jScrollPane = new JScrollPane(jTable);
        jPanel.add(jScrollPane);
        this.add(jPanel);
        this.setTitle("测试表格");
        this.setSize(800, 600);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new MyTable2();
    }
}
