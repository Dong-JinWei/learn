package com.dowei.test;

import org.junit.Test;

import com.dowei.service.StudentsService;
import com.dowei.service.impl.StudentsServiceImpl;

public class StudentsServiceTest {

	private StudentsService studentsService = new StudentsServiceImpl();

	@Test
	public void queryStudents() {
		System.out.println(studentsService.queryStudents("admin"));

	}

//	@Test
//	public void modifyStudents() {
//		if (studentsService
//				.modifyStudents(new Students(4, "LeiSir", "计19本2", "男", "计算机科学与技术", "信息工程学院", "21", "12312312311"))) {
//			System.out.println("修改成功");
//		} else {
//			System.out.println("修改失败");
//		}
//	}

	@Test
	public void findStudents() {
		System.out.println(studentsService.findStudents());
	}

}
