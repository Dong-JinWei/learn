package com.dowei.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dowei.pojo.Students;
import com.dowei.service.StudentsService;
import com.dowei.service.UserService;
import com.dowei.service.impl.StudentsServiceImpl;
import com.dowei.service.impl.UserServiceImpl;

/**
 * Servlet implementation class StudentsRegisterServlet
 */
@WebServlet("/StudentsRegisterServlet")
public class StudentsRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UserService userService = new UserServiceImpl();
	private StudentsService studentsService = new StudentsServiceImpl();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public StudentsRegisterServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		// TODO Auto-generated method stub
		Integer sid = Integer.parseInt(request.getParameter("uid"));
		String username = request.getParameter("uname");
		String sclass = request.getParameter("sclass");
		String sex = request.getParameter("sex");
		String spec = request.getParameter("spec");
		String sdept = request.getParameter("sdept");
		String age = request.getParameter("age");
		String number = request.getParameter("number");

		Students stu1 = new Students(sid, username, sclass, sex, spec, sdept, age, number);
		Students stu2 = new Students(username, sclass, sex, spec, sdept, age, number, sid);

		if (userService.existsUsername(sid)) {
			if (studentsService.insertStudents(stu1) == false) {
				studentsService.modifyStudents(stu2);
			}
			request.setAttribute("message", "注册成功，请重新登录");
			request.getRequestDispatcher("pages/students.jsp").forward(request, response);
		} else {
			request.setAttribute("stReMessage", "用户不存在");
			request.getRequestDispatcher("pages/studentsRegister.jsp").forward(request, response);

		}

	}

}
