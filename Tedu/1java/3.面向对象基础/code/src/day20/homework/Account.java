package day20.homework;

/**
 * @author 26465
 * @create 2022-01-13 11:41
 */
public class Account {
    private int id;
    private double balance;
    private double annuallnterestRate;

    public Account(int id, double balance, double annuallnterestRate) {
        this.id = id;
        this.balance = balance;
        this.annuallnterestRate = annuallnterestRate;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getAnnuallnterestRate() {
        return annuallnterestRate;
    }

    public void setAnnuallnterestRate(double annuallnterestRate) {
        this.annuallnterestRate = annuallnterestRate;
    }

    //取款方法
    public void withdraw(double amount) {
        if ((balance - amount) < 0) {
            System.out.println("余额不足，取款失败，您的余额为：" + balance);
            return;
        } else {
            balance = balance - amount;
            System.out.println("取款成功，取款金额为：" + amount + "剩余：" + balance);
        }
    }

    //存款方法
    void deposit(double amount) {
        balance = balance + amount;
        System.out.println("存款成功，存款金额为：" + amount + "剩余：" + balance);
    }
}
