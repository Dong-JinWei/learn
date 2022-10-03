package homework;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author 26465
 * @create 2022-01-24 16:51
 * 1、从键盘输入输入两个数，输出两个数的商。给三次错误输入机会。如果出错则输出
 */
public class 第一题 {
    public static void main(String[] args) {
        div();
    }
    public static void div(){
        Scanner in = new Scanner(System.in);
        int i = 1;
        while(true){
            try {
                System.out.println("请输入两个数：");
                int a = in.nextInt();
                int b = in.nextInt();
                System.out.println("a/b= " + a / b);
                return;
            } catch (ArithmeticException e) {
                System.out.println("除数不可以为零");
            } catch (InputMismatchException e) {
                in.next();
                System.out.println("请输如正确的数字");
            }catch (Exception e){
                System.out.println("其他异常");
            }finally {
                i++;
                if (i > 3){
                    System.out.println("输入超过三次，程序结束");
                    break;
                }
            }
        }
    }
}
