package com.dowei.service;

import java.util.List;

import com.dowei.pojo.User;

public interface UserService {

	/**
	 * 注册用户
	 * 
	 * @param user
	 */
	public void registUser(User user);

	/**
	 * 删除用户
	 * 
	 * @param user
	 */
	public boolean deleteUser(Integer id);

	/**
	 * 登录
	 * 
	 * @param user
	 * @return 如果返回null，说明登录失败，返回有值，是登录成功
	 */
	public User login(User user);

	/**
	 * 检查用户名是否可用
	 * 
	 * @param username
	 * @return 返回true表示用户名已存在，返回false表示用户名可用
	 */
	public boolean existsUsername(Integer userID);

	/**
	 * 查看所有用户
	 * 
	 * @return
	 */
	public List<User> findUser();

	/**
	 * 修改用户信息
	 * 
	 * @return
	 */
	public boolean modifyUser(User user);

}
