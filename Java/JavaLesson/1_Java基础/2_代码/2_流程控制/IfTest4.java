/*
�������뿪��һ�����Ʊ����Ϸ����������ز���һ����λ���Ĳ�Ʊ����ʾ�û�����һ����λ����Ȼ��������Ĺ����ж��û��Ƿ���Ӯ��

1. ����û��������ƥ���Ʊ��ʵ��˳�򣬽���10 000��Ԫ��
2. ����û��������������ƥ���Ʊ���������֣���˳��һ�£�����3 000��Ԫ��
3. ����û������һ�����ֽ�����˳�������ƥ���Ʊ��һ�����֣�����1 000��Ԫ��
4. ����û������һ�����ֽ������˳�������ƥ���Ʊ��һ�����֣�����500��Ԫ��
5. ����û����������û��ƥ���κ�һ�����֣����Ʊ���ϡ�

> ��ʾ:ʹ��(int)(Math.random()* 90 + 10)�����������
*/

import java.util.Scanner;
import java.lang.Math;

public class IfTest4{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int random = (int)(Math.random()*90 + 10);

        System.out.println("������һ����λ����");
        int num = scan.nextInt();
        int numShi = num / 10; //ʮλ����
        int numGe = num % 10; //��λ����
        int randomShi = num / 10;
        int randomGe = num % 10;

        if(num == random){
            System.out.println("��ϲ����10000��Ԫ");
        }else if (numShi == randomGe && numGe == randomShi){
            System.out.println("��ϲ������3000��Ԫ");
        }else if (numShi == randomShi || numGe == randomGe){
            System.out.println("��ϲ������1000��Ԫ");
        }else if (numGe == randomShi || numShi == randomGe){
            System.out.println("��ϲ������500��Ԫ");
        }else{
            System.out.println("��ʲô��û�л�á�");
        }
    }
}