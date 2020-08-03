package com.bizleap.merchant.services.impl.test;

import java.sql.SQLException;
import org.apache.log4j.Logger;
import org.junit.Test;
import com.bizleap.merchant.service.jdbc.PurchaseOrderServiceJdbc;
import com.bizleap.merchant.service.jdbc.impl.PurchaseOrderServiceJdbcImpl;

public class PurchaseOrderServiceJdbcImplTest {

	PurchaseOrderServiceJdbc purchaseOrderServiceJdbc = new PurchaseOrderServiceJdbcImpl();
	private static Logger logger = Logger.getLogger(PurchaseOrderServiceJdbcImplTest.class);

	@Test
	public void testGetAll() throws SQLException {
		logger.info("purchaseOrder List: " + purchaseOrderServiceJdbc.getAll());
	}

	@Test
	public void testDelete() throws SQLException {
		logger.info("Delete purchaseOrder PO001: " + purchaseOrderServiceJdbc.delete("PO001"));
	}

	@Test
	public void testFindByBoId() throws SQLException {
		logger.info("Find purchaseOrder PO002: " + purchaseOrderServiceJdbc.findByBoId("PO002"));
	}
}
