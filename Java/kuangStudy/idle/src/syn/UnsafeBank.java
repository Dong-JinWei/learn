package syn;

//不安全的取钱
//两个人去银行取钱，账户
public class UnsafeBank {
    public static void main(String[] args) {
        Account account = new Account(100, "存款");

        Drawing you = new Drawing(account,50,"你");
        Drawing youWife = new Drawing(account,100,"你的妻子");

        you.start();
        youWife.start();
    }
}

//账户
class Account{
    int money;//余额
    String name;//卡名

    public Account(int money, String name){
        this.money = money;
        this.name = name;
    }
}

//银行
class Drawing extends Thread{
    Account account;
    int drawingMoney;
    int nowMoney;

    public Drawing(Account account,int drawingMoney,String name){
        super(name);
        this.account = account;
        this.drawingMoney = drawingMoney;
    }

    public void run(){
        synchronized (account){
            if (account.money-drawingMoney<0){
                System.out.println(Thread.currentThread().getName()+"没有钱，取不了");
                return;
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            account.money = account.money - drawingMoney;
            nowMoney = nowMoney + drawingMoney;
            System.out.println(account.name+"余额"+account.money);
            System.out.println(this.getName()+"手里的钱："+nowMoney);
        }


    }
}