public class StacticProxy {
    public static void main(String[] args) {
        char i = '\u8D5B';
        WeddingCompany weddingCompany = new WeddingCompany(new You());
        weddingCompany.HappyMarry();
    }
}

interface Marry{
    void HappyMarry();
}

class You implements Marry{
    @Override
    public void HappyMarry() {
        System.out.println("结婚了。");
    }
}

class WeddingCompany implements Marry{

    private Marry target;
    public WeddingCompany(Marry target) {
        this.target = target;
    }
    @Override
    public void HappyMarry() {
        before();
        this.target.HappyMarry();
        after();
    }
    private void before() {
        System.out.println("布置现场");
    }
    private void after() {
        System.out.println("收拾现场");
    }
}
