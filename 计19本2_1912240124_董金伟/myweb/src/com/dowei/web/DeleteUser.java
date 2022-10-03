package com.dowei.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dowei.service.UserService;
import com.dowei.service.impl.UserServiceImpl;

/**
 * Servlet implementation class DeleteUser
 */
@WebServlet("/DeleteUser")
public class DeleteUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UserService userService = new UserServiceImpl();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeleteUser() {
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
		Integer id = Integer.parseInt(request.getParameter("deleteUser"));

		if (userService.deleteUser(id) == false) {
			System.out.println("执行失败");
			request.setAttribute("deleteUserMsg", "删除失败，请检查用户是否存在或输入是否正确");
			request.getRequestDispatcher("pages/deleteUser.jsp").forward(request, response);
		} else {
			System.out.println("执行成功");
			request.setAttribute("deleteUserMsg", "删除成功，请返回查看");
			request.getRequestDispatcher("pages/deleteUser.jsp").forward(request, response);

		}

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
