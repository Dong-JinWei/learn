package snake;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

//游戏的面板
public class GamePanel extends JPanel implements KeyListener, ActionListener {

    //定义蛇的数据结构
    int length;//蛇的长度
    int[] snakeX = new int[600];//蛇的x坐标 25*25
    int[] snakeY = new int[500];//蛇的y坐标 25*25
    String fx;

    //食物的坐标
    int foodX;
    int foodY;
    Random random = new Random();

    int score;

    //游戏当前的状态;开始，停止
    boolean isStart = false; //默认是不开始

    boolean isFail = false;//游戏失败

    //定时器
    Timer timer = new Timer(50,this);//100毫秒执行一次

    //构造器
    public GamePanel(){
        init();
        //获取焦点事件和键盘事件
        this.setFocusable(true);
        this.addKeyListener(this);//获得键盘监听器
        timer.start();//游戏一开始定时启动
    }

    //初始化方法
    public void init(){
        length = 3;
        snakeX[0] = 100; snakeY[0] = 100; //脑袋的坐标
        snakeX[1] = 75; snakeY[1] = 100; //第一个身体的坐标
        snakeX[2] = 50; snakeY[2] = 100; //第二个身体的坐标
        fx = "R";//初始方向向右

        //把食物随机分配到界面上
        foodX = 25 + 25*random.nextInt(33);
        foodY = 75 + 75*random.nextInt(7);

        score = 0;
    }

    protected void paintComponent(Graphics g){
        super.paintComponent(g);//清屏

        //绘制静态面板
        this.setBackground(Color.WHITE);
        Data.header.paintIcon(this,g,25,11);//头部广告位
        g.fillRect(25,75,850,600); //默认的游戏界面

        //画积分
        g.setColor(Color.BLACK);
        g.setFont(new Font("微软雅黑",Font.BOLD,17));
        g.drawString("长度 "+length,750,35);
        g.drawString("分数 "+score,750,55);

        //画食物
        Data.food.paintIcon(this,g,foodX,foodY);
        //把小蛇画上去
        if(fx.equals("R")){
            Data.right.paintIcon(this,g,snakeX[0],snakeY[0]); //脑袋初始化向右
        }else if(fx.equals("L")){
            Data.left.paintIcon(this,g,snakeX[0],snakeY[0]); //脑袋初始化向右
        }else if(fx.equals("U")){
            Data.up.paintIcon(this,g,snakeX[0],snakeY[0]); //脑袋初始化向右
        }else if(fx.equals("D")){
            Data.down.paintIcon(this,g,snakeX[0],snakeY[0]); //脑袋初始化向右
        }

        for (int i = 1; i < length; i++){
            Data.body.paintIcon(this,g,snakeX[i],snakeY[i]);
        }

        //游戏状态
        if (isStart == false){
            g.setColor(Color.BLUE);
            //设置字体
            g.setFont(new Font("微软雅黑",Font.BOLD,40));
            g.drawString("按下空格开始游戏",300,300);
        }

        if (isFail){
            g.setColor(Color.RED);
            //设置字体
            g.setFont(new Font("微软雅黑",Font.BOLD,80));
            g.drawString("菜",370,300);
            g.setFont(new Font("微软雅黑",Font.BOLD,30));
            g.drawString("空格重新开始",325,380);
        }
    }

    //键盘监听事件
    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();//获得键盘按键
        if (keyCode == KeyEvent.VK_SPACE){//如果是按下是空格
            if(isFail){
                //重新开始
                isFail = false;
                init();
            }else {
                isStart = !isStart;//取反
                repaint();
            }
        }
        //小蛇移动

        //fx为右时，fx无法设置为左
        if(fx.equals("R")){
            if(keyCode == KeyEvent.VK_UP){
                fx = "U";
            }else if(keyCode == KeyEvent.VK_DOWN){
                fx = "D";
            }else if(keyCode == KeyEvent.VK_RIGHT){
                fx = "R";
            }
        }
        //fx为左时，fx无法设置为右
        if(fx.equals("L")){
            if(keyCode == KeyEvent.VK_UP){
                fx = "U";
            }else if(keyCode == KeyEvent.VK_DOWN){
                fx = "D";
            }else if(keyCode == KeyEvent.VK_LEFT){
                fx = "L";
            }
        }
        //fx为上时，fx无法设置为下
        if(fx.equals("U")){
            if(keyCode == KeyEvent.VK_UP){
                fx = "U";
            }else if(keyCode == KeyEvent.VK_LEFT){
                fx = "L";
            }else if(keyCode == KeyEvent.VK_RIGHT){
                fx = "R";
            }
        }
        //fx为下时，fx无法设置为上
        if(fx.equals("D")){
            if(keyCode == KeyEvent.VK_DOWN){
                fx = "D";
            }else if(keyCode == KeyEvent.VK_LEFT){
                fx = "L";
            }else if(keyCode == KeyEvent.VK_RIGHT){
                fx = "R";
            }
        }

//       if(keyCode == KeyEvent.VK_UP){
//            fx = "U";
//        }else if(keyCode == KeyEvent.VK_DOWN){
//            fx = "D";
//        }else if(keyCode == KeyEvent.VK_LEFT){
//            fx = "L";
//        }else if(keyCode == KeyEvent.VK_RIGHT){
//            fx = "R";
//        }
    }

    //事件监听---需要通过固定事件来刷新
    @Override
    public void actionPerformed(ActionEvent e) {
        if (isStart && isFail == false) {//如果游戏是开始状态,让小蛇动起来

            //吃食物
            if(snakeX[0] == foodX && snakeY[0] == foodY){
                length++;//长度+1
                //再次随机食物
                score = score + 10;
                foodX = 25 + 25*random.nextInt(33);
                foodY = 75 + 75*random.nextInt(7);
            }

            //移动
            for (int i = length - 1; i > 0; i--) {//后一节移动向前一节
                    snakeX[i] = snakeX[i - 1];
                    snakeY[i] = snakeY[i - 1];
            }

            //走向
            if (fx.equals("R")){
                snakeX[0] = snakeX[0] + 25;
                if (snakeX[0]>850){snakeX[0] = 25;}
            }else if (fx.equals("L")){
                snakeX[0] = snakeX[0] - 25;
                if (snakeX[0]<25){snakeX[0] = 850;}
            }else if (fx.equals("U")){
                snakeY[0] = snakeY[0] - 25;
                if(snakeY[0] < 75){ snakeY[0] = 650;}
            }else if (fx.equals("D")){
                snakeY[0] = snakeY[0] + 25;
                if(snakeY[0] > 650){ snakeY[0] = 75;}//边界判断
            }

            //失败判断，撞到自己就算失败
            for (int i = 1; i < length; i++){
                if (snakeX[0] == snakeX[i] && snakeY[0] == snakeY[i]){
                    isFail = true;
                }
            }
            repaint();  //重画页面
        }
        timer.start();//定时器开始
    }

    @Override
    public void keyReleased(KeyEvent e) {}
    @Override
    public void keyTyped(KeyEvent e) {}
}

