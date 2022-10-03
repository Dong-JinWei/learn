package IOStream.homework;

import java.io.File;
import java.util.Scanner;

public class InsertUDisk {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("系统当前磁盘：");
        int count = 0;
        for (File file : File.listRoots()) {
            ++count;
            System.out.println(file);
        }

        while(true){
            System.out.println("======================");
            System.out.println("输入q退出，输入任意键进行检测：");
            String next = scanner.next();
            if (next.equals("q")){
                break;
            }
            int countAfter = 0;
            for (File file : File.listRoots()) {
                ++countAfter;
                System.out.println(file);
            }

            if (countAfter > count){
                System.out.println("插入了U盘");
            }else if (countAfter < count){
                System.out.println("拔出了U盘");
            }else{
                System.out.println("没有检测到新设备");
            }
            count = countAfter;
        }
    }
}
