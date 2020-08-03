package com.bizleap.merchant.services.impl.test;

import org.junit.runner.RunWith;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.junit.Test;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"classpath:/applicationContext.xml","classpath:/hibernateContext.xml"})
@PropertySource({"classpath:/log4j.properties","classpath:/application.properties"})
public class ServiceTest{
	
	@Test
	public void Test() {
		
	}
}