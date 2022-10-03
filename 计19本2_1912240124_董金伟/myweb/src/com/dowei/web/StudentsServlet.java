package com.dowei.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dowei.service.StudentsService;
import com.dowei.service.impl.StudentsServiceImpl;

/**
 * Servlet implementation class StudentsServlet
 */
@WebServlet("/StudentsServlet")
public class StudentsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private StudentsService studentsService = new StudentsServiceImpl();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public StudentsServlet() {
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

		request.setCharacterEncoding("utf-8");

		HttpSession session = request.getSession(false);

		String loginName = (String) session.getAttribute("loginName");

		if (studentsService.queryStudents(loginName) == null) {
			request.setAttribute("studentsMassage", "≤È—Ø ß∞‹");
			request.getRequestDispatcher("pages/students.jsp").forward(request, response);
		} else {
			Integer messageId = studentsService.queryStudents(loginName).getsID();
			String messageSname = studentsService.queryStudents(loginName).getsName();
			String messageSclass = studentsService.queryStudents(loginName).getsClass();
			String messageSsex = studentsService.queryStudents(loginName).getsSex();
			String messageSpec = studentsService.queryStudents(loginName).getsPec();
			String messageSdept = studentsService.queryStudents(loginName).getSdept();
			String messageSage = studentsService.queryStudents(loginName).getSage();
			String messageSphone = studentsService.queryStudents(loginName).getSphone();

			request.setAttribute("messageId", messageId);
			request.setAttribute("messageSname", messageSname);
			request.setAttribute("messageSclass", messageSclass);
			request.setAttribute("messageSsex", messageSsex);
			request.setAttribute("messageSpec", messageSpec);
			request.setAttribute("messageSdept", messageSdept);
			request.setAttribute("messageSage", messageSage);
			request.setAttribute("messageSphone", messageSphone);
			request.getRequestDispatcher("pages/students.jsp").forward(request, response);
		}

	}

}
