package com.dowei.service;

import java.util.List;

import com.dowei.pojo.Students;

public interface StudentsService {

	/**
	 * 根据id查询用户信息
	 * 
	 * @param stu
	 * @return 返回这个用户的信息
	 */
	public Students queryStudents(String username);

	/**
	 * 修改学生信息
	 * 
	 * @param stu
	 * @return 成功返回true，失败返回false
	 */
	public boolean modifyStudents(Students stu);

	/**
	 * 插入学生
	 * 
	 * @param stu
	 * @return
	 */
	public boolean insertStudents(Students stu);

	/**
	 * 查看所有学生
	 * 
	 * @return
	 */
	public List<Students> findStudents();

}
