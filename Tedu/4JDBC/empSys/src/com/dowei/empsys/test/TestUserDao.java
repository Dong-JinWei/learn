package com.dowei.empsys.test;

import com.dowei.empsys.dao.UserDao;
import com.dowei.empsys.entity.User;
import org.testng.annotations.Test;

import java.util.List;

public class TestUserDao {
    UserDao dao = new UserDao();
    @Test
    public void TestAddUser(){
        User user = new User(null, "admin", "abc123", "管理员");
        int effect = dao.addUser(user);
        System.out.println(effect);
    }

    @Test
    public void TestDeleteUser(){
        dao.deleteUser(1);
    }

    @Test
    public void TestUpdateUser(){
        User user = new User(2, "123", "asdf", "123");
        dao.updateUser(user);
    }

    @Test
    public void TestGetOneUser(){
        User oneUser = dao.getOneUser(2);
        System.out.println(oneUser);
    }

    @Test
    public void TestGetAllUser(){
        List<User> allUser = dao.getAllUser();
        for(User user: allUser){
            System.out.println(user);
        }
    }

    @Test
    public void TestGetOneUserByUsername(){
        User oneUserByUsername = dao.getOneUserByUsername("123");
        System.out.println(oneUserByUsername);
    }


}
