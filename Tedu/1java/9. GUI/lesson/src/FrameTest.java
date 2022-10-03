import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class MyFrame extends JFrame{

}
public class FrameTest {
    public static void main(String[] args){
        MyFrame frame = new MyFrame();
        frame.setBounds(200, 100, 1500, 1300);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTextField t1 = new JTextField();
        t1.setBounds(100, 50, 100, 80);
        t1.setText("2");
        t1.setFont(new Font(null, Font.BOLD, 50));
        t1.setHorizontalAlignment(JTextField.CENTER);
        t1.setEnabled(false);
        frame.add(t1);

        JButton button = new JButton();
        button.setText("上");
        button.setBounds(500, 600, 300, 200);
        button.setFont(new Font(null, Font.BOLD, 150));
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //将int类型的二维数组中的数据全部向上移动
                //将int类型二维数组中的数据写入到JTextField类型的二维数组中。
                JOptionPane.showMessageDialog(null, "点击了按钮");
            }
        });
        frame.add(button);

        frame.setVisible(true);
    }
}
