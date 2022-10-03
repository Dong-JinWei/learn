package com.dowei.dao;

import java.util.List;

import com.dowei.pojo.Students;

public interface StudentsDao {

	/**
	 * 根据用户名查看用户的信息
	 * 
	 * @param sId
	 * @return 放回这个对象students
	 */
	public Students queryStudentsBySId(String username);

	/**
	 * 修改学生信息
	 * 
	 * @param students
	 * @return 返回-1 表示失败，返回其他sql语句影响的行数
	 */
	public int updateStudents(Students students);

	/**
	 * 保存学生信息
	 * 
	 * @param students
	 * @return 返回-1 表示失败，返回其他sql语句影响的行数
	 */
	public int saveStudents(Students students);

	/**
	 * 查询所有的学生
	 * 
	 * @return
	 */
	public List<Students> queryAllStudents();

}
