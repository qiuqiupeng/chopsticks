/*********************************************************************
 * 源代码版权归作者（们）所有
 *
 * 以 Apache License, Version 2.0 方式授权使用，具体参见：
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 ********************************************************************/
package me.leep.wf.services;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.log4j.jdbc.JDBCAppender;
import org.apache.log4j.spi.ErrorCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

/**
 * @author 李鹏
 * 
 * 
 */
@Component
public class BonecpPoolAppender extends JDBCAppender {

	@Autowired
	private DataSource dataSource;
	protected Connection connection;

	/**
	 * 
	 */
	public BonecpPoolAppender() {
	}

	@Override
	protected void closeConnection(Connection con) {
		try {
			if (connection != null && !connection.isClosed())
				connection.close();
		} catch (SQLException e) {
			errorHandler.error("Error closing connection", e,
					ErrorCode.GENERIC_FAILURE);
		}
	}

	@Override
	protected Connection getConnection() throws SQLException {
		if (connection != null && !connection.isClosed()) {
			return connection;
		} else {
			try {
				if (dataSource == null) {
					dataSource = (DataSource) new ClassPathXmlApplicationContext(
							"classpath:spring_ds.xml").getBean("dataSource");
				}

				// Properties p = PropertiesUtil.loadPropertiesFile(FileUtil
				// .getFile("hibernate.properties"));
				//
				// Class.forName(p.getProperty("hibernate.connection.driver"));
				// String url = p.getProperty("hibernate.connection.url");
				// String username = p
				// .getProperty("hibernate.connection.username");
				// String password = p
				// .getProperty("hibernate.connection.password");
				// connection = DriverManager.getConnection(url, username,
				// password);
				// } else
				connection = dataSource.getConnection();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			return connection;
		}

	}

	/**
	 * @param connection
	 *            要设置的 connection
	 */
	public void setConnection(Connection connection) {
		this.connection = connection;
	}

}
