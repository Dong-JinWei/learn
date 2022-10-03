package com.dowei.dao.impl;

import java.util.List;

import com.dowei.dao.CourseAndScorseDao;
import com.dowei.pojo.CourseAndScorse;

public class CourseAndScorseDaoImpl extends BaseDao implements CourseAndScorseDao {

	@Override
	public List<CourseAndScorse> queryScoreByName(String username) {
		// TODO Auto-generated method stub

		String sql = "select s.scid,u.username,c.cno,s.scno,c.ctecher,c.cname,s.score from score as s join course as c on s.scno=c.cno join t_user as u on s.scid=u.id where u.username=?";

		return queryForList(CourseAndScorse.class, sql, username);
	}

	@Override
	public int selectScorse(CourseAndScorse courseAndScorse) {
		// TODO Auto-generated method stub

		String sql = "insert into score(scid,scno) values(?,?)";
		return update(sql, courseAndScorse.getScid(), courseAndScorse.getScno());
	}

	@Override
	public int insertScorse(CourseAndScorse courseAndScorse) {
		// TODO Auto-generated method stub
		String sql = "update score set score=? where scid=? and scno=?";
		return update(sql, courseAndScorse.getScore(), courseAndScorse.getScid(), courseAndScorse.getScno());
	}

}
