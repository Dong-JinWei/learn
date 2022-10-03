package com.dowei.test;

import org.junit.Test;

import com.dowei.dao.UserDao;
import com.dowei.dao.impl.UserDaoImpl;
import com.dowei.pojo.User;

public class UserDaoTest {
	UserDao userDao = new UserDaoImpl();
	User user = new User();

//	@Test
//	public void queryUserByUsername() {
//
//		if (userDao.queryUserByUsername(1) == null) {
//			System.out.println("用户名可用");
//		} else {
//			System.out.println("用户名不可用");
//		}
//
//	}
//
//	@Test
//	public void queryUserByUsernameAndPassword() {
//		if (userDao.queryUserByUsernameAndPassword(2, "dowei", "dowei") == null) {
//			System.out.println("用户名或密码错误，登录失败！");
//		} else {
//			System.out.println("查询成功！");
//		}
//	}

//	@Test
//	public void saveUser() {
//		System.out.println(
//				userDao.saveUser(new User(null, "YangSir", "1234", "男", "21", "12345678910", "YangSir@qq.com")));
//
//	}

//	@Test
//	public void deleteUser() {
//		System.out.println(userDao.deleteUser(15));
//	}

//	@Test
//	public void queryAllUser() {
//		List<User> listUser = userDao.queryAllUser();
//
//		for (User user : listUser) {
//			System.out.println(user);
//		}
//	}

	@Test
	public void updateUser() {
		System.out.println(userDao.updateUser(new User("pp", "123", "男", "41", "12341234", "123@qq.com", 14)));
	}
}
