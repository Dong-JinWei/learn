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
            System.out.println("����֮���ǣ�"+ (m + n));
        }else{
            System.out.println("����֮���ǣ�"+(m * n));
        }

        Scanner scan = new Scanner(System.in);
        System.out.println("�����빷�����䣺");
        double dogAge = scan.nextDouble();

        if(dogAge >= 0 && dogAge < 2.0){
            System.out.println(dogAge+"��Ĺ����൱�������"+(dogAge * 10.5)+"�꣡");
        }else{
            System.out.println(dogAge+"��Ĺ����൱�������"+(10.5+10.5 +(dogAge - 2.0)*4)+"�꣡");
        }

    }
}