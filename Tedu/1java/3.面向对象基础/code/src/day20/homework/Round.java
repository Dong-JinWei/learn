package day20.homework;

/**
 * @author 26465
 * @create 2022-01-13 12:05
 */
public class Round {
    private double greenRadius  = 20; //半径20米的路面
    private double blueRadius = 10; //半径10米的池塘
    private double roadMoney = 20; //每平米路面的价格
    private double railMoney = 10; //每米栏杆的价格
    private double sumRoadMoney;
    private double sumRailMoney;

    public double getGreenRadius() {
        return greenRadius;
    }

    public double getBlueRadius() {
        return blueRadius;
    }

    public double getRoadMoney() {
        return roadMoney;
    }

    public double getRailMoney() {
        return railMoney;
    }

    public double getSumRoadMoney() {
        return sumRoadMoney;
    }

    public void setSumRoadMoney(double sumRoadMoney) {
        this.sumRoadMoney = sumRoadMoney;
    }

    public double getSumRailMoney() {
        return sumRailMoney;
    }

    public void setSumRailMoney(double sumRailMoney) {
        this.sumRailMoney = sumRailMoney;
    }

    //计算路面的总价钱
    public double sumRoad(double greenRadius, double blueRadius, double roadMoney){
        //圆环面积S = （R平方- r平方）* 派
        double sumRoad = (greenRadius * greenRadius - blueRadius * blueRadius) * 3.14 * roadMoney;
        return sumRoad;
    }

    public double sumRail(double blueRadius, double railMoney){
        double sumRail = 2 * 3.14 * blueRadius * railMoney;
        return sumRail;
    }
}
