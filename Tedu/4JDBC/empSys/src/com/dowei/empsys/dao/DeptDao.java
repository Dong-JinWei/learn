package com.dowei.empsys.dao;

import com.dowei.empsys.entity.Dept;
import com.dowei.empsys.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DeptDao {
    //增加部门
    public int addDept(Dept dept){
        int effect = 0;
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = JDBCUtils.getConnection();
            String sql = "insert into tb_dept values(null, ?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, dept.getDeptName());
            effect = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(pstmt, conn);
        }
        return effect;
    }

    //删除部门
    public int deleteDept(int deptId){
        int effect = 0;
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            effect = 0;
            conn = JDBCUtils.getConnection();
            String sql = "delete from tb_dept where dept_id = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, deptId);
            effect = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(pstmt, conn);
        }
        return effect;
    }
    //修改部门
    public int updateDept(Dept dept){
        int effect = 0;
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            effect = 0;
            conn = JDBCUtils.getConnection();
            String sql = "update tb_dept set dept_name = ? where dept_id = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, dept.getDeptName());
            pstmt.setInt(2, dept.getDeptId());
            effect = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(pstmt, conn);
        }
        return effect;
    }

    // 查询一个部门
    public Dept getOneDept(int deptId){
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Dept dept = null;
        try {
            conn = JDBCUtils.getConnection();
            String sql = "select dept_id, dept_name from tb_dept where dept_id = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, deptId);
            rs = pstmt.executeQuery();
            if (rs.next()){
                dept = new Dept(deptId, rs.getString("dept_name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(rs, pstmt, conn);
        }
        return dept;
    }

    // 查询所有部门
    public List<Dept> getAllDept(){
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Dept dept = null;
        List<Dept> depts = new ArrayList<>();
        try {
            conn = JDBCUtils.getConnection();
            String sql = "select dept_id, dept_name from tb_dept";
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while (rs.next()){
                dept = new Dept(rs.getInt("dept_id"), rs.getString("dept_name"));
                depts.add(dept);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(rs, pstmt, conn);
        }
        return depts;
    }

    //查询部门人数
    public int getCountDept(int deptId){
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        int count = 0;
        try {
            conn = JDBCUtils.getConnection();
            String sql = "SELECT COUNT(emp_id) AS count_emp FROM tb_emp WHERE dept_id = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, deptId);
            rs = pstmt.executeQuery();
            if (rs.next()){
                count = rs.getInt("count_emp");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(rs, pstmt, conn);
        }
        return count;
    }

    // 查询一个部门，使用部门名
    public Dept getOneDeptByDeptName(String deptName){
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Dept dept = null;
        try {
            conn = JDBCUtils.getConnection();
            String sql = "select dept_id, dept_name from tb_dept where dept_name = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, deptName);
            rs = pstmt.executeQuery();
            if (rs.next()){
                dept = new Dept(rs.getInt("dept_id"), deptName);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(rs, pstmt, conn);
        }
        return dept;
    }

    //判断部门名称是否存在
    public boolean isDeptNameExists(String deptName){
        boolean flag = false;
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Dept dept = null;
        try {
            conn = JDBCUtils.getConnection();
            String sql = "select dept_id, dept_name from tb_dept where dept_name = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, deptName);
            rs = pstmt.executeQuery();
            if (rs.next()){
                flag = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(rs, pstmt, conn);
        }
        return flag;
    }

}
