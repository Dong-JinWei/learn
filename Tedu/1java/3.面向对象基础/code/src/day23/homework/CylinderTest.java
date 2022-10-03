package day23.homework;

/**
 * @author 26465
 * @create 2022-01-18 17:19
 */
public class CylinderTest {
    public static void main(String[] args) {
        Cylinder cylinder = new Cylinder();
        cylinder.setLength(10);
        cylinder.setRadius(5);
        System.out.println("圆柱底面的圆的半径是：" + cylinder.getRadius());
        System.out.println("圆柱底面积：" + cylinder.findArea());
        System.out.println("圆柱的高：" + cylinder.getLength());
        System.out.println("圆柱的体积：" + cylinder.findVolume());
    }
}

class Circle{
    private double radius;

    Circle(){
        radius = 1;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getRadius(){
        return radius;
    }

    public double findArea(){
        return radius * radius * 3.14;
    }
}

class Cylinder extends Circle{
    private double length;

    Cylinder(){
        length = 1;
    }

    public void setLength(double length){
        this.length = length;
    }

    public double getLength(){
        return length;
    }

    public double findVolume(){
        //底面积乘以高
        double v = findArea() * length;
        return v;
    }


}