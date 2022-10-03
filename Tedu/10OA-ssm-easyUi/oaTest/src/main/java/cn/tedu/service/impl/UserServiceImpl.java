package cn.tedu.service.impl;

import cn.tedu.dao.UserDao;
import cn.tedu.domain.User;
import cn.tedu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {

    @Autowired
    UserDao userDao;

    public List<User> findAll(String uname, Integer page, Integer rows) {
        List<User> list = userDao.findAll(uname, (page-1)*rows, rows);
        return list;
    }

    public int count(String uname) {
        int count = userDao.count(uname);
        return count;
    }


    public boolean save(User user) {
        return userDao.save(user) > 0;
    }

    public User getUserById(Integer uid) {
        System.out.println(uid);
        return userDao.getUserById(uid);
    }

    public boolean edit(User user) {
        return userDao.edit(user) > 0;
    }

    public boolean remove(List<Integer> list) {
        return userDao.remove(list) > 0;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException{
        User user = userDao.getPasswordByUserName(s);
        System.out.println(user.getUname());
        System.out.println(user.getPassword());
        if (user == null) {
            throw new UsernameNotFoundException("登陆失败！用户名或密码错误！");
        }
        return org.springframework.security.core.userdetails.User
                .withUsername(user.getUname()) // 从数据库根据用户名获取密码
                .password(user.getPassword())
                // .authorities("page:index") // 只可以访问index
                .roles(user.getRole()) // 用户角色
                .build();
    }
}
