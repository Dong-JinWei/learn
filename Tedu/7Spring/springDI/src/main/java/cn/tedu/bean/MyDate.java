package cn.tedu.bean;

import lombok.ToString;

import java.text.SimpleDateFormat;
import java.util.Date;


@ToString
public class MyDate {
    private String year;
    private String month;
    private String day;

    public MyDate(){
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String format = simpleDateFormat.format(date);
        this.year = format.substring(0, 4);
        this.month = format.substring(5, 7);
        this.day = format.substring(8, 10);
    }
}
