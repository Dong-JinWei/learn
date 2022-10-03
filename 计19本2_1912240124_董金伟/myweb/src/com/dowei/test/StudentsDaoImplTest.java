package com.dowei.test;

import java.util.List;

import org.junit.Test;

import com.dowei.dao.StudentsDao;
import com.dowei.dao.impl.StudentsDaoImpl;
import com.dowei.pojo.Students;

public class StudentsDaoImplTest {

	StudentsDao studentsDao = new StudentsDaoImpl();
//
//	@Test
//	public void queryStudentsBySId() {
//
//		if (studentsDao.queryStudentsBySId("admin") == null) {
//			System.out.println("查询失败，输入正确的用户ID");
//		} else {
//			System.out.println(studentsDao.queryStudentsBySId("admin"));
//		}
//	}
//
//	@Test
//	public void updateStudents() {
//
//		System.out.println(studentsDao
//				.updateStudents(new Students(3, "YangSir", "计19本2", "男", "计算机科学与技术", "信息工程学院", "21", "1101201300")));
//
//	}

	@Test
	public void queryAllStudents() {
		List<Students> listStudents = studentsDao.queryAllStudents();

		for (Students students : listStudents) {
			System.out.println(students);
		}
	}

}
