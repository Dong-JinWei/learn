package com.dowei.service;

import java.util.List;

import com.dowei.pojo.CourseAndScorse;

public interface CourseAndScorseService {
	/**
	 * 根据id查询用户信息
	 * 
	 * @param username
	 * @return 返回这个用户的信息
	 */
	public List<CourseAndScorse> queryScourseAndScorse(String username);

	/**
	 * 选课系统
	 * 
	 * @param courseAndScorse
	 * @return 返回-1 表示失败，返回其他sql语句影响的行数
	 */
	public int selectScorse(CourseAndScorse courseAndScorse);

	/**
	 * 修改成绩
	 * 
	 * @param courseAndScorse
	 * @return 返回-1 表示失败，返回其他sql语句影响的行数
	 */
	public int insertScorse(CourseAndScorse courseAndScorse);

}
