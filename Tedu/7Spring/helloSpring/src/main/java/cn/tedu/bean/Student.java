package cn.tedu.bean;

public class Student {
    private Integer sId;
    private String sName;
    private String sPwd;

    public Student() {
        System.out.println("Student()-==-=-=-=无参构造被调用了——+——+");
    }

    public Student(Integer sId, String sName, String sPwd) {
        this.sId = sId;
        this.sName = sName;
        this.sPwd = sPwd;
    }

    @Override
    public String toString() {
        return "Student{" +
                "sId=" + sId +
                ", sName='" + sName + '\'' +
                ", sPwd='" + sPwd + '\'' +
                '}';
    }
}
