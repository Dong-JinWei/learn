package cn.tedu;

public class Student {
    private int id;
    private String name;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        System.out.println("getId()");
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        System.out.println("getName()");
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
