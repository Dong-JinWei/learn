/*
��Ҷ�֪�����д󵱻飬Ů�󵱼ޡ���ôŮ���ҳ�Ҫ��Ů������ȻҪ���һ��������:
��: 130cm����;��:�Ƹ�1ǧ������;˧:�ǡ�
�������������ͬʱ���㣬��:����һ��Ҫ�޸���!!!��
�������������Ϊ����������:���ްɣ����ϲ��㣬�������ࡣ��
������������������㣬��:������!��

*/
import java.util.Scanner;

class IfTest5{
    public static void main(String[] args){
         Scanner scan = new Scanner(System.in);

         System.out.println("�����������ߣ�(cm)");
         int height = scan.nextInt();
         System.out.println("��������ĲƸ���(ǧ��)");
         double wealth = scan.nextDouble();
        //  System.out.println("��������˧��˧��(true/false)");
        //  Boolean handsome = scan.nextBoolean();

        System.out.println("��������˧��˧��(��/��)");
        String handsome = scan.next();

         if(height > 180 && wealth > 1000 && handsome.equals("��")){
            System.out.println("ֱ�Ӽ�");
         }else if(height > 180 || wealth > 1000 || handsome.equals("��")){
             System.out.println("���Կ���");
         }else{
             System.out.println("���ޣ�");
         }

        
    }
}