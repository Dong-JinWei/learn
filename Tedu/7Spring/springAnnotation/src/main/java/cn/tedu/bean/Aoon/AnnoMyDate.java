package cn.tedu.bean.Aoon;

import lombok.ToString;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@ToString
@Component("AnnoDate")
public class AnnoMyDate {
    private String year;
    private String month;
    private String day;

    public AnnoMyDate(){
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String format = simpleDateFormat.format(date);
        this.year = format.substring(0, 4);
        this.month = format.substring(5, 7);
        this.day = format.substring(8, 10);
    }
}
