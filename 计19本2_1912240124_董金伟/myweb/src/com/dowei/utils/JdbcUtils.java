package com.dowei.utils;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

public class JdbcUtils {

	private static DruidDataSource dataSource;

	static {

		try {
			Properties properties = new Properties();
			// ��ȡjdbc.properties���������ļ�
			InputStream inputStream = JdbcUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");
			// �����м�������
			properties.load(inputStream);
			// �����������ӳ�
			dataSource = (DruidDataSource) DruidDataSourceFactory.createDataSource(properties);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * ��ȡ���ݿ����ӳ��е�����
	 * 
	 * @return ���������null��˵����ȡ����ʧ�ܣ���ֵ���ǻ�ȡ�ɹ���
	 */
	public static Connection getConnection() {

		Connection conn = null;

		try {
			conn = dataSource.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return conn;
	}

	/**
	 * �ر����ӣ��Ż����ݿ����ӳ�
	 * 
	 * @param conn
	 */
	public static void close(Connection conn) {

		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
}
