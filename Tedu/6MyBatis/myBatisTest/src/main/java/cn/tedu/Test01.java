package cn.tedu;

public class Test01 {
    private String u_name;
    private String u_password;

    public Test01() {
        System.out.println("test01()");
    }

    public Test01(String u_name, String u_password) {
        this.u_name = u_name;
        this.u_password = u_password;
    }

    public String getU_name() {
        System.out.println("getU_name()");
        return u_name;
    }

    public void setU_name(String u_name) {
        System.out.println("setU_name(String u_name)");
        this.u_name = u_name;
    }

    public String getU_password() {
        System.out.println("getU_password()");
        return u_password;
    }

    public void setU_password(String u_password) {
        System.out.println("setU_password(String u_password)");
        this.u_password = u_password;
    }

    @Override
    public String toString() {
        return "test01{" +
                "u_name='" + u_name + '\'' +
                ", u_password='" + u_password + '\'' +
                '}';
    }
}
