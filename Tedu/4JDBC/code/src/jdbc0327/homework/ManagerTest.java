package jdbc0327.homework;

import java.sql.SQLException;
import java.util.Scanner;

public class ManagerTest {
    public static void main(String[] args) throws SQLException {
        Scanner in = new Scanner(System.in);
        Student stu = new Student();

        while(true){
            System.out.println("1. 插入用户   2. 查看用户   3. 删除用户    4. 修改用户");
            System.out.println("根据提示输入数字，输入其他退出");
            String input = in.next();
            switch (input){
                case "1" :
                    System.out.println("请输入插入的用户名");
                    String insertName = in.next();
                    System.out.println("请输入插入的性别");
                    String insertSex = in.next();
                    System.out.println("请输入插入的地址");
                    String insertAddress = in.next();
                    stu.insert(insertName, insertSex, insertAddress);
                    break;
                case "2" :
                    System.out.println("请输入用户名：");
                    String name = in.next();
                    stu.select(name);
                    break;
                case "3":
                    System.out.println("请输入要删除的用户名");
                    String delName = in.next();
                    stu.delete(delName);
                    break;
                case "4":
                    System.out.println("请输入新的地址：");
                    String newAddress = in.next();
                    System.out.println("请输入要修改的名字");
                    String newName = in.next();
                    stu.update(newAddress, newName);
                    break;
                default:
                    break;
            }
            System.out.println("输入N退出程序，输入其他任意字母继续");
            input = in.next();
            if("N".equals(input)){
                break;
            }

        }
    }
}
