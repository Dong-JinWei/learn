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

	// ʹ��DbUtils�������ݿ�
	private QueryRunner queryRunnery = new QueryRunner();

	/**
	 * update() ��������ִ�У�Insert��Update��Delete���
	 * 
	 * @return �������-1����ʾִ��ʧ��<br/>
	 *         ����������ʾִ��Ӱ�������
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
	 * ��ѯ����һ��javaBean��sql���
	 * 
	 * @param <T>  ���ص����͵ķ���
	 * @param type ���صĶ��������
	 * @param sql  ִ�е� sql ���
	 * @param args sql��Ӧ�Ĳ���ֵ
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
	 * ��ѯ���ض��javaBean��sql���
	 * 
	 * @param <T>  ���ص����͵ķ���
	 * @param type ���صĶ��������
	 * @param sql  ִ�е� sql ���
	 * @param args sql��Ӧ�Ĳ���ֵ
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
	 * ִ�з���һ��һ�еõ�sql���
	 * 
	 * @param sql  ִ�е�sql���
	 * @param args sql��Ӧ�Ĳ���ֵ
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
