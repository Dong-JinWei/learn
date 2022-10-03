package com.tedu.service;

import com.tedu.pojo.User;

import java.util.List;

public interface UserService {
    /**
     * 1.查询所有用户
     */
    public List<User> findAll(String uname,Integer page,Integer rows);
    /**
     * 2. 统计用户数量
     */
    public int count(String uname);
    /**
     * 3.添加用户
     */
    public boolean save(User user);
    /**
     * 4.根据id查询用户
     */
    User getUserById(Integer uid);

    /**
     * 5.修改用户
     */
    public boolean edit(User user);

    boolean remove(List<Integer> list);
}
