package com.dowei.test;

import org.junit.Test;

import com.dowei.pojo.User;
import com.dowei.service.UserService;
import com.dowei.service.impl.UserServiceImpl;

public class UserServiceTest {

	UserService userService = new UserServiceImpl();

//	@Test
//	public void registUser() {
//		// TODO Auto-generated method stub
//		userService.registUser(new User(null, "LeiSir", "1234", "男", "20", "1231231231", "LeiSir@qq.com"));
//	}

//	@Test
//	public void login() {
//		// TODO Auto-generated method stub
//		System.out
//				.println(userService.login(new User(null, "LeiSir", "1234", "男", "20", "1231231231", "LeiSir@qq.com")));
//	}
//
//	@Test
//	public void existsUsername() {
//		// TODO Auto-generated method stub
//		if (userService.existsUsername(7)) {
//			System.out.println("用户名已存在");
//		} else {
//			System.out.println("用户名可用");
//		}
//
//	}

//	@Test
//	public void deleteUser() {
//		System.out.println(userService.deleteUser(17));
//	}

//	@Test
//	public void findUser() {
//		System.out.println(userService.findUser());
//	}

	@Test
	public void midfiyUser() {
		System.out.println(userService.modifyUser(new User("ww", "123", "男", "20", "1231231231", "22@qq.com", 14)));
	}

}
