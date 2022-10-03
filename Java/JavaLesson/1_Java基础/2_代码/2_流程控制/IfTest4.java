/*
假设你想开发一个玩彩票的游戏，程序随机地产生一个两位数的彩票，提示用户输入一个两位数，然后按照下面的规则判定用户是否能赢。

1. 如果用户输入的数匹配彩票的实际顺序，奖金10 000美元。
2. 如果用户输入的所有数字匹配彩票的所有数字，但顺序不一致，奖金3 000美元。
3. 如果用户输入的一个数字仅满足顺序情况下匹配彩票的一个数字，奖金1 000美元。
4. 如果用户输入的一个数字仅满足非顺序情况下匹配彩票的一个数字，奖金500美元。
5. 如果用户输入的数字没有匹配任何一个数字，则彩票作废。

> 提示:使用(int)(Math.random()* 90 + 10)产生随机数。
*/

import java.util.Scanner;
import java.lang.Math;

public class IfTest4{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int random = (int)(Math.random()*90 + 10);

        System.out.println("请输入一个两位数：");
        int num = scan.nextInt();
        int numShi = num / 10; //十位数字
        int numGe = num % 10; //各位数字
        int randomShi = num / 10;
        int randomGe = num % 10;

        if(num == random){
            System.out.println("恭喜你获得10000美元");
        }else if (numShi == randomGe && numGe == randomShi){
            System.out.println("恭喜你获得了3000美元");
        }else if (numShi == randomShi || numGe == randomGe){
            System.out.println("恭喜你获得了1000美元");
        }else if (numGe == randomShi || numShi == randomGe){
            System.out.println("恭喜你获得了500美元");
        }else{
            System.out.println("你什么都没有获得。");
        }
    }
}