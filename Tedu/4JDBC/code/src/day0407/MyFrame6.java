package day0407;

import day0406.B;

import javax.swing.*;
import java.time.chrono.JapaneseChronology;
import java.util.Vector;

public class MyFrame6 extends JFrame {
    private JPanel jPanel; // 面板
    private JCheckBox jCheckBox1; //复选框，一次可以选多个
    private JCheckBox jCheckBox2;
    private JCheckBox jCheckBox3;

    private JRadioButton jRadioButton1; //单选框，一次只能选一个
    private JRadioButton jRadioButton2;
    // 单选按钮默认都能被选中，需要把属于一组的按钮放到ButtonGroup对象中
    private ButtonGroup buttonGroup;

    public MyFrame6() {
        jPanel = new JPanel();
        jCheckBox1 = new JCheckBox("羽毛球");
        jCheckBox2 = new JCheckBox("篮球");
        jCheckBox3 = new JCheckBox("足球");
        buttonGroup = new ButtonGroup();
        jRadioButton1 = new JRadioButton("男");
        jRadioButton2 = new JRadioButton("女");
        jPanel.add(jCheckBox1);
        jPanel.add(jCheckBox2);
        jPanel.add(jCheckBox3);

        buttonGroup.add(jRadioButton1);
        buttonGroup.add(jRadioButton2);

        jPanel.add(jRadioButton1);
        jPanel.add(jRadioButton2);
        //再把面板放到窗口中
        this.add(jPanel);
        this.setTitle("测试面板");
        this.setSize(800, 600);
        this.setLocationRelativeTo(null);
        this.setVisible(true);


        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
