/*
小鹏参加Java考试，他和父亲达成承诺:
如果:
成绩为100分时，奖励- - 辆BMW;
成绩为(80，99]时，奖励一台iphone xS max;
当成绩为[60, 80]时，奖励一个iPad;
其它时，什么奖励也没有。
请从键盘输入岳小鹏的期末成绩，并加以判断
*/
import java.util.Scanner;
class IfTest{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);

        double score;
        System.out.println("请输入你的成绩：");
        score = scan.nextDouble();
        if(score == 100){
            System.out.println("你获得了一辆BMW。");
        }else if(score > 80 && score <= 90){
            System.out.println("你获得了一个iphone xs max。");
        }else if(score >= 60 && score <= 80){
            System.out.println("你获得了一个iPad");
        }else{
            System.out.println("你什么都没有获得。");
        }
    }
}