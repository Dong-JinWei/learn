package com.dowei.dao;

import java.util.List;

import com.dowei.pojo.CourseAndScorse;

public interface CourseAndScorseDao {

	/**
	 * 根据用户名字查看用户可课程和成绩
	 * 
	 * @param username 用户名
	 * @return 返回这个对象CourseAndScorese
	 */
	public List<CourseAndScorse> queryScoreByName(String username);

	/**
	 * 选择课程
	 * 
	 * @param courseAndScorse
	 * @return 返回-1 表示失败，返回其他sql语句影响的行数
	 */
	public int selectScorse(CourseAndScorse courseAndScorse);

	/**
	 * 录入成绩
	 * 
	 * @param courseAndScorse
	 * @return 返回-1 表示失败，返回其他sql语句影响的行数
	 */
	public int insertScorse(CourseAndScorse courseAndScorse);
}
