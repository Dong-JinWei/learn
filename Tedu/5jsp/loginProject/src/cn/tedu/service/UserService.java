package cn.tedu.service;

import cn.tedu.bean.User;
import cn.tedu.dao.UserDao;
import cn.tedu.dao.UserDaoImp;

public class UserService {
    UserDao dao = new UserDaoImp();
    public boolean findUser(User user){
        int res = dao.findUser(user);
        return res > 0;
    }

    public boolean addUser(User user){
        int res = dao.addUser(user);
        return res > 0;
    }

    public boolean findUserByName(String username){
        int ok = dao.findUserByName(username);
        return ok > 0;
    }
}
