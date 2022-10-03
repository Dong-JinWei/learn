package com.dowei.dao.impl;

import java.util.List;

import com.dowei.dao.UserDao;
import com.dowei.pojo.User;

public class UserDaoImpl extends BaseDao implements UserDao {

	@Override
	public User queryUserByUsername(Integer userID) {
		// TODO Auto-generated method stub
		String sql = "select * from t_user where id=?";
		return queryForOne(User.class, sql, userID);
	}

	@Override
	public User queryUserByUsernameAndPassword(Integer id, String username, String password) {
		// TODO Auto-generated method stub
		String sql = "select * from t_user where id=? and username=? and password=?";
		return queryForOne(User.class, sql, id, username, password);
	}

	@Override
	public int saveUser(User user) {
		// TODO Auto-generated method stub
		String sql = "insert into t_user(id,username,password,sex,age,phone,mail) values(?,?,?,?,?,?,?);";
		return update(sql, user.getId(), user.getUsername(), user.getPassword(), user.getSex(), user.getAge(),
				user.getPhone(), user.getMail());
	}

	@Override
	public int deleteUser(Integer id) {
		// TODO Auto-generated method stub
		String sql = " delete from t_user where id=?";
		return update(sql, id);
	}

	@Override
	public int updateUser(User user) {
		// TODO Auto-generated method stub
		String sql = "update t_user set username=?,password=?,sex=?,age=?,phone=?,mail=?  where id=?";
		return update(sql, user.getUsername(), user.getPassword(), user.getSex(), user.getAge(), user.getPhone(),
				user.getMail(), user.getId());
	}

	@Override
	public List<User> queryAllUser() {
		// TODO Auto-generated method stub
		String sql = "select * from t_user";
		return queryForList(User.class, sql);
	}

}
