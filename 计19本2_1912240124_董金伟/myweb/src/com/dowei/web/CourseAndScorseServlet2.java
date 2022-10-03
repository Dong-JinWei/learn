package com.dowei.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dowei.pojo.CourseAndScorse;
import com.dowei.service.CourseAndScorseService;
import com.dowei.service.impl.CourseAndScorseServiceImpl;

/**
 * Servlet implementation class CourseAndScorseServlet2
 */
@WebServlet("/CourseAndScorseServlet2")
public class CourseAndScorseServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	CourseAndScorseService courseAndScorseService = new CourseAndScorseServiceImpl();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CourseAndScorseServlet2() {
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

		String courses1 = request.getParameter("courses[1]");
		String courses2 = request.getParameter("courses[2]");
		String courses3 = request.getParameter("courses[3]");

		String javaWebScore = request.getParameter("JavaWeb");
		String mySQLScore = request.getParameter("MySQL");
		String javaScore = request.getParameter("JAVA");

		HttpSession session = request.getSession();
		String id = "" + session.getAttribute("userId");

		int courseFlag = 0;
		int scoreFlag = 0;

		if (courses1 != null) {
			courseAndScorseService.selectScorse(new CourseAndScorse(id, "1001"));
			courseFlag++;
		}

		if (courses2 != null) {
			courseAndScorseService.selectScorse(new CourseAndScorse(id, "1002"));
			courseFlag++;
		}
		if (courses3 != null) {
			courseAndScorseService.selectScorse(new CourseAndScorse(id, "1003"));
			courseFlag++;
		}

		if (javaWebScore != null) {
			courseAndScorseService.insertScorse(new CourseAndScorse(javaWebScore, id, "1001"));
			scoreFlag++;
		}
		if (mySQLScore != null) {
			courseAndScorseService.insertScorse(new CourseAndScorse(mySQLScore, id, "1002"));
			scoreFlag++;
		}
		if (javaScore != null) {
			courseAndScorseService.insertScorse(new CourseAndScorse(javaScore, id, "1003"));
			scoreFlag++;
		}

		if (courseFlag > 0) {
			request.setAttribute("courseSucces", "选课成功，请输入成绩");

			request.getRequestDispatcher("pages/scoreinput.jsp").forward(request, response);
		} else {
			request.setAttribute("courseSucces", "选课失败，请至少选择一门课程");
			request.getRequestDispatcher("pages/courseAndScorse2.jsp").forward(request, response);

			if (scoreFlag > 0) {
				request.setAttribute("scoreSucces", "成绩输入成功");
				request.getRequestDispatcher("pages/students.jsp").forward(request, response);
			} else {
				request.setAttribute("scoreSucces", "选课失败，请输入有效的成绩");
				request.getRequestDispatcher("pages/scoreinput.jsp").forward(request, response);
			}
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
