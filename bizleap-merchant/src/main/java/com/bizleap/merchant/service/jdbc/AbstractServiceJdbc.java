package com.bizleap.merchant.service.jdbc;

import java.sql.Connection;

public interface AbstractServiceJdbc {
	
	public Connection getConnection();
}
