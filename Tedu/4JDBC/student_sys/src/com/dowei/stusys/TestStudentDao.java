package com.dowei.stusys;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.sql.SQLException;
import java.util.List;

public class TestStudentDao {

    //@BeforeClass
    //public void hello(){
    //    System.out.println("@Before");
    //}
    //@AfterClass
    //public void world(){
    //    System.out.println("@After");
    //}

    StudentDao dao = new StudentDao();

    //测试方法没有返回值，命名规则test方法名
    @Test
    public void testAddStudent(){
        Student student = new Student(null, "dowei", 20, "男", "陕西");
        //System.out.println("@Test");
        dao.addStudent(student);
    }

    @Test
    public void testUpdateStudent(){
        Student student = new Student(1, "djw", 21, "女", "榆林");
        dao.updateStudent(student);
    }

    @Test
    public void testGetOneStudent(){
        Student student = dao.getOneStudent(1);

        System.out.println(student);
    }

    @Test
    public void testGetAllStudents(){
        List<Student> allStudents = dao.getAllStudents();

        for (int i = 0; i < allStudents.size(); i++) {
            System.out.println(allStudents.get(i));
        }
    }

    @Test
    public void testDeleteStudent(){
        dao.deleteStudent(5);
    }

}
