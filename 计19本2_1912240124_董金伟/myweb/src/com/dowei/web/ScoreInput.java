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
 * Servlet implementation class ScoreInput
 */
@WebServlet("/ScoreInput")

public class ScoreInput extends HttpServlet {
	private static final long serialVersionUID = 1L;
	CourseAndScorseService courseAndScorseService = new CourseAndScorseServiceImpl();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ScoreInput() {
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

		String javaWebScore = request.getParameter("JavaWeb");
		String mySQLScore = request.getParameter("MySQL");
		String javaScore = request.getParameter("JAVA");

		HttpSession session = request.getSession();
		String id = "" + session.getAttribute("userId");

		int scoreFlag = 0;

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

		if (scoreFlag > 0) {
			request.setAttribute("scoreSucces", "成绩输入成功");
			request.getRequestDispatcher("pages/students.jsp").forward(request, response);
		} else {
			request.setAttribute("scoreSucces", "选课失败，请输入有效的成绩");
			request.getRequestDispatcher("pages/scoreinput.jsp").forward(request, response);
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
