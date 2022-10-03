package cn.tedu.service.impl;

import cn.tedu.mapper.UserMapper;
import cn.tedu.pojo.User;
import cn.tedu.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    UserMapper userMapper;
    @Override
    public User getUserById(int uid) {
        return userMapper.getUserById(uid);
    }

}
