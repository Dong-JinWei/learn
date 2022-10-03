package day20.homework;

/**
 * @author 26465
 * @create 2022-01-13 12:00
 */
public class CustomerTest {
    public static void main(String[] args) {
        Account account2 = new Account(002, 100, 0.01);

        Customer customer2 = new Customer("Dong", "JinWei");
        customer2.setAccount(account2);
        System.out.println("用户 ID: " + customer2.getAccount().getId());
        System.out.println("用户姓名: " + customer2.getFirstName() + " " + customer2.getLastName());
        System.out.println("用户余额: "+ customer2.getAccount().getBalance());

    }
}
