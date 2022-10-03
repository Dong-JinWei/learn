package cn.tedu.dao;

import cn.tedu.bean.User;

public interface UserDao {
    public int findUser(User user);

    public int addUser(User user);

    public int findUserByName(String username);
}
