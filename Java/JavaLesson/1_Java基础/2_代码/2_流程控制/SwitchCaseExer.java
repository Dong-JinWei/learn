
/*
从键盘获取年，月，日，计算这是这一年的几天？
需要注意，判断year是否是润年。
*/
import java.util.Scanner;

public class SwitchCaseExer {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("请输入年份：");
        int year = sc.nextInt();
        System.out.println("请输入月份：");
        int month = sc.nextInt();
        System.out.println("请输入天数：");
        int day = sc.nextInt();
        int sumDays = 0;

        switch (month) {
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
                if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
                    sumDays = sumDays + 29;
                } else {
                    sumDays = sumDays + 28;
                }
            case 2:
                sumDays = sumDays + 31;
            case 1:
                sumDays = sumDays + day;
        }
        System.out.println(sumDays);
    }

}
