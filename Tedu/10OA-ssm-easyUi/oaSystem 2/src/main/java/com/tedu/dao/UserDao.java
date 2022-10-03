package com.tedu.dao;

import com.tedu.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface UserDao {
    /**
     * 1.查询所有用户
     */
    public List<User> findAll(@Param("uname")String uname,
                              @Param("page")Integer page,
                              @Param("rows")Integer rows);

    /**
     * 2. 统计用户数量
     */
    public int count(@Param("uname")String uname);

    /**
     * 3.添加用户
     */
    public int save(User user);

    /**
     * 4.根据id查询用户
     */
    User getUserById(Integer uid);


    public int edit(User user);

    int remove(List<Integer> list);


}
