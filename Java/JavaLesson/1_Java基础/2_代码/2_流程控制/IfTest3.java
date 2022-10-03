import java.util.Scanner;
public class IfTest3{
    public static void main(String[] args){
        int i,j;
        i = 30;
        j = 40;

        if (i+j>50){
            System.out.println("Hello world!");
        }

        double m,n;

        m = 21.0;
        n = 11.0;

        if (m > 10.0 && n < 20.0){
            System.out.println("两数之和是："+ (m + n));
        }else{
            System.out.println("两数之积是："+(m * n));
        }

        Scanner scan = new Scanner(System.in);
        System.out.println("请输入狗的年龄：");
        double dogAge = scan.nextDouble();

        if(dogAge >= 0 && dogAge < 2.0){
            System.out.println(dogAge+"岁的狗，相当于人类的"+(dogAge * 10.5)+"岁！");
        }else{
            System.out.println(dogAge+"岁的狗，相当于人类的"+(10.5+10.5 +(dogAge - 2.0)*4)+"岁！");
        }

    }
}