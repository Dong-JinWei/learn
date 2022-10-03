package day0407;

import javax.swing.*;
import java.util.Vector;

public class MyFrame5 extends JFrame {
    private JPanel jPanel; // 面板
    private JComboBox<String> jComboBox; //下拉列表

    public MyFrame5() {
        jPanel = new JPanel();
        //准备下拉列表的数据
        Vector<String> vector = new Vector<>();
        vector.add("研发部");
        vector.add("财务部");
        vector.add("市场部");
        jComboBox = new JComboBox<>(vector);
        jPanel.add(jComboBox);
        //再把面板放到窗口中
        this.add(jPanel);
        this.setTitle("测试面板");
        this.setSize(800, 600);
        this.setLocationRelativeTo(null);
        this.setVisible(true);


        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
