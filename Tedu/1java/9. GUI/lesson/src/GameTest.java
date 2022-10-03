import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Game2048 extends JFrame{
    private JButton left;
    private JButton right;
    private JButton up;
    private JButton down;
    private JTextField[][] text;
    private int[][] num;

    public Game2048(){
        setBounds(200, 100, 1500, 1300);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        left = new JButton();
        left.setText("上");
        left.setBounds(500, 600, 300, 200);
        left.setFont(new Font(null, Font.BOLD, 150));
        left.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //将int类型的二维数组中的数据全部向上移动
                //将int类型二维数组中的数据写入到JTextField类型的二维数组中。
                JOptionPane.showMessageDialog(null, "点击了按钮");
            }
        });
        add(left);

        this.setVisible(true);
    }
}
public class GameTest {
    public static void main(String[] args) {
        Game2048 game2048 = new Game2048();
    }
}
