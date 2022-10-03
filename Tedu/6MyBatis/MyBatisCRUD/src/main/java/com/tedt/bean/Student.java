package com.tedt.bean;

public class Student {
    private Integer sId;
    private String sName;
    private String sPwd;


    public Student() {
    }

    public Student(Integer sId, String sName, String sPwd) {
        this.sId = sId;
        this.sName = sName;
        this.sPwd = sPwd;
    }

    public Integer getsId() {
        return sId;
    }

    public void setsId(Integer sId) {
        this.sId = sId;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public String getsPwd() {
        return sPwd;
    }

    public void setsPwd(String sPwd) {
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
