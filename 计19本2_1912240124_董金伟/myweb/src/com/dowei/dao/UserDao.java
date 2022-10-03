package com.dowei.dao;

import java.util.List;

import com.dowei.pojo.User;

public interface UserDao {

	/**
	 * 根据用户名查询信息
	 * 
	 * @param username
	 * @return 如果返回null，说明没有这个用户
	 */
	public User queryUserByUsername(Integer userID);

	/**
	 * 删除用户
	 * 
	 * @param user
	 * @return 返回-1 表示失败，返回其他sql语句影响的行数
	 */
	public int deleteUser(Integer id);

	/**
	 * 修改用户信息
	 * 
	 * @param user
	 * @return 返回-1 表示失败，返回其他sql语句影响的行数
	 */
	public int updateUser(User user);

	/**
	 * 根据用户id和密码查询
	 * 
	 * @param id       用户id
	 * @param password 用户密码
	 * @return 如果返回null，说明用户id或密码错误
	 */
	public User queryUserByUsernameAndPassword(Integer id, String username, String password);

	/**
	 * 保存用户信息
	 * 
	 * @param user
	 * @return 返回-1 表示失败，返回其他sql语句影响的行数
	 */
	public int saveUser(User user);

	/**
	 * 查询所有的用户
	 * 
	 * @return
	 */
	public List<User> queryAllUser();

}
