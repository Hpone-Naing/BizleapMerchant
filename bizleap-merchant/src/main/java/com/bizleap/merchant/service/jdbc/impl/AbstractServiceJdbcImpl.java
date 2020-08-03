package com.bizleap.merchant.service.jdbc.impl;

import com.bizleap.merchant.service.jdbc.AbstractServiceJdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.apache.log4j.Logger;

public class AbstractServiceJdbcImpl implements AbstractServiceJdbc{

		private static Logger logger = Logger.getLogger(AbstractServiceJdbcImpl.class);

		@Override
		public Connection getConnection() {
			Connection connection = null;
			String dBName = "bizleapmerchant";
			String userName = "root";
			String password = "root";
			try {
				try {
					Class.forName("com.mysql.jdbc.Driver");
				} catch (ClassNotFoundException e) {
					logger.error("ERROR>>" + e.getMessage());
				}
				connection = (Connection) DriverManager
						.getConnection("jdbc:mysql://localhost/" + dBName + "?user=" + userName + "&password=" + password);
				logger.info("Connection Successful!");
			} catch (SQLException e) {
				logger.error("ERROR>>" + e.getMessage());
			}
			return connection;
		}
}
