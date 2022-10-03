package cn.tedu.bean;

public class User {
    private String uName;
    private String uPassword;

    public User() {
        System.out.println("无参构造");
    }


    public User(String uName, String uPassword) {
        this.uName = uName;
        this.uPassword = uPassword;
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public String getuPassword() {
        return uPassword;
    }

    public void setuPassword(String uPassword) {
        this.uPassword = uPassword;
    }

    @Override
    public String toString() {
        return "User{" +
                "uName='" + uName + '\'' +
                ", uPassword='" + uPassword + '\'' +
                '}';
    }
}
