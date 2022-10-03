/*
大家都知道，男大当婚，女大当嫁。那么女方家长要嫁女儿，当然要提出一定的条件:
高: 130cm以上;富:财富1千万以上;帅:是。
如果这三个条件同时满足，则:“我一定要嫁给他!!!”
如果三个条件有为真的情况，则:“嫁吧，比上不足，比下有余。”
如果三个条件都不满足，则:“不嫁!”

*/
import java.util.Scanner;

class IfTest5{
    public static void main(String[] args){
         Scanner scan = new Scanner(System.in);

         System.out.println("请输入你的身高：(cm)");
         int height = scan.nextInt();
         System.out.println("请输入你的财富：(千万)");
         double wealth = scan.nextDouble();
        //  System.out.println("请输入你帅不帅：(true/false)");
        //  Boolean handsome = scan.nextBoolean();

        System.out.println("请输入你帅不帅：(是/否)");
        String handsome = scan.next();

         if(height > 180 && wealth > 1000 && handsome.equals("是")){
            System.out.println("直接嫁");
         }else if(height > 180 || wealth > 1000 || handsome.equals("是")){
             System.out.println("可以考虑");
         }else{
             System.out.println("不嫁！");
         }

        
    }
}