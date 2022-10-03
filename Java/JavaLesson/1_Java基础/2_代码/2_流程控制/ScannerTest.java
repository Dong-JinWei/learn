/*
如何从键盘获取不同类型的变量：需要使用Scanner类

*/

import java.util.Scanner;

public class ScannerTest{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);


        System.out.println("请输入你的姓名：");
        String name = scanner.next();
        System.out.println(name);

        System.out.println("请输入你的年龄：");
        int num = scanner.nextInt();
        System.out.println(num);

        System.out.println("请输入你的体重：");
        double weight = scanner.nextDouble();
        System.out.println(weight);

        System.out.println("你是不是你？（true/false");
        boolean isMe = scanner.nextBoolean();
        System.out.println(isMe);

        System.out.println("请输入你的性别：（男/女）");
        String gender = scanner.next();
        char genderChar = gender.charAt(0);
        System.out.println(genderChar);

    }
} 