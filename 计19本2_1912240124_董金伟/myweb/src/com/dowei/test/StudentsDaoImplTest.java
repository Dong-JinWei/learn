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
//			System.out.println("��ѯʧ�ܣ�������ȷ���û�ID");
//		} else {
//			System.out.println(studentsDao.queryStudentsBySId("admin"));
//		}
//	}
//
//	@Test
//	public void updateStudents() {
//
//		System.out.println(studentsDao
//				.updateStudents(new Students(3, "YangSir", "��19��2", "��", "�������ѧ�뼼��", "��Ϣ����ѧԺ", "21", "1101201300")));
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
