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
			System.out.println("ִ��ʧ��");
			request.setAttribute("deleteUserMsg", "ɾ��ʧ�ܣ������û��Ƿ���ڻ������Ƿ���ȷ");
			request.getRequestDispatcher("pages/deleteUser.jsp").forward(request, response);
		} else {
			System.out.println("ִ�гɹ�");
			request.setAttribute("deleteUserMsg", "ɾ���ɹ����뷵�ز鿴");
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
