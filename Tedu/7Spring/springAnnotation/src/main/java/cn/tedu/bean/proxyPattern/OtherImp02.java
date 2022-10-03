package cn.tedu.bean.proxyPattern;

public class OtherImp02 implements Other{
    @Override
    public void before() {
        System.out.println("other02 before do something...");
    }

    @Override
    public void after() {
        System.out.println("other02 after do something...");
    }
}
