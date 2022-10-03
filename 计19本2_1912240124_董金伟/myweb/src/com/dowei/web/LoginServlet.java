package com.dowei.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dowei.pojo.User;
import com.dowei.service.UserService;
import com.dowei.service.impl.UserServiceImpl;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService userService = new UserServiceImpl();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		Integer id = Integer.parseInt(request.getParameter("ID"));
		String username = request.getParameter("uname");
		String password = request.getParameter("upwd");

		User user = new User(id, username, password);

		if ((userService.login(user) == null)) {
			request.setAttribute("message", "登录失败，ID，用户名或密码不能为空");
			request.getRequestDispatcher("pages/login.jsp").forward(request, response);
		} else {
			request.setAttribute("message", username);
			HttpSession session = request.getSession(true);
			session.setAttribute("userId", id);
			session.setAttribute("loginName", username);

			request.getRequestDispatcher("pages/students.jsp").forward(request, response);
		}
	}

}
