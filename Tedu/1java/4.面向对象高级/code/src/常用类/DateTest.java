package 常用类;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author 26465
 * @create 2022-01-25 16:23
 */
public class DateTest {
    public static void main(String[] args) throws ParseException {
        Date date = new Date();
        System.out.println(date);

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String str = simpleDateFormat.format(date);
        System.out.println(str);

        date = simpleDateFormat.parse("2001-1-7 03:04:05");
        System.out.println(date);
    }
}
