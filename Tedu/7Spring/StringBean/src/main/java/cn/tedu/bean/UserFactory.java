package cn.tedu.bean;

public class UserFactory {

    public static User getUser(){
        return new User(101, "admin", "123456");
    }

    public User getUser2(){
        return new User(102, "dowei", "dowei");
    }

    public static User getUser3(Integer id, String name, String address){
        return new User(id, name, address);
    }
}
