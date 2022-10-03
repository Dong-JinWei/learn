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

import com.dowei.pojo.CourseAndScorse;
import com.dowei.service.CourseAndScorseService;
import com.dowei.service.impl.CourseAndScorseServiceImpl;

/**
 * Servlet implementation class CourseAndScorseServlet
 */
@WebServlet("/CourseAndScorseServlet")
public class CourseAndScorseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	CourseAndScorseService courseAndScorseService = new CourseAndScorseServiceImpl();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CourseAndScorseServlet() {
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

		List<Map<?, ?>> ScorseList = new ArrayList<Map<?, ?>>();

		String sButton = request.getParameter("sButton");

		List<CourseAndScorse> list = courseAndScorseService.queryScourseAndScorse(sButton);

		for (CourseAndScorse courseAndScorse : list) {
			String cno = courseAndScorse.getCno();
			String cname = courseAndScorse.getCname();
			String ctecher = courseAndScorse.getCtecher();
			String scid = courseAndScorse.getScid();
			String scno = courseAndScorse.getScno();
			String score = courseAndScorse.getScore();

			Map<String, String> scoresMap = new HashMap<String, String>();
			scoresMap.put("cno", cno);
			scoresMap.put("cname", cname);
			scoresMap.put("ctecher", ctecher);
			scoresMap.put("scid", scid);
			scoresMap.put("scno", scno);
			scoresMap.put("score", score);

			ScorseList.add(scoresMap);
		}

		request.setAttribute("ScorseList", ScorseList);
		request.getRequestDispatcher("pages/courseAndScorse.jsp").forward(request, response);

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
