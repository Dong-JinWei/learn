/*
����2019���month��day�������������һ��ĵڼ���
*/

import java.util.Scanner;

public class SwitchCaseTest2{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.println("�������·ݣ�");
        int month = sc.nextInt();
        System.out.println("������������");
        int day = sc.nextInt();

        switch (month){
            case 1:
                System.out.println(day);
                break;
            case 2:
                System.out.println(31 + day);
                break;
            case 3:
                System.out.println(31 + 28 + day);
                break;
            case 4:
                System.out.println(31 + 28 + 31 + day);
                break;
            case 5:
                System.out.println(31 + 28 + 31 + 30 + day);
                break;
            case 6:
                System.out.println(31 + 28 + 31 + 30 + 31 + day);
                break;
            case 7:
                System.out.println(31 + 28 + 31 + 30 + 31 + 30 + day);
                break;
            case 8:
                System.out.println(31 + 28 + 31 + 30 + 31 + 30 + 31 + day);
                break;
            case 9:
                System.out.println(31 + 28 + 31 + 30 + 31 + 30 + 31 + 31 + day);
                break;
            case 10:
                System.out.println(31 + 28 + 31 + 30 + 31 + 30 + 31 + 31 + 30 + day);
                break;
            case 11:
                System.out.println(31 + 28 + 31 + 30 + 31 + 30 + 31 + 31 + 30 + 31 + day);
                break;
            case 12:
                System.out.println(31 + 28 + 31 + 30 + 31 + 30 + 31 + 31 + 30 + 31 + 30 + day);
                break;
        }

        int sumDays = 0;
        switch (month){
            case 12:
                sumDays = sumDays + 30;
            case 11:
                sumDays = sumDays + 31;
            case 10:
                sumDays = sumDays + 30;
            case 9:
                sumDays = sumDays + 31;
            case 8:
                sumDays = sumDays + 31;
            case 7:
                sumDays = sumDays + 30;
            case 6:
                sumDays = sumDays + 31;
            case 5:
                sumDays = sumDays + 30;
            case 4:
                sumDays = sumDays + 31;
            case 3:
                sumDays = sumDays + 28;
            case 2:
                sumDays = sumDays + 31;
            case 1:
                sumDays = sumDays + day;
        }
        System.out.println(sumDays);
    }
}