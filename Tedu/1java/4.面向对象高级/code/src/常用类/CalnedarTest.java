package 常用类;

import java.util.Calendar;
import java.util.Date;

/**
 * @author 26465
 * @create 2022-01-25 16:10
 */
public class CalnedarTest {
    public static void main(String[] args) {
        Calendar calendar;
        Date date = new Date();

        System.out.println(date);

        calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.YEAR, 2008);
        calendar.set(Calendar.MONTH, 8);
        System.out.println(calendar.get(Calendar.YEAR));
        System.out.println(calendar.get(Calendar.MONTH));
        System.out.println("Monday "+calendar.get(Calendar.MONDAY));
        System.out.println(calendar.get(Calendar.DATE));
        System.out.println(calendar.get(Calendar.HOUR));
        System.out.println(calendar.get(Calendar.MINUTE));
        System.out.println(calendar.get(Calendar.SECOND));
        System.out.println(calendar.get(Calendar.DAY_OF_WEEK));
        date = calendar.getTime();
        System.out.println(date);
    }
}
