package com.dowei.service.impl;

import java.util.List;

import com.dowei.dao.StudentsDao;
import com.dowei.dao.impl.StudentsDaoImpl;
import com.dowei.pojo.Students;
import com.dowei.service.StudentsService;

public class StudentsServiceImpl implements StudentsService {
	private StudentsDao StudentsDao = new StudentsDaoImpl();

	@Override
	public Students queryStudents(String username) {
		// TODO Auto-generated method stub
		return StudentsDao.queryStudentsBySId(username);
	}

	@Override
	public boolean modifyStudents(Students stu) {
		// TODO Auto-generated method stub
		if (StudentsDao.updateStudents(stu) == -1) {
			return false;
		}
		return true;
	}

	@Override
	public boolean insertStudents(Students stu) {

		if (StudentsDao.saveStudents(stu) == -1) {
			return false;
		}
		return true;
	}

	@Override
	public List<Students> findStudents() {
		// TODO Auto-generated method stub
		return StudentsDao.queryAllStudents();
	}

}
