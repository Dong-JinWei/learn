package cn.tedu;

public class User {
    private String u_name;
    private String u_password;

    public User() {
        System.out.println("无参构造");
    }

    public User(String u_name, String u_password) {
        this.u_name = u_name;
        this.u_password = u_password;
    }

    public String getU_name() {
        System.out.println("get名字");
        return u_name;
    }

    public void setU_name(String u_name) {
        System.out.println("set名字");
        this.u_name = u_name;
    }

    public String getU_password() {
        System.out.println("get密码");
        return u_password;
    }

    public void setU_password(String u_password) {
        System.out.println("set密码");
        this.u_password = u_password;
    }

    @Override
    public String toString() {
        return "User{" +
                "u_name='" + u_name + '\'' +
                ", u_password='" + u_password + '\'' +
                '}';
    }
}
