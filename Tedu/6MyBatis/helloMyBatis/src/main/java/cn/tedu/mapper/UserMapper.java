package cn.tedu.mapper;

import cn.tedu.User;

public interface UserMapper {


//    定义用户接口，用于查询用户
    public User findUser(String u_name);
}
