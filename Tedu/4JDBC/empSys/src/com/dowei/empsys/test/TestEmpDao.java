package com.dowei.empsys.test;

import com.dowei.empsys.dao.EmpDao;
import com.dowei.empsys.entity.Dept;
import com.dowei.empsys.entity.Emp;
import org.testng.annotations.Test;

import java.util.List;

public class TestEmpDao {
    EmpDao dao = new EmpDao();

    @Test
    public void testAddEmp(){
        Dept dept = new Dept(1, "123");
        Emp emp = new Emp(null, dept, "1243", null,123.2);
        dao.addEmp(emp);
    }

    @Test
    public void testDeleteEmp(){
        dao.deleteEmp(1);
    }

    @Test
    public void TestUpdateEmp(){
        Dept dept = new Dept(2, "abc");
        Emp emp = new Emp(2, dept, "abc", "Nj",234.5);
        dao.updateEmp(emp);
    }

    @Test
    public void TestGetOneEmp(){
        Emp oneEmp = dao.getOneEmp(2);
        System.out.println(oneEmp);
    }

    @Test
    public void TestGetAllEmp(){
        List<Emp> allEmp = dao.getAllEmp();
        for (Emp e: allEmp){
            System.out.println(e);
        }
    }
}
