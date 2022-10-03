# GUI编程

组件：

- 窗口
- 弹窗
- 面板
- 文本框
- 列表
- 按钮
- 图片
- 监听事件
- 鼠标
- 键盘事件

## 1、简介

GUI的核心技术：Swing AWT

	1. 因为不美观
	2. 需要jre环境

为什么我们要学习？

1. 可以写出自己心中的一些小工具
2. 工作时候，也可能需要维护到swing界面，概率极小！
3. 了解MVC架构，了解监听！

## 2、AWT

### 2.1、 AWT介绍

1. 包含了很多类和接口！GUI：图形用户界面编程
2. 元素：窗口，按钮，文本框
3. java.awt包

![image-20210528160801576](C:\Users\26465\AppData\Roaming\Typora\typora-user-images\image-20210528160801576.png)

### 2.2、 组件和容器

#### 2.2.1、 Frame

```java
package lesson01;

import java.awt.*;

//GUI的第一个界面
public class TeatFrame {
    public static void main(String[] args) {
        //Fame
        Frame frame = new Frame("我的第一个Java窗口");
        //需要设置可见性
        frame.setVisible(true);

        //设置窗口大小
        frame.setSize(400,400);

        //设置颜色
        frame.setBackground(new Color(213, 115, 115));

        //弹出初始位置
        frame.setLocation(200,200);
        
        //设置大小固定
        frame.setResizable(false);
    }
}

```

![image-20210528162353034](C:\Users\26465\AppData\Roaming\Typora\typora-user-images\image-20210528162353034.png)



```java
package lesson01;

import java.awt.*;

public class TestFrame2 {
    public static void main(String[] args) {
        //展示多个窗口
        new MyFrame(100,100,200,200,Color.cyan);
        new MyFrame(300,100,200,200,Color.yellow);
        new MyFrame(100,300,200,200,Color.green);
        new MyFrame(300,300,200,200,Color.magenta);

    }
}

class MyFrame extends Frame {
    static int id = 0; //可能存在多个窗口

    public MyFrame(int x, int y, int w, int h, Color color){
        super("Myfrmae+"+(++id));
        setBackground(color);
        setVisible(true);
        setBounds(x,y,w,h);
    }
}

```

![image-20210528163135959](C:\Users\26465\AppData\Roaming\Typora\typora-user-images\image-20210528163135959.png)

#### 2.2.2、面板Panel

```java
package lesson01;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

//Panel,可以看成是一个空间,不能单独存在
public class TestPanel {
    public static void main(String[] args) {
        Frame frame = new Frame();
        //布局的概念
        Panel panel = new Panel();

        //设置布局
        frame.setLayout(null);

        //坐标
        frame.setBounds(300,300,500,500);
        frame.setBackground(new Color(40,161,35));

        //panel设置坐标,相对与frame
        panel.setBounds(50,50,100,100);
        panel.setBackground(new Color(236, 99, 52));

        //frame.add(panel)
        frame.add(panel);

        frame.setVisible(true);

        //监听事件,监听窗口关闭事件 System.exit(0)
        //适配器模式:
        frame.addWindowListener(new WindowAdapter(){
            //窗口点击关闭的时候需要做的事情
            public void windowClosing(WindowEvent e){
                //程序结束
                System.exit(0);
            }
        });
    }

}

```



![image-20210528165008099](C:\Users\26465\AppData\Roaming\Typora\typora-user-images\image-20210528165008099.png)

### 2.3、布局管理器

- 流式布局

  ```jav
  package lesson01;
  
  import java.awt.*;
  
  public class TestFlowLayout {
      public static void main(String[] args) {
          Frame frame = new Frame();
  
          //组件-按钮
          Button button1 = new Button("button1");
          Button button2 = new Button("button2");
          Button button3 = new Button("button3");
  
          //设置为流式布局
          //frame.setLayout(new FlowLayout());  //按钮居中
          //frame.setLayout(new FlowLayout(FlowLayout.LEFT));  //按钮靠左
          frame.setLayout(new FlowLayout(FlowLayout.RIGHT));   //按钮靠右
  
          frame.setVisible(true);
          frame.setSize(200,200);
  
          //添加按钮
          frame.add(button1);
          frame.add(button2);
          frame.add(button3);
      }
  }
  
  ```

  

- 东西南北中

  ```java
  package lesson01;
  
  import java.awt.*;
  
  public class TestBorderLayout {
      public static void main(String[] args) {
          Frame frame = new Frame("TestBorderLayout");
  
          Button east = new Button("East");
          Button west = new Button("West");
          Button south = new Button("South");
          Button north = new Button("North");
          Button enter = new Button("Center");
  
  
          frame.add(east,BorderLayout.EAST);
          frame.add(west,BorderLayout.WEST);
          frame.add(south,BorderLayout.SOUTH);
          frame.add(north,BorderLayout.NORTH);
          frame.add(enter,BorderLayout.CENTER);
  
          frame.setVisible(true);
  
          frame.setSize(600,600);
  
      }
  }
  
  ```

  

- 表格布局

  ```java
  package lesson01;
  
  import java.awt.*;
  
  public class TestGridLayout {
      public static void main(String[] args) {
          Frame frame = new Frame("TestBorderLayout");
  
          Button btn1 = new Button("btn1");
          Button btn2 = new Button("btn2");
          Button btn3 = new Button("btn3");
          Button btn4 = new Button("btn4");
          Button btn5 = new Button("btn5");
          Button btn6 = new Button("btn6");
  
          frame.setLayout(new GridLayout(3,2));
  
          frame.add(btn1);
          frame.add(btn2);
          frame.add(btn3);
          frame.add(btn4);
          frame.add(btn5);
          frame.add(btn6);
  
          frame.pack(); //java函数,自动设置大小
          frame.setVisible(true);
  
      }
  }
  
  ```

  





### 2.4、作业练习

![image-20210528215921323](C:\Users\26465\AppData\Roaming\Typora\typora-user-images\image-20210528215921323.png)

```java
package lesson01;

import javax.swing.border.Border;
import java.awt.*;

public class Homework {
    public static void main(String[] args) {
        Frame frame = new Frame();
        Panel panel1 = new Panel();
        Panel panel2 = new Panel();
        Panel panel3 = new Panel();
        Panel panel4 = new Panel();

        frame.setLayout(null);

        Button button1 = new Button("Button1");
        Button button2 = new Button("Button2");
        Button button3 = new Button("Button3");
        Button button4 = new Button("Button4");
        Button button5 = new Button("Button5");
        Button button6 = new Button("Button6");
        Button button7 = new Button("Button7");
        Button button8 = new Button("Button8");
        Button button9 = new Button("Button9");
        Button button10 = new Button("Button10");

        frame.setVisible(true);
        frame.setSize(600,400);

        //左边两个
        panel1.setBounds(1,1,100,400);
        frame.add(panel1);
        panel1.setLayout(new GridLayout(2,1));
        panel1.add(button1);
        panel1.add(button2);

        //中上两个
        panel2.setBounds(101,1,400,200);
        frame.add(panel2);
        panel2.setLayout(new GridLayout(2,1));
        panel2.add(button3);
        panel2.add(button4);

        //中下四个
        panel3.setBounds(102,202,400,200);
        frame.add(panel3);
        panel3.setLayout(new GridLayout(2,2));
        panel3.add(button5);
        panel3.add(button6);
        panel3.add(button7);
        panel3.add(button8);

        //左边两个
        panel4.setBounds(503,1,101,400);
        frame.add(panel4);
        panel4.setBackground(Color.orange);
        panel4.setLayout(new GridLayout(2,1));
        panel4.add(button9);
        panel4.add(button10);

    }
}

```

![image-20210529081721009](C:\Users\26465\AppData\Roaming\Typora\typora-user-images\image-20210529081721009.png)

```java
package lesson01;

import javafx.scene.layout.Border;
import javafx.scene.layout.Pane;

import java.awt.*;

public class Teacher {
    public static void main(String[] args) {
        Frame frame = new Frame();

        Panel p1 = new Panel(new BorderLayout());
        Panel p2 = new Panel(new GridLayout(2,1));
        Panel p3 = new Panel(new BorderLayout());
        Panel p4 = new Panel(new GridLayout(2,2));


        frame.setVisible(true);
        frame.setSize(400,300);
        frame.setLayout(new GridLayout(2,1));

        p1.add(new Button("1"),BorderLayout.EAST);
        p1.add(new Button("2"),BorderLayout.WEST);
        p2.add(new Button("3"));
        p2.add(new Button("4"));
        p1.add(p2,BorderLayout.CENTER);

        p3.add(new Button("5"),BorderLayout.EAST);
        p3.add(new Button("6"),BorderLayout.WEST);
        for (int i = 7; i < 11; i++) {
            p4.add(new Button(""+i));
        }
        p3.add(p4,BorderLayout.CENTER);

        frame.add(p1);
        frame.add(p3);
    }
```

### 2.5、总结

1. Frame是一个顶级窗口
2. Panel无法单独显示，必须添加到容器中
3. 布局管理器
   1. 流式
   2. 东西南北中
   3. 表格
4. 大小，定位，背景颜色，可见性，监听

### 2.6、事件监听

事件监听：当某个事情发生的时候，干什么？

```java
package lesson02;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TeatActionEvent {
    public static void main(String[] args) {
        //按下按钮，触发事件
        Frame frame = new Frame();
        Button button = new Button();

        //因为,addActionListener()需要一个ActionListener,所以我们要构造一个 ActionListener
        MyActionListener myActionListener = new MyActionListener();
        button.addActionListener(myActionListener);

        frame.add(button,BorderLayout.CENTER);
        frame.pack();
        frame.setVisible(true);

        windowClose(frame); //关闭窗口


    }

    //关闭窗体的事件
    private static void windowClose(Frame frame){
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

}

class MyActionListener implements ActionListener{
    public void actionPerformed(ActionEvent e){
        System.out.println("AAA");
    }
}

```

多个按钮共享一个事件

```java
package lesson02;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TestActionTwo {
    public static void main(String[] args) {
        //两个按钮,实现同一个监听
        //开始,停止
        Frame frame = new Frame("开始停止");
        Button button1 = new Button("start");
        Button button2 = new Button("stop");

        button2.setActionCommand("button2-stop");

        MyMonitor myMonitor = new MyMonitor();
        button1.addActionListener(myMonitor);
        button2.addActionListener(myMonitor);

        frame.add(button1,BorderLayout.NORTH);
        frame.add(button2,BorderLayout.SOUTH);
        frame.pack();
        frame.setVisible(true);
    }
}

class MyMonitor implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("按钮被点击了msg:"+e.getActionCommand());
        e.getActionCommand();

    }
}
```

### 2.7、输入框TextField监听

```java
package lesson02;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLOutput;

public class TestText01 {
    public static void main(String[] args) {
        //启动!
        new MyFrame();
    }
}
class MyFrame extends Frame{
    public MyFrame(){
        TextField textField = new TextField();
        add(textField);

        //监听这个文本框输入的文字
        MyActionListener2 actionListener2 = new MyActionListener2();
        //按下回车,就会触发输入框事件
        textField.addActionListener(actionListener2);

        //设置替换编码
        textField.setEchoChar('*');

        pack();
        setVisible(true);
    }
}

class MyActionListener2 implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        TextField filed = (TextField) e.getSource();//获得一些资源,返回的一个对象
        System.out.println(filed.getText());//获取输入框中的文本
        filed.setText("");
    }
}
```

### 2.8、简易计算器，组合+内部类回顾复习

oop原则：组合大于继承

```java
package lesson02;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//简易计算器
public class TestCalc {
    public static void main(String[] args) {
        new Calculator();

    }
}

//计算器类
class Calculator extends Frame{
    public Calculator(){
        //3个文本框
        TextField num1 = new TextField(10);//字符数
        TextField num2 = new TextField(10);//字符数
        TextField num3 = new TextField(20);//字符数

        //1个按钮
        Button button = new Button("=");
        button.addActionListener(new MyCalculatorListener(num1,num2,num3));

        //1个标签
        Label label = new Label("+");

        //布局
        setLayout(new FlowLayout());

        add(num1);
        add(label);
        add(num2);
        add(button);
        add(num3);

        pack();
        setVisible(true);

    }
}

//监听器类
class MyCalculatorListener implements ActionListener{

    //获取三个变量
    private TextField num1,num2,num3;
    public MyCalculatorListener(TextField num1,TextField num2,TextField num3){
        this.num1 = num1;
        this.num2 = num2;
        this.num3 = num3;


    }
    @Override
    public void actionPerformed(ActionEvent e) {
        //1.获得加数和被加数
        int n1 = Integer.parseInt(num1.getText());
        int n2 = Integer.parseInt(num2.getText());

        //2.将这个值+运算后,放到第三个框
        num3.setText(""+(n1+n2));

        //3.清除前两个框
        num1.setText("");
        num2.setText("");

    }
}
```

使用组合编写

```java
package lesson02;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//简易计算器
public class TestCalcGaoji {
    public static void main(String[] args) {
        new Calculator().loadFrame();
    }
}

//计算器类
class Calculator extends Frame{
    //属性
    TextField num1,num2,num3;

    //方法4
    public void loadFrame(){
        num1 = new TextField(10);//字符数
        num2 = new TextField(10);//字符数
        num3 = new TextField(20);//字符数
        Label label = new Label("+");
        Button button = new Button("=");

        button.addActionListener(new MyCalculatorListener(this));

        //布局
        setLayout(new FlowLayout());
        add(num1);
        add(label);
        add(num2);
        add(button);
        add(num3);

        pack();
        setVisible(true);
    }
}

//监听器类
class MyCalculatorListener implements ActionListener{

    //获取计算器这个对象,在一个类整合另一个类
    Calculator calculator = null;
    public MyCalculatorListener(Calculator calculator){
        this.calculator = calculator;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        //1.获得加数和被加数
        //2.将这个值+运算后,放到第三个框
        //3.清除前两个框

        int n1 = Integer.parseInt(calculator.num1.getText());
        int n2 = Integer.parseInt(calculator.num2.getText());
        calculator.num3.setText(""+(n1+n2));
        calculator.num1.setText("");
        calculator.num2.setText("");

    }
}
```

完全改造为面向对象

内部类：

- 更好的包装

```
package lesson02;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//简易计算器
public class TestCalcNeiBulei {
    public static void main(String[] args) {
        new Calculator().loadFrame();
    }
}

//计算器类
class Calculator extends Frame{
    //属性
    TextField num1,num2,num3;

    //方法4
    public void loadFrame(){
        num1 = new TextField(10);//字符数
        num2 = new TextField(10);//字符数
        num3 = new TextField(20);//字符数
        Label label = new Label("+");
        Button button = new Button("=");
        button.addActionListener(new MyCalculatorListener());

        //布局
        setLayout(new FlowLayout());
        add(num1);
        add(label);
        add(num2);
        add(button);
        add(num3);

        pack();
        setVisible(true);
    }
    private class MyCalculatorListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            //1.获得加数和被加数
            //2.将这个值+运算后,放到第三个框
            //3.清除前两个框

            int n1 = Integer.parseInt(num1.getText());
            int n2 = Integer.parseInt(num2.getText());
            num3.setText(""+(n1+n2));
            num1.setText("");
            num2.setText("");

        }
    }
}
```

2.9 画笔

```java
package lesson03;

import java.awt.*;

public class TestPaint {
    public static void main(String[] args) {
        new MyPaint().loadFrame();
    }
}

class MyPaint extends Frame{

    public void loadFrame(){
        setVisible(true);
        setBounds(200,200,600,600);
    }
    public void paint(Graphics g){
        //画笔，需要有颜色，可以画画
        g.setColor(Color.red);
        g.fillOval(200,200,100,100);//实心

        g.setColor(Color.gray);
        g.drawRect(100,100,100,100);//空心

        //养成习惯，用完画笔，将他还原到最初的颜色
    }
}
```

### 2.9 鼠标监听

目的：实现鼠标画画

![image-20210529184204109](C:\Users\26465\AppData\Roaming\Typora\typora-user-images\image-20210529184204109.png)

```java
package lesson03;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Iterator;

//测试鼠标监听事件
public class TestMouseListener {
    public static void main(String[] args) {
        new MyFrame("画图");

    }
}

//自己的类
class MyFrame extends Frame {
    //画画需要画笔，需要监听鼠标当前的位置，需要集合来存储这个点
    ArrayList points;

    public MyFrame(String title){
        super(title);
        setBounds(200,200,600,600);
        //存鼠标的点
        points = new ArrayList();


        //鼠标监听器,正对这个窗口
        this.addMouseListener(new MyMouseListener());

        setVisible(true);
    }
    public void paint(Graphics g){
        //画画，监听鼠标事件
        Iterator iterator = points.iterator();
        while (iterator.hasNext()){
            Point point = (Point)iterator.next();
            g.setColor(Color.orange);
            g.fillOval(point.x,point.y,10,10);
        }
    }

    //添加一个点到界面上
    public void addPaint(Point point){
        points.add(point);
    }


    //适配器模式
    private class MyMouseListener extends MouseAdapter{
        //鼠标 按下,弹起,按住不放
        public void mousePressed(MouseEvent e){
            MyFrame frame = (MyFrame)e.getSource();
            //点击的时候,界面上就会产生一个点
            //这个点就是鼠标的点
            frame.addPaint(new Point(e.getX(),e.getY()));

            //每次点击鼠标都需要重新话一遍
            frame.repaint();
        }

    }
}
```



### 2.10 窗口监听

```java
package lesson03;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import static com.sun.glass.ui.Cursor.setVisible;

public class TestWindow {
    public static void main(String[] args) {
        new WindowFrame();
    }
}

class WindowFrame extends Frame {
    public WindowFrame() {
            setBackground(Color.blue);
            setBounds(100,100,200,300);
            setVisible(true);
            //addWindowListener(new MyWindowListener());

            this.addWindowListener(
                    //匿名内部类
                    new WindowAdapter() {
                        public void windowOpened(WindowEvent e){
                            System.out.println("windowOpened");
                        }
                        //关闭窗口
                        public void windowClosing(WindowEvent e){
                            System.out.println("windowClosing");
                            System.exit(0);
                        }
                        public void windowClosed(WindowEvent e){
                            System.out.println("windowClosed");
                        }
                        //激活窗户
                        public void windowActivated(WindowEvent e){
                            WindowFrame source =(WindowFrame) e.getSource();
                            source.setTitle("被激活了");
                            System.out.println("windowActivated");
                        }
                    }
            );
        }
}
```



### 2.11 键盘监听

```java
package lesson03;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.FileReader;

//键
public class TestKeyListener {
    public static void main(String[] args) {
        new KeyFrame();

    }
}

class KeyFrame extends Frame {
    public KeyFrame(){
        setBounds(1,2,300,400);
        setVisible(true);

        this.addKeyListener(new KeyAdapter() {
            //键盘按下
            @Override
            public void keyPressed(KeyEvent e) {
                //获得键盘下的一个键是哪一个,当前的码
                int keyCode = e.getKeyCode();
                System.out.println(keyCode);
                if (keyCode == KeyEvent.VK_UP){
                    System.out.println("你按下了上键");
                }
                //根据按下不同操作,产生不同结果
            }
        });
    }
}
```

## 2、Swing

### 3.1、 窗口，面板

```java
package lesson04;

import javax.swing.*;
import java.awt.*;

public class JFrameDemo {

    //init();初始化
    public void init(){
        JFrame jf = new JFrame("这是一个JFrame窗口");
        jf.setVisible(true);
        jf.setBounds(200,200,200,200);
        jf.setBackground(Color.GRAY);
        
        //设置文字label
        JLabel lable = new JLabel("欢迎来到JAVA");
        jf.add(lable);

        //容器实例化



        //关闭事件
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
    }

    public static void main(String[] args) {
        new JFrameDemo().init();

    }//建立一个窗口

}
```

设置居中

```java
package lesson04;

import javax.swing.*;
import java.awt.*;

public class JFrameDemo02 {
    public static void main(String[] args) {
        new  MyJFrame2().init();
    }
}

class MyJFrame2 extends JFrame {
    public void init(){
        this.setBounds(100,100,500,500);
        this.setVisible(true);

        //设置文字label
        JLabel lable = new JLabel("欢迎来到JAVA");
        this.add(lable);

        //让文本居中
        lable.setHorizontalAlignment(SwingConstants.CENTER);

        Container container = this.getContentPane();
        container.setBackground(Color.BLUE);
    }
}
```

### 3.2、弹窗

```java
package lesson04;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//主窗口
public class DialogDemo extends JFrame {

    public DialogDemo(){
        this.setVisible(true);
        this.setSize(700,800);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //JFame 放东西,容器
        Container container = this.getContentPane();
        //绝对布局
        container.setLayout(null);

        //按钮
        JButton button = new JButton("点击弹出一个对话框");
        button.setBounds(30,30,200,500);

        //点击这个按钮的时候,弹出一个弹窗
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //弹窗
                new MyDialogDemo();
            }
        });
        container.add(button);

    }
    public static void main(String[] args) {
        new DialogDemo();
    }
}

//弹窗
class MyDialogDemo extends JDialog{
    public MyDialogDemo(){
        this.setVisible(true);
        this.setBounds(100,100,500,500);
        //弹窗默认可以关闭
        //this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        Container container = this.getContentPane();
        container.setLayout(null);

        container.add(new Label("DIO&JOJO"));


    }
}
```

### 3.3、标签

lable

```java
new JLable("xxx")
```

图标Icon

```java
package lesson04;

import javax.swing.*;
import java.awt.*;

//图标,需要实现类,Frame继承
public class IconDemo extends JFrame implements Icon{
    private int width;
    private int height;

    public IconDemo(){}//无参构造

    public IconDemo(int width,int height){
        this.width = width;
        this.height = height;
    }

    public void init(){
        IconDemo iconDemo = new IconDemo(15, 15);
        //图标放在标签上,也可以放在按钮上
        JLabel label = new JLabel("IconTest", iconDemo, SwingConstants.CENTER);


        Container container = getContentPane();
        container.add(label);

        this.setVisible(true);
        this.setBounds(100,100,200,200);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new IconDemo().init();

    }
    @Override
    public void paintIcon(Component c, Graphics g, int x, int y) {
        g.fillOval(x,y,width,height);
    }

    public int getIconWidth(){
        return this.width;
    }
    public int getIconHeight(){
        return this.height;
    }

}
```

图片Icon

```java
package lesson04;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class ImageIconDemo extends JFrame {
    public ImageIconDemo(){
        //获取图片地址
        JLabel label = new JLabel("ImageIcon");
        URL url = ImageIconDemo.class.getResource("tx.png");

        ImageIcon imageIcon = new ImageIcon(url);
        label.setIcon(imageIcon);
        label.setHorizontalAlignment(SwingConstants.CENTER);

        Container container = getContentPane();
        container.add(label);

        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(100,100,200,200);
    }
    public static void main(String[] args) {
        new ImageIconDemo();
    }

}
```

### 3.4、面板

JPanel

```java
package lesson05;

import javax.swing.*;
import java.awt.*;

public class JPanelDemo extends JFrame {
    public JPanelDemo(){
        Container container = this.getContentPane();

        container.setLayout(new GridLayout(2,1,10,10));//后面的参数意思是间距

        JPanel panel1 = new JPanel(new GridLayout(1,3));
        JPanel panel2 = new JPanel(new GridLayout(1,2));
        JPanel panel3 = new JPanel(new GridLayout(2,1));
        JPanel panel4 = new JPanel(new GridLayout(3,2));

        panel1.add(new JButton("1"));
        panel1.add(new JButton("1"));
        panel1.add(new JButton("1"));
        panel2.add(new JButton("2"));
        panel2.add(new JButton("2"));
        panel3.add(new JButton("3"));
        panel3.add(new JButton("3"));
        panel4.add(new JButton("4"));
        panel4.add(new JButton("4"));
        panel4.add(new JButton("4"));
        panel4.add(new JButton("4"));
        panel4.add(new JButton("4"));
        panel4.add(new JButton("4"));

        container.add(panel1);
        container.add(panel2);
        container.add(panel3);
        container.add(panel4);

        this.setVisible(true);
        this.setSize(500,500);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new JPanelDemo();
    }
}
```

JScrollPanel

```java
package lesson05;

import javax.swing.*;
import java.awt.*;

public class JScrollDemo extends JFrame {
    public JScrollDemo(){
        Container container = this.getContentPane();
        //文本域
        JTextArea textArea = new JTextArea(20,20);
        textArea.setText("JOJO&DIO");

        
        //Scroll面板
        JScrollPane scrollPane = new JScrollPane(textArea);
        container.add(scrollPane);

        this.setVisible(true);
        this.setBounds(200,200,400,500);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new JScrollDemo();
    }
}
```

### 3.5、按钮

图片按钮

```java
package lesson05;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class JButtonDemo01 extends JFrame {

    public JButtonDemo01(){
        Container container = this.getContentPane();
        URL resource = JButtonDemo01.class.getResource("tx.png");
        Icon icon = new ImageIcon(resource);

        //把这个图标放到按钮上
        JButton button = new JButton();
        button.setIcon(icon);
        button.setToolTipText("图片按钮");

        //add
        container.add(button);

        this.setVisible(true);
        this.setSize(300,400);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
    public static void main(String[] args) {
        new JButtonDemo01();
    }
}
```

单选按钮

```java
package lesson05;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class JButtonDemo02 extends JFrame {

    public JButtonDemo02(){
        Container container = this.getContentPane();
        URL resource = JButtonDemo01.class.getResource("tx.png");
        Icon icon = new ImageIcon(resource);

        //单选框
        JRadioButton radioButton1 = new JRadioButton("JRadioButton01");
        JRadioButton radioButton2 = new JRadioButton("JRadioButton02");
        JRadioButton radioButton3 = new JRadioButton("JRadioButton03");

        //由于单选框只能选一个，分组,一个组只能选择一个
        ButtonGroup group = new ButtonGroup();
        group.add(radioButton1);
        group.add(radioButton2);
        group.add(radioButton3);

        container.add(radioButton1,BorderLayout.CENTER);
        container.add(radioButton2,BorderLayout.NORTH);
        container.add(radioButton3,BorderLayout.SOUTH);

        this.setVisible(true);
        this.setSize(300,400);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
    public static void main(String[] args) {
        new JButtonDemo02();
    }
}
```

复选按钮

```java
package lesson05;

import javax.swing.*;
import java.awt.*;
import java.lang.String;

public class JButtonDemo03 extends JFrame {

    public JButtonDemo03(){

        Container container = this.getContentPane();

        JCheckBox jCheckBox1 = new JCheckBox("1");
        JCheckBox jCheckBox2 = new JCheckBox("2");

        container.add(jCheckBox1,BorderLayout.SOUTH);
        container.add(jCheckBox2,BorderLayout.NORTH);

        this.setVisible(true);
        this.setBounds(100,100,400,400);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new JButtonDemo03();
    }
}
```

### 3.6、列表

下拉框

```java
package lesson06;

import javax.swing.*;
import java.awt.*;

public class TestComboxDemo01 extends JFrame {
    public TestComboxDemo01(){
        Container container = this.getContentPane();

        JComboBox status = new JComboBox();

        status.addItem(null);
        status.addItem("ing");
        status.addItem("finish");
        status.addItem("ed");
        
        container.add(status);


        this.setVisible(true);
        this.setSize(600,700);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }

    public static void main(String[] args) {
        new TestComboxDemo01();

    }
}
```

列表框

```java
package lesson06;

import javax.swing.*;
import java.awt.*;
import java.util.Vector;

public class TestCombosDemo02 extends JFrame {
    public TestCombosDemo02(){
        Container container = this.getContentPane();

        //生成列表的内容
//        String[] contents = {"1","2","3"};
        Vector vectot = new Vector();

        //列表中需要放内容
        JList jList1 = new JList(vectot);

        vectot.add("JOJO");
        vectot.add("Dio");

        container.add(jList1);

        this.setVisible(true);
        this.setSize(400,700);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }

    public static void main(String[] args) {
        new TestCombosDemo02();
    }
}
```

应用场景

- 选择地区，或者一些单个选项
- 列表，展示信息，一般是动态扩容！

### 3.7、 文本框

文本框

```java
package lesson06;

import javax.swing.*;
import java.awt.*;

public class TestTextDemo01 extends JFrame {
    public TestTextDemo01(){
        Container container = this.getContentPane();

        JTextField textField = new JTextField("world");
        JTextField textField2 = new JTextField("hello",20);

        container.add(textField,BorderLayout.EAST);
        container.add(textField2,BorderLayout.WEST);

        this.setVisible(true);
        this.setSize(400,700);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new TestTextDemo01();
    }
}
```

密码框

```java
package lesson06;

import javax.swing.*;
import java.awt.*;

public class TestTextDemo02 extends JFrame{
    public TestTextDemo02(){
        Container container = this.getContentPane();

        JPasswordField passwordField = new JPasswordField();
        passwordField.setEchoChar('x');

        container.add(passwordField);

        this.setVisible(true);
        this.setSize(400,700);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new TestTextDemo02();
    }
}
```

文本域

```java
package lesson05;

import javax.swing.*;
import java.awt.*;

public class JScrollDemo extends JFrame {
    public JScrollDemo(){
        Container container = this.getContentPane();
        //文本域
        JTextArea textArea = new JTextArea(20,20);
        textArea.setText("JOJO&DIO");


        //Scroll面板
        JScrollPane scrollPane = new JScrollPane(textArea);
        container.add(scrollPane);

        this.setVisible(true);
        this.setBounds(200,200,400,500);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new JScrollDemo();
    }
}
```

## 贪吃蛇

帧，如果时间片够小，就是动画，一秒30帧，60帧。连起来是动画，拆开就是静态的图片。

键盘监听

定时器 Timer

***


