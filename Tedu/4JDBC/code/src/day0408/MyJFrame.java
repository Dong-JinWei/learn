package day0408;

import javax.swing.*;
import java.awt.*;

public class MyJFrame extends JFrame {

    //菜单条
    private JMenuBar jMenuBar;
    //菜单
    private JMenu jMenu1, jMenu2, jMenu3;
    //菜单项
    private JMenuItem jMenuItem11, jMenuItem12, jMenuItem13;
    private JMenuItem jMenuItem21, jMenuItem22, jMenuItem23;
    private JMenuItem jMenuItem31, jMenuItem32, jMenuItem33;

    public MyJFrame() {
        //创建相关的对象
        jMenuBar = new JMenuBar();

        jMenu1 = new JMenu("文件");
        jMenu2 = new JMenu("编辑");
        jMenu3 = new JMenu("查看");

        jMenuItem11 = new JMenuItem("新建");
        jMenuItem12 = new JMenuItem("新窗口");
        jMenuItem13 = new JMenuItem("打开");

        jMenuItem21 = new JMenuItem("撤销");
        jMenuItem22 = new JMenuItem("复制");
        jMenuItem23 = new JMenuItem("粘贴");

        jMenuItem31 = new JMenuItem("缩放");
        jMenuItem32 = new JMenuItem("状态栏");
        jMenuItem33 = new JMenuItem("自动换行");

        //把菜单项放到菜单中
        jMenu1.add(jMenuItem11);
        jMenu1.add(jMenuItem12);
        jMenu1.add(jMenuItem13);
        jMenu2.add(jMenuItem21);
        jMenu2.add(jMenuItem22);
        jMenu2.add(jMenuItem23);
        jMenu3.add(jMenuItem31);
        jMenu3.add(jMenuItem32);
        jMenu3.add(jMenuItem33);

        //把菜单放到菜单条中
        jMenuBar.add(jMenu1);
        jMenuBar.add(jMenu2);
        jMenuBar.add(jMenu3);

        //把菜单条放到窗体中
        this.add(jMenuBar, BorderLayout.NORTH);

        this.setTitle("测试菜单");
        this.setSize(800, 600);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
