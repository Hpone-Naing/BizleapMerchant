package com.bizleap.merchant.services.impl.test;

import java.sql.SQLException;
import org.apache.log4j.Logger;
import org.junit.Test;
import com.bizleap.merchant.service.jdbc.ProductServiceJdbc;
import com.bizleap.merchant.service.jdbc.impl.ProductServiceJdbcImpl;

public class ProductServiceJdbcImplTest {
	
	ProductServiceJdbc productServiceJdbc = new ProductServiceJdbcImpl();
	private static Logger logger = Logger.getLogger(ProductServiceJdbcImplTest.class);

	@Test
	public void testGetAll() throws SQLException {
		logger.info("product List: " + productServiceJdbc.getAll());
	}

	@Test
	public void testDelete() throws SQLException {
		logger.info("Delete product FRU001: " + productServiceJdbc.delete("FRU001"));
	}

	@Test
	public void testFindByBoId() throws SQLException {
		logger.info("Find product FRU002: " + productServiceJdbc.findByBoId("FRU002"));
	}
}
