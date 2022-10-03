package cn.tedu.bean.proxyPattern;

public class OtherImp01 implements Other{
    @Override
    public void before() {
        System.out.println("other01 before do something...");
    }

    @Override
    public void after() {
        System.out.println("other01 after do something...");
    }
}
