package cn.tedu.bean.proxyPattern;

public class Singer implements Play{
    @Override
    public void showTime() {
        System.out.println("Singer say : is show time...");
    }
}
