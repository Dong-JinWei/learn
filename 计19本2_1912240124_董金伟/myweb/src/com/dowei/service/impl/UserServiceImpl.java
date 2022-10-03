package com.dowei.service.impl;

import java.util.List;

import com.dowei.dao.UserDao;
import com.dowei.dao.impl.UserDaoImpl;
import com.dowei.pojo.User;
import com.dowei.service.UserService;

public class UserServiceImpl implements UserService {

	private UserDao userDao = new UserDaoImpl();

	@Override
	public void registUser(User user) {
		// TODO Auto-generated method stub
		userDao.saveUser(user);

	}

	@Override
	public User login(User user) {
		// TODO Auto-generated method stub
		return userDao.queryUserByUsernameAndPassword(user.getId(), user.getUsername(), user.getPassword());
	}

	@Override
	public boolean existsUsername(Integer userID) {
		// TODO Auto-generated method stub
		if (userDao.queryUserByUsername(userID) == null) {
			return false;
		}
		return true;
	}

	@Override
	public boolean deleteUser(Integer id) {
		// TODO Auto-generated method stub
		if (userDao.deleteUser(id) == 0) {
			return false;
		}
		return true;

	}

	@Override
	public List<User> findUser() {
		// TODO Auto-generated method stub
		return userDao.queryAllUser();
	}

	@Override
	public boolean modifyUser(User user) {
		// TODO Auto-generated method stub

		if (userDao.updateUser(new User(user.getUsername(), user.getPassword(), user.getSex(), user.getAge(),
				user.getPhone(), user.getMail(), user.getId())) == -1)
			return false;
		return true;
	}

}
