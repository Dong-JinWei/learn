/*
С���μ�Java���ԣ����͸��״�ɳ�ŵ:
���:
�ɼ�Ϊ100��ʱ������- - ��BMW;
�ɼ�Ϊ(80��99]ʱ������һ̨iphone xS max;
���ɼ�Ϊ[60, 80]ʱ������һ��iPad;
����ʱ��ʲô����Ҳû�С�
��Ӽ���������С������ĩ�ɼ����������ж�
*/
import java.util.Scanner;
class IfTest{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);

        double score;
        System.out.println("��������ĳɼ���");
        score = scan.nextDouble();
        if(score == 100){
            System.out.println("������һ��BMW��");
        }else if(score > 80 && score <= 90){
            System.out.println("������һ��iphone xs max��");
        }else if(score >= 60 && score <= 80){
            System.out.println("������һ��iPad");
        }else{
            System.out.println("��ʲô��û�л�á�");
        }
    }
}