package day19面向对象_快速排序;

import java.time.LocalDate;

/**
 * @author 26465
 * @create 2022-01-11 11:10
 */
public class 纪念日计算 {
    public static void main(String[] args) {
        LocalDate localDate = LocalDate.of(2021,12,31);

        int year;
        int month;
        int day;

        localDate = localDate.plusDays(100);

        year = localDate.getYear();
        month = localDate.getMonthValue();
        day = localDate.getDayOfMonth();
        System.out.println(year + " " + month+ " " + day);

    }
}
