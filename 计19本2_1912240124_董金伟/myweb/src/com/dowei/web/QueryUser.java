package com.dowei.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dowei.pojo.User;
import com.dowei.service.UserService;
import com.dowei.service.impl.UserServiceImpl;

/**
 * Servlet implementation class QueryUser
 */
@WebServlet("/QueryUser")
public class QueryUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService userService = new UserServiceImpl();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public QueryUser() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");

		List<Map<?, ?>> userList = new ArrayList<Map<?, ?>>();

		List<User> list = userService.findUser();

		for (User user : list) {
			String id = "" + user.getId();
			String username = user.getUsername();
			String password = user.getPassword();
			String sex = user.getSex();
			String age = user.getAge();
			String phone = user.getPhone();
			String mail = user.getMail();

			Map<String, String> userMap = new HashMap<String, String>();
			userMap.put("id", id);
			userMap.put("username", username);
			userMap.put("password", password);
			userMap.put("sex", sex);
			userMap.put("age", age);
			userMap.put("phone", phone);
			userMap.put("mail", mail);

			userList.add(userMap);
		}

		request.setAttribute("userList", userList);
		request.getRequestDispatcher("pages/queryUser.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
