package com.dowei.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dowei.pojo.User;
import com.dowei.service.UserService;
import com.dowei.service.impl.UserServiceImpl;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegisterServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		UserService userService = new UserServiceImpl();
		// 1、获取请求的参数
		Integer id = Integer.parseInt(request.getParameter("uid"));
		String username = request.getParameter("uname");
		String password = request.getParameter("upwd");
		String sex = request.getParameter("sex");
		String age = request.getParameter("age");
		String number = request.getParameter("number");
		String mail = request.getParameter("mail");

		if (userService.existsUsername(id)) {

			request.setAttribute("message", "注册失败！用户ID[ " + id + " ]已存在");
			// 跳回注册页面
			request.getRequestDispatcher("pages/register.jsp").forward(request, response);
		} else {
			request.setAttribute("message", "注册成功");
			userService.registUser(new User(id, username, password, sex, age, number, mail));
			request.getRequestDispatcher("pages/registerSucces.jsp").forward(request, response);
		}

	}
}
