package cn.tedu.mapper;

import cn.tedu.bean.User;

public interface UserMapper {
    public User findUser(String u_name);

//    增
    public int insertUser(String user);

//    删
    public int delUser(String u_name);

//    改
    public int updateUser();

}
