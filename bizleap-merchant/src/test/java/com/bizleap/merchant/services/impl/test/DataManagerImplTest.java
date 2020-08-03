package com.bizleap.merchant.services.impl.test;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import com.bizleap.merchant.loader.impl.DataManagerImpl;

public class DataManagerImplTest extends ServiceTest{

	@Autowired
	DataManagerImpl dataManager;

	@Test
	public void testAssociationMapper() throws Exception {
		try {
			dataManager.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
