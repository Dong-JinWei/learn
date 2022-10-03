package ObjectIOStream;

import java.io.Serializable;

public class MyDate implements Serializable {
    int year;
    int month;
    int day;

    public MyDate(int year, int month, int day){
        this.year = year;
        this.month = month;
        this.day = day;
    }

    @Override
    public String toString() {
        return "MyDate{" +
                "year=" + year +
                ", month=" + month +
                ", day=" + day +
                '}';
    }
}
