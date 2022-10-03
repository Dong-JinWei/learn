package com.login.mapper;

import com.login.entity.User;

/**
 * 用户接口类
 */
public interface UserMapper {
    public User queryUserByName(String userName);
}
