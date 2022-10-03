package com.dowei.stusys;

import java.util.List;
import java.util.Scanner;

public class View {
    public static void main(String[] args) {
        StudentDao dao = new StudentDao();
        int studentId;
        String studentName;
        int studentAge;
        String studentGender;
        String studentAddress;
        Student student = null;
        String strTemp;
        while (true) {
            System.out.println("******************欢迎使用学生管理系统***********************");
            Scanner sc = new Scanner(System.in);
            System.out.println("请输入你需要的功能：\n" +
                    "1、增加  2、删除  3、修改  4、查询一个  5、查询所有  6、退出系统");

            String choose = sc.next();
            switch (choose) {
                case "1":
                    System.out.println("请输入学生姓名：");
                    studentName = sc.next();
                    if (MyUtils.isNull(studentName)){
                        System.out.println("姓名不能为空");
                        break;
                    }

                    if (!(studentName.length() >= 2 && studentName.length() <= 5)) {
                        System.out.println("姓名长度必须在2个字符到5个字符之间！");
                        break;
                    }

                    System.out.println("请输入学生年龄：");
                    strTemp = sc.next();
                    if (!MyUtils.isNumber(strTemp)){
                        System.out.println("年龄必须是数字！");
                        break;
                    }
                    studentAge = Integer.parseInt(strTemp);
                    if (!(studentAge >= 15 && studentAge <= 60)) {
                        System.out.println("年龄必须在15到60岁之间!");
                        break;
                    }

                    System.out.println("请输入学生性别：");
                    studentGender = sc.next();
                    studentGender = studentGender.trim();
                    if (!("男".equals(studentGender)) && !("女".equals(studentGender))) {
                        System.out.println("性别只能为男或者女！");
                        break;
                    }

                    System.out.println("请输入学生地址：");
                    studentAddress = sc.next();
                    student = new Student(null, studentName, studentAge, studentGender, studentAddress);
                    dao.addStudent(student);
                    System.out.println("添加学生成功！");
                    break;
                case "2":
                    System.out.println("请输入要删除学生的id");
                    strTemp = sc.next();
                    if (!MyUtils.isNumber(strTemp)){
                        System.out.println("输入id不合法！");
                        break;
                    }
                    studentId = Integer.parseInt(strTemp);
                    System.out.println("是否确认删除？y是 其他否");
                    String sure = sc.next();
                    // equalsIgnoreCase 判断是否相等忽略大小写
                    if (!"y".equalsIgnoreCase(sure)){
                        System.out.println("取消删除！");
                        break;
                    }
                    int effect = dao.deleteStudent(studentId);
                    if (effect > 0){
                        System.out.println("删除学生成功！");
                    }else{
                        System.out.println("学生不存在，删除学生失败！");
                    }
                    break;
                case "3":
                    System.out.println("请输入需要修改的Id");
                    strTemp = sc.next();
                    if (!MyUtils.isNumber(strTemp)){
                        System.out.println("输入id不合法！");
                        break;
                    }
                    studentId = Integer.parseInt(strTemp);
                    Student oneStudent = dao.getOneStudent(studentId);
                    if (null == oneStudent){
                        System.out.println("修改的学生信息不存在");
                        break;
                    }else{
                        System.out.println("需要修改的学生信息为：" + oneStudent);
                    }

                    System.out.println("请输入学生姓名：");
                    studentName = sc.next();
                    if (MyUtils.isNull(studentName)){
                        System.out.println("姓名不能为空");
                    }

                    if (!(studentName.length() >= 2 && studentName.length() <= 5)) {
                        System.out.println("姓名长度必须在2个字符到5个字符之间！");
                        break;
                    }

                    System.out.println("请输入学生年龄：");
                    strTemp = sc.next();
                    if (!MyUtils.isNumber(strTemp)){
                        System.out.println("年龄必须是数字！");
                        break;
                    }
                    studentAge = Integer.parseInt(strTemp);
                    if (!(studentAge >= 15 && studentAge <= 60)) {
                        System.out.println("年龄必须在15到60岁之间!");
                        break;
                    }

                    System.out.println("请输入学生性别：");
                    studentGender = sc.next();
                    studentGender = studentGender.trim();
                    if (!("男".equals(studentGender)) && !("女".equals(studentGender))) {
                        System.out.println("性别只能为男或者女！");
                        break;
                    }

                    System.out.println("请输入学生地址：");
                    studentAddress = sc.next();
                    student = new Student(studentId, studentName, studentAge, studentGender, studentAddress);
                    dao.updateStudent(student);
                    break;
                case "4":
                    System.out.println("请输入查询的Id");
                    strTemp = sc.next();
                    if (!MyUtils.isNumber(strTemp)){
                        System.out.println("Id必须为数字！！");
                        break;
                    }
                    studentId = Integer.parseInt(strTemp);
                    if (studentId <= 0){
                        System.out.println("Id必须大于0！！");
                        break;
                    }
                    Student getOneStudentValue = dao.getOneStudent(studentId);
                    if (null == getOneStudentValue){
                        System.out.println("没有查到学号为" + studentId + "的学生！！");
                    }else{
                        System.out.println("学生信息为：\n" + getOneStudentValue);
                    }
                    break;
                case "5":
                    List<Student> allStudents = dao.getAllStudents();
                    if (allStudents.size() <= 0){
                        System.out.println("没有查到任何学生！！");
                        break;
                    }else{
                        for (Student allStudent : allStudents) {
                            System.out.println("======================");
                            System.out.println(allStudent);
                        }
                    }
                    break;
                case "6":
                    System.out.println("欢迎下次使用，再见！");
                    return;
                default:
                    System.out.println("输入又误，请重新输入！");
                    break;
            }
        }
    }
}
