package try_catchTest;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author 26465
 * @create 2022-01-24 16:35
 */
public class TyrCatchFinallyTest {
    public static void f1(){
        Scanner in = new Scanner(System.in);
        System.out.println("请输入两个整数：");
        try {
            int a = in.nextInt();
            int b = in.nextInt();
            System.out.println("a/b = " + (a / b));
            System.out.println("f1===============");
        } catch (ArithmeticException e) {
            System.out.println("数学异常");
        } catch (InputMismatchException e){
            System.out.println("输入异常");
        } catch (Exception e){
            System.out.println("其他异常");
        }finally {
            System.out.println("finally======");
        }

    }

    public static void f2(){
        System.out.println("f2---------------");
        f1();
        System.out.println("f2****************");
    }

    public static void main(String[] args) {
        f2();
        System.out.println("main==========");
    }
}


