package com.dowei.empsys.test;

import com.dowei.empsys.dao.DeptDao;
import com.dowei.empsys.entity.Dept;
import org.testng.annotations.Test;

import java.util.List;

public class TestDeptDao {
    DeptDao dao = new DeptDao();

    @Test
    public void testAddUser(){
        Dept dept = new Dept(null, "研发部");
        dao.addDept(dept);
    }

    @Test
    public void testUpdateUser(){
        Dept dept = new Dept(1, "技术部");
        dao.updateDept(dept);

    }

    @Test
    public void testDeleteUser(){
        dao.deleteDept(1);
    }

    @Test
    public void testGetOneUser(){
        Dept oneDept = dao.getOneDept(2);
        System.out.println(oneDept);
    }

    @Test
    public void testGetAllUser(){
        List<Dept> allDept = dao.getAllDept();
        for (Dept dept:allDept){
            System.out.println(dept);
        }
    }

    @Test
    public void testDeptDao(){
        int countDept = dao.getCountDept(1);
        System.out.println(countDept);
    }

    @Test
    public void testIsDeptDao(){
        boolean b = dao.isDeptNameExists("aaa");
        System.out.println(b);

    }
}
