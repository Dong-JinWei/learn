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
//				.modifyStudents(new Students(4, "LeiSir", "��19��2", "��", "�������ѧ�뼼��", "��Ϣ����ѧԺ", "21", "12312312311"))) {
//			System.out.println("�޸ĳɹ�");
//		} else {
//			System.out.println("�޸�ʧ��");
//		}
//	}

	@Test
	public void findStudents() {
		System.out.println(studentsService.findStudents());
	}

}
