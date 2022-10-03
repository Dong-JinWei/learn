package com.dowei.stusys;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDao implements Serializable {
    //增加学生信息，考虑参数和返回值
    public void addStudent(Student student) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = JDBCUtils.getConnection();
            String sql = "insert into tb_student values(null, ?, ?, ?, ?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, student.getStudentName());
            pstmt.setInt(2, student.getStudentAge());
            pstmt.setString(3, student.getStudentGender());
            pstmt.setString(4, student.getStudentAddress());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(pstmt, conn);
        }

    }

    //修改学生信息，用学生做参数，除了id以外都是用户需要修改的
    public void updateStudent(Student student) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = JDBCUtils.getConnection();
            String sql = "update tb_student set student_name = ?, student_age = ?, student_gender = ?, student_address = ? where student_id = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, student.getStudentName());
            pstmt.setInt(2, student.getStudentAge());
            pstmt.setString(3, student.getStudentGender());
            pstmt.setString(4, student.getStudentAddress());
            pstmt.setInt(5, student.getStudentId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(pstmt, conn);
        }
    }

    //查询一个学生信息
    public Student getOneStudent(int studentId) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        Student student = null;
        try {
            conn = null;
            pstmt = null;
            conn = JDBCUtils.getConnection();
            String sql = "select * from tb_student where student_id = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, studentId);
            ResultSet rs = pstmt.executeQuery();
            //如果值查询一条数据，可以使用if语句
            if (rs.next()) {
                //如果进入了if语句说明查询到了指定学生信息
                //把查处的内容封装到学生对象中返回
                String studentName = rs.getString("student_name");
                int studentAge = rs.getInt("student_age");
                String studentGender = rs.getString("student_gender");
                String studentAddress = rs.getString("student_address");

                //把查出的数据封装到学生对象中
                student = new Student(studentId, studentName, studentAge, studentGender, studentAddress);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(pstmt, conn);
        }

        return student;
    }

    //查询所有学生信息，没有参数，有返回值List类型
    public List<Student> getAllStudents(){
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<Student> students = null;
        try {
            conn = JDBCUtils.getConnection();
            String sql = "select * from tb_student";
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();

            //创建一个空集合，用于存放遍历出来的数据
            students = new ArrayList<>();

            while(rs.next()){
                int studentId = rs.getInt("student_id");
                String studentName = rs.getString("student_name");
                int studentAge = rs.getInt("student_age");
                String studentGender = rs.getString("student_gender");
                String studentAddress = rs.getString("student_Address");

                Student student = new Student(studentId, studentName, studentAge, studentGender, studentAddress);
                students.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(rs, pstmt, conn);
        }
        return students;
    }

    //删除学生信息
    public int deleteStudent(int studentId){
        Connection conn = null;
        PreparedStatement pstmt = null;
        int effect = 0;
        try {
            conn = JDBCUtils.getConnection();
            String sql = "delete from tb_student where student_id = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, studentId);
            effect = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(pstmt, conn);
        }
        return effect;
    }
}
