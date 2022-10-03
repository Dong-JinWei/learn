package com.dowei.librarysys.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainView extends JFrame {
    private JMenuBar jMenuBar;
    private JMenu jMenu1, jMenu2, jMenu3;
    private JMenuItem jMenuItem1, jMenuItem2, jMenuItem3;
    private BookPanel bookPanel;
    private TypePanel typePanel;
    private AuthorPanel authorPanel;
    private JPanel jPanel;

    public MainView(){
        jMenuBar = new JMenuBar();
        jMenu1 = new JMenu("书籍");
        jMenu2 = new JMenu("作者");
        jMenu3 = new JMenu("类型");
        jMenuItem1 = new JMenuItem("书籍管理");
        jMenuItem2 = new JMenuItem("作者管理");
        jMenuItem3 = new JMenuItem("类型管理");
        jMenuItem1.addActionListener(new MainViewClick());
        jMenuItem2.addActionListener(new MainViewClick());
        jMenuItem3.addActionListener(new MainViewClick());
        bookPanel = new BookPanel();
        typePanel = new TypePanel();
        authorPanel = new AuthorPanel();
        jPanel = new JPanel();
        jPanel.add(bookPanel);
        this.add(jPanel);
        jMenu1.add(jMenuItem1);
        jMenu2.add(jMenuItem2);
        jMenu3.add(jMenuItem3);
        jMenuBar.add(jMenu1);
        jMenuBar.add(jMenu2);
        jMenuBar.add(jMenu3);

        this.add(jMenuBar, BorderLayout.NORTH);
        this.setTitle("Dxx图书馆里系统");
        this.setSize(800, 600);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public class MainViewClick implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            jPanel.removeAll();
            if (e.getSource() == jMenuItem1){
                bookPanel = new BookPanel();
                jPanel.add(bookPanel);
            }else if(e.getSource() == jMenuItem2){
                authorPanel = new AuthorPanel();
                jPanel.add(authorPanel);
            }else if (e.getSource() == jMenuItem3){
                typePanel = new TypePanel();
                jPanel.add(typePanel);
            }
            jPanel.updateUI();

        }
    }
}
