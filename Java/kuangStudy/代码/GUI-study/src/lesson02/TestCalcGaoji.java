//package lesson02;
//
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//
////简易计算器
//public class TestCalcGaoji {
//    public static void main(String[] args) {
//        new Calculator().loadFrame();
//    }
//}
//
////计算器类
//class Calculator extends Frame{
//    //属性
//    TextField num1,num2,num3;
//
//    //方法4
//    public void loadFrame(){
//        num1 = new TextField(10);//字符数
//        num2 = new TextField(10);//字符数
//        num3 = new TextField(20);//字符数
//        Label label = new Label("+");
//        Button button = new Button("=");
//
//        button.addActionListener(new MyCalculatorListener(this));
//
//        //布局
//        setLayout(new FlowLayout());
//        add(num1);
//        add(label);
//        add(num2);
//        add(button);
//        add(num3);
//
//        pack();
//        setVisible(true);
//    }
//}
//
////监听器类
//class MyCalculatorListener implements ActionListener{
//
//    //获取计算器这个对象,在一个类整合另一个类
//    Calculator calculator = null;
//    public MyCalculatorListener(Calculator calculator){
//        this.calculator = calculator;
//    }
//    @Override
//    public void actionPerformed(ActionEvent e) {
//        //1.获得加数和被加数
//        //2.将这个值+运算后,放到第三个框
//        //3.清除前两个框
//
//        int n1 = Integer.parseInt(calculator.num1.getText());
//        int n2 = Integer.parseInt(calculator.num2.getText());
//        calculator.num3.setText(""+(n1+n2));
//        calculator.num1.setText("");
//        calculator.num2.setText("");
//
//    }
//}