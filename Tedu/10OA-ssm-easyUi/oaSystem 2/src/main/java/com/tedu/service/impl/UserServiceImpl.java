package com.tedu.service.impl;

import com.tedu.dao.UserDao;
import com.tedu.pojo.User;
import com.tedu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl  implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public List<User> findAll(String uname,Integer page,Integer rows) {

        return userDao.findAll(uname,(page-1)*rows,rows);
    }

    @Override
    public int count(String uname) {
        return userDao.count(uname);
    }

    @Override
    public boolean save(User user) {
        return userDao.save(user)>0;
    }

    @Override
    public User getUserById(Integer uid) {
        return userDao.getUserById(uid);
    }

    @Override
    public boolean edit(User user) {
        return userDao.edit(user)>0;
    }

    @Override
    public boolean remove(List<Integer> list) {
        return userDao.remove(list)>0;
    }

}
