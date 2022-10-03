package com.dowei.empsys.test;

import com.dowei.empsys.entity.Emp;
import com.dowei.empsys.entity.User;
import org.testng.annotations.Test;

public class TestUser {
    @Test
    public void testUser(){
        User user = new User(1, "admin", "abc123", "管理员");
        System.out.println(user);
        System.out.println(user.getUserId());
        System.out.println(user.getUsername());
        System.out.println(user.getPassword());
        System.out.println(user.getNickname());
    }

    @Test
    public void TestEmp(){
        Emp emp = new Emp();
        emp.setEmpId(1);
        System.out.println(emp);
    }
}
