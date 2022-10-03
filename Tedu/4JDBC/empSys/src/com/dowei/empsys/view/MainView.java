package com.dowei.empsys.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainView extends JFrame {
    private JMenuBar jMenuBar;
    private JMenu jMenu1, jMenu2, jMenu3;
    private JMenuItem jMenuItem1, jMenuItem2, jMenuItem3;
    private UserPanel userPanel; // 用户面板
    private EmpPanel empPanel; // 员工面板
    private DeptPanel deptPanel; // 部门面板
    //准备一个大面板，切换以上面板
    private JPanel jPanel;

    public MainView() {
        userPanel = new UserPanel();
        empPanel = new EmpPanel();
        deptPanel = new DeptPanel();
        jPanel = new JPanel();
        this.add(jPanel);

        jMenuBar = new JMenuBar();
        jMenu1 = new JMenu("用户");
        jMenu2 = new JMenu("部门");
        jMenu3 = new JMenu("员工");
        jMenuItem1 = new JMenuItem("用户管理");
        jMenuItem2 = new JMenuItem("部门管理");
        jMenuItem3 = new JMenuItem("员工管理");

        //给菜单项添加事件
        MainViewClick mc = new MainViewClick();
        jMenuItem1.addActionListener(mc);
        jMenuItem2.addActionListener(mc);
        jMenuItem3.addActionListener(mc);
        jMenu1.add(jMenuItem1);
        jMenu2.add(jMenuItem2);
        jMenu3.add(jMenuItem3);
        jMenuBar.add(jMenu1);
        jMenuBar.add(jMenu2);
        jMenuBar.add(jMenu3);

        jPanel.add(userPanel);
        this.add(jMenuBar, BorderLayout.NORTH);

        this.setTitle("Dxx员工管理系统");
        this.setSize(800, 600);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    //创建事件的内部类
    private class MainViewClick implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            //清空之前的界面
            jPanel.removeAll();
            if (jMenuItem1 == e.getSource()){
                //System.out.println("用户面板");
                userPanel.refresh();
                jPanel.add(userPanel);
            }else if (jMenuItem2 == e.getSource()){
                //System.out.println("部门面板");
                deptPanel.refresh();
                jPanel.add(deptPanel);
            }else if (jMenuItem3 == e.getSource()){
                //System.out.println("员工面板");
                empPanel.refresh();
//                EmpPanel empPanel = new EmpPanel();
                jPanel.add(empPanel);

            }
            //每次点击之后刷新界面
            jPanel.updateUI();
        }
    }
}
