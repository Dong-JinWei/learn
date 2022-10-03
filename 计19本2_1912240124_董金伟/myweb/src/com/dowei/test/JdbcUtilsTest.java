package com.dowei.test;

import java.sql.Connection;

import org.junit.Test;

import com.dowei.utils.JdbcUtils;

public class JdbcUtilsTest {

	@Test
	public void testJdbcUtils() {

		for (int i = 0; i < 100; i++) {
			Connection connection = JdbcUtils.getConnection();
			System.out.println(connection);
			JdbcUtils.close(connection);
		}

	}

}
