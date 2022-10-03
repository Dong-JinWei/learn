package com.dowei.stusys;

import java.io.Serializable;

//为了方便在网络中传输，一般会实现Serializable接口
public class Student implements Serializable {
    //为了避免基本数据类型默认值和用户输入的值有冲突，所以一般使用基本数据类型的包装类
    private Integer studentId;
    private String studentName;
    private Integer studentAge;
    private String studentGender;
    private String studentAddress;

    public Student() {
    }

    public Student(Integer studentId, String studentName, Integer studentAge, String studentGender, String studentAddress) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.studentAge = studentAge;
        this.studentGender = studentGender;
        this.studentAddress = studentAddress;
    }



    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public Integer getStudentAge() {
        return studentAge;
    }

    public void setStudentAge(Integer studentAge) {
        this.studentAge = studentAge;
    }

    public String getStudentGender() {
        return studentGender;
    }

    public void setStudentGender(String studentGender) {
        this.studentGender = studentGender;
    }

    public String getStudentAddress() {
        return studentAddress;
    }

    public void setStudentAddress(String studentAddress) {
        this.studentAddress = studentAddress;
    }

    @Override
    public String toString() {
        return  "学号：" + studentId +
                "\n姓名：" + studentName +
                "\n年龄：" + studentAge +
                "\n性别：" + studentGender +
                "\n地址：" + studentAddress;
    }
}
