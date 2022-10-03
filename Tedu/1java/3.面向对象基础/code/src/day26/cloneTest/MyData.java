package day26.cloneTest;

/**
 * @author 26465
 * @create 2022-01-20 20:13
 */
public class MyData implements Cloneable{
    int year;
    int month;
    int day;

    public MyData(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return "MyData{" +
                "year=" + year +
                ", month=" + month +
                ", day=" + day +
                '}';
    }
}
