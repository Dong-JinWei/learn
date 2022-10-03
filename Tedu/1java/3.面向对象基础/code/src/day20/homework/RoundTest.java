package day20.homework;

/**
 * @author 26465
 * @create 2022-01-13 12:18
 */
public class RoundTest {
    public static void main(String[] args) {
        Round round = new Round();

        double roadMoney = round.getRoadMoney();
        double railMoney = round.getRailMoney();
        double blueRadius = round.getBlueRadius();
        double greenRadius = round.getGreenRadius();

        double sumRoad = round.sumRoad(greenRadius,blueRadius,roadMoney);
        double sumRail = round.sumRail(blueRadius,railMoney);

        System.out.println("陆地的半径：" + greenRadius);
        System.out.println("池塘的半径：" + blueRadius);
        System.out.println("路面所需要的总金额：" + sumRoad);
        System.out.println("栏杆所需要的总金额：" + sumRail);

    }
}
