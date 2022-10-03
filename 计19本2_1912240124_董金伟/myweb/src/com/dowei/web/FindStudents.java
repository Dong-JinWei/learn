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

import com.dowei.pojo.Students;
import com.dowei.service.StudentsService;
import com.dowei.service.impl.StudentsServiceImpl;

/**
 * Servlet implementation class FindStudents
 */
@WebServlet("/FindStudents")
public class FindStudents extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private StudentsService studentsService = new StudentsServiceImpl();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FindStudents() {
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

		List<Map<?, ?>> studentsList = new ArrayList<Map<?, ?>>();

		List<Students> list = studentsService.findStudents();

		for (Students students : list) {
			String id = "" + students.getsID();
			String username = students.getsName();
			String sclass = students.getsClass();
			String sex = students.getsSex();
			String spec = students.getsPec();
			String dept = students.getSdept();
			String sage = students.getSage();
			String phone = students.getSphone();

			Map<String, String> studetnsMap = new HashMap<String, String>();
			studetnsMap.put("id", id);
			studetnsMap.put("username", username);
			studetnsMap.put("sclass", sclass);
			studetnsMap.put("sex", sex);
			studetnsMap.put("spec", spec);
			studetnsMap.put("dept", dept);
			studetnsMap.put("sage", sage);
			studetnsMap.put("phone", phone);

			studentsList.add(studetnsMap);
		}

		request.setAttribute("studentsList", studentsList);
		request.getRequestDispatcher("pages/findStudents.jsp").forward(request, response);
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
