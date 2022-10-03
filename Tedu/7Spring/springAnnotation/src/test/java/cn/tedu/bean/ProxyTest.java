package cn.tedu.bean;

import cn.tedu.bean.proxyPattern.*;
import org.junit.Test;

public class ProxyTest {
    @Test
    public void proxyTest(){

        ProxyPlay proxy = new ProxyPlay(new Singer());
        proxy.showTime();
        proxy.setPlay(new Player());
        proxy.showTime();
        System.out.println("=================");

        ProxyPlay proxy2 = new ProxyPlay(new Singer(), new OtherImp01());
        proxy2.showTime();
        proxy2.setPlay(new Player());
        proxy2.setOther(new OtherImp02());
        proxy2.showTime();


    }
}
