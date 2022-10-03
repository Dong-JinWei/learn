package com.dowei.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.dowei.utils.JdbcUtils;

public abstract class BaseDao {

	// 使用DbUtils操作数据库
	private QueryRunner queryRunnery = new QueryRunner();

	/**
	 * update() 方法用来执行：Insert、Update、Delete语句
	 * 
	 * @return 如果返回-1，表示执行失败<br/>
	 *         返回其他表示执行影响的行数
	 */
	public int update(String sql, Object... args) {
		Connection connection = JdbcUtils.getConnection();

		try {
			return queryRunnery.update(connection, sql, args);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JdbcUtils.close(connection);
		}
		return -1;
	}

	/**
	 * 查询返回一个javaBean的sql语句
	 * 
	 * @param <T>  返回的类型的泛型
	 * @param type 返回的对象的类型
	 * @param sql  执行的 sql 语句
	 * @param args sql对应的参数值
	 * @return
	 */
	public <T> T queryForOne(Class<T> type, String sql, Object... args) {
		Connection connection = JdbcUtils.getConnection();
		try {
			return queryRunnery.query(connection, sql, new BeanHandler<T>(type), args);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JdbcUtils.close(connection);
		}
		return null;
	}

	/**
	 * 查询返回多个javaBean的sql语句
	 * 
	 * @param <T>  返回的类型的泛型
	 * @param type 返回的对象的类型
	 * @param sql  执行的 sql 语句
	 * @param args sql对应的参数值
	 * @return
	 */
	public <T> List<T> queryForList(Class<T> type, String sql, Object... args) {
		Connection connection = JdbcUtils.getConnection();
		try {
			return queryRunnery.query(connection, sql, new BeanListHandler<T>(type), args);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JdbcUtils.close(connection);
		}
		return null;
	}

	/**
	 * 执行返回一行一列得到sql语句
	 * 
	 * @param sql  执行的sql语句
	 * @param args sql对应的参数值
	 * @return
	 */
	public Object queryForSingleValue(String sql, Object... args) {
		Connection connection = JdbcUtils.getConnection();

		try {
			return queryRunnery.query(connection, sql, new ScalarHandler(), args);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JdbcUtils.close(connection);
		}
		return null;
	}

	public Object queryAllin(String sql) {
		Connection connection = JdbcUtils.getConnection();

		try {
			return queryRunnery.query(connection, sql, new ScalarHandler());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JdbcUtils.close(connection);
		}
		return null;
	}

}
