package com.dowei.empsys.dao;

import com.dowei.empsys.entity.Dept;
import com.dowei.empsys.entity.Emp;
import com.dowei.empsys.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmpDao {
    //增加员工
    public int addEmp(Emp emp){
        int effect = 0;
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            effect = 0;
            conn = JDBCUtils.getConnection();
            String sql = "insert into tb_emp values(null, ?, ?, ?, ?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, emp.getDept().getDeptId());
            pstmt.setString(2, emp.getEmpName());
            pstmt.setString(3, emp.getEmpGender());
            pstmt.setDouble(4, emp.getEmpSalary());
            effect = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(pstmt, conn);
        }
        return effect;
    }

    //删除员工
    public int deleteEmp(int empId){
        int effect = 0;
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            effect = 0;
            conn = JDBCUtils.getConnection();
            String sql = "delete from tb_emp where emp_id = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, empId);
            effect = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(pstmt, conn);
        }
        return effect;
    }

    //修改员工
    public int updateEmp(Emp emp){
        int effect = 0;
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            effect = 0;
            conn = JDBCUtils.getConnection();
            String sql = "update tb_emp set dept_id = ?, emp_name = ?, emp_gender = ?, emp_salary = ? where emp_id = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, emp.getDept().getDeptId());
            pstmt.setString(2, emp.getEmpName());
            pstmt.setString(3, emp.getEmpGender());
            pstmt.setDouble(4, emp.getEmpSalary());
            pstmt.setInt(5, emp.getEmpId());
            effect = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(pstmt, conn);
        }
        return effect;
    }

    //查询一个员工
    public Emp getOneEmp(int empId){
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Emp emp = null;
        try {
            conn = JDBCUtils.getConnection();
            String sql = "select e.emp_id, e.dept_id, e.emp_name, e.emp_gender, e.emp_salary, d.dept_name from tb_emp as e left join tb_dept as d on e.dept_id = d.dept_id where e.emp_id = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, empId);
            rs = pstmt.executeQuery();
            Dept dept = null;
            if (rs.next()){
                dept = new Dept(rs.getInt("e.dept_id"), rs.getString("d.dept_name"));
                emp = new Emp(empId, dept, rs.getString("e.emp_name"), rs.getString("e.emp_gender"), rs.getDouble("e.emp_salary"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(rs, pstmt, conn);
        }
        return emp;
    }

    //查询所有员工
    public List<Emp> getAllEmp(){
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Emp emp = null;
        List<Emp> emps = new ArrayList<>();
        try {
            conn = JDBCUtils.getConnection();
            String sql = "select e.emp_id, e.dept_id, e.emp_name, e.emp_gender, e.emp_salary, d.dept_name from tb_emp as e left join tb_dept as d on e.dept_id = d.dept_id";
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            Dept dept = null;
            while (rs.next()){
                dept = new Dept(rs.getInt("e.dept_id"), rs.getString("d.dept_name"));
                emp = new Emp(rs.getInt("e.emp_id"), dept, rs.getString("e.emp_name"), rs.getString("e.emp_gender"), rs.getDouble("e.emp_salary"));
                emps.add(emp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(rs, pstmt, conn);
        }
        return emps;
    }
}
