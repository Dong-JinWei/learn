/*
��δӼ��̻�ȡ��ͬ���͵ı�������Ҫʹ��Scanner��

*/

import java.util.Scanner;

public class ScannerTest{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);


        System.out.println("���������������");
        String name = scanner.next();
        System.out.println(name);

        System.out.println("������������䣺");
        int num = scanner.nextInt();
        System.out.println(num);

        System.out.println("������������أ�");
        double weight = scanner.nextDouble();
        System.out.println(weight);

        System.out.println("���ǲ����㣿��true/false");
        boolean isMe = scanner.nextBoolean();
        System.out.println(isMe);

        System.out.println("����������Ա𣺣���/Ů��");
        String gender = scanner.next();
        char genderChar = gender.charAt(0);
        System.out.println(genderChar);

    }
} 