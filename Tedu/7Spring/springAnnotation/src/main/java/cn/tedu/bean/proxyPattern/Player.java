package cn.tedu.bean.proxyPattern;

public class Player implements Play{
    @Override
    public void showTime() {
        System.out.println("player say: is show time...");
    }
}
