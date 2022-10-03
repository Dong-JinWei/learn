package cn.tedu.bean;

public class BookDaoImp implements BookDao{
    @Override
    public void save() {
        System.out.println("book dao save() ....");
    }
}
