package com.dowei.service.impl;

import java.util.List;

import com.dowei.dao.CourseAndScorseDao;
import com.dowei.dao.impl.CourseAndScorseDaoImpl;
import com.dowei.pojo.CourseAndScorse;
import com.dowei.service.CourseAndScorseService;

public class CourseAndScorseServiceImpl implements CourseAndScorseService {

	private CourseAndScorseDao courseAndScorseDao = new CourseAndScorseDaoImpl();

	@Override
	public List<CourseAndScorse> queryScourseAndScorse(String username) {
		// TODO Auto-generated method stub

		return courseAndScorseDao.queryScoreByName(username);
	}

	@Override
	public int selectScorse(CourseAndScorse courseAndScorse) {
		// TODO Auto-generated method stub
		return courseAndScorseDao.selectScorse(courseAndScorse);
	}

	@Override
	public int insertScorse(CourseAndScorse courseAndScorse) {
		// TODO Auto-generated method stub
		return courseAndScorseDao.insertScorse(courseAndScorse);
	}

}
