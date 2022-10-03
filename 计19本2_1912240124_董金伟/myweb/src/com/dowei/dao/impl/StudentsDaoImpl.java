package com.dowei.dao.impl;

import java.util.List;

import com.dowei.dao.StudentsDao;
import com.dowei.pojo.Students;

public class StudentsDaoImpl extends BaseDao implements StudentsDao {

	@Override
	public Students queryStudentsBySId(String username) {
		// TODO Auto-generated method stub
		String sql = "select * from students where sname=?";
		return queryForOne(Students.class, sql, username);
	}

	@Override
	public int updateStudents(Students students) {
		// TODO Auto-generated method stub
		String sql = "update students set sname=?,sclass=?,ssex=?,spec=?,sdept=?,sage=?,sphone=? where sid=?";
		return update(sql, students.getsName(), students.getsClass(), students.getsSex(), students.getsPec(),
				students.getSdept(), students.getSage(), students.getSphone(), students.getsID());
	}

	@Override
	public int saveStudents(Students students) {

		String sql = "insert into students(sid,sname,sclass,ssex,spec,sdept,sage,sphone) values(?,?,?,?,?,?,?,?)";
		return update(sql, students.getsID(), students.getsName(), students.getsClass(), students.getsSex(),
				students.getsPec(), students.getSdept(), students.getSage(), students.getSphone());
	}

	@Override
	public List<Students> queryAllStudents() {
		// TODO Auto-generated method stub
		String sql = "select * from students";
		return queryForList(Students.class, sql);
	}

}
