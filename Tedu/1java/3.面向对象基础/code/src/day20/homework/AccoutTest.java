package day20.homework;

/**
 * @author 26465
 * @create 2022-01-13 11:51
 */
public class AccoutTest {
    public static void main(String[] args) {
        Account account1 = new Account(001,10000,0.05);

        //取款100元
        account1.withdraw(100);
        //存款100元
        account1.deposit(1000);

        System.out.println("用户id："+ account1.getId());
        System.out.println("余额：" + account1.getBalance());
    }
}
