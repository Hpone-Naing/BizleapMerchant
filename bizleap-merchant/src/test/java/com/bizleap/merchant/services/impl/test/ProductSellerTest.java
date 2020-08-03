package com.bizleap.merchant.services.impl.test;

import org.junit.Test;
import java.time.LocalDate;

import com.bizleap.merchant.enums.CustomerType;
import com.bizleap.merchant.enums.Season;
import com.bizleap.merchant.enums.Temperature;
import com.bizleap.merchant.services.impl.*;

public class ProductSellerTest {
	
	@Test
	public void testFruitPricing() {
		ProductSeller productSeller=new ProductSeller();
		System.out.println(productSeller.doFruitPricing(CustomerType.VOLUME,Temperature.HIGH));
		System.out.println(productSeller.doFruitPricing(CustomerType.VOLUME,Temperature.MEDIUM));
		System.out.println(productSeller.doFruitPricing(CustomerType.VOLUME,Temperature.LOW));
		System.out.println(productSeller.doFruitPricing(CustomerType.REGULAR,Temperature.HIGH));
		System.out.println(productSeller.doFruitPricing(CustomerType.REGULAR,Temperature.MEDIUM));
		System.out.println(productSeller.doFruitPricing(CustomerType.REGULAR,Temperature.LOW));
		System.out.println(productSeller.doFruitPricing(CustomerType.VALUE,Temperature.HIGH));
		System.out.println(productSeller.doFruitPricing(CustomerType.VALUE,Temperature.MEDIUM));
		System.out.println(productSeller.doFruitPricing(CustomerType.VALUE,Temperature.LOW));
	}
	
	@Test
	public void testFlowerPricing() {
		ProductSeller productSeller=new ProductSeller();
		System.out.println(productSeller.doFlowerPricing(CustomerType.REGULAR,LocalDate.now()));
		System.out.println(productSeller.doFlowerPricing(CustomerType.REGULAR,LocalDate.now().plusDays(3)));
		System.out.println(productSeller.doFlowerPricing(CustomerType.REGULAR,LocalDate.now().plusDays(5)));
		System.out.println(productSeller.doFlowerPricing(CustomerType.VALUE,LocalDate.now()));
		System.out.println(productSeller.doFlowerPricing(CustomerType.VALUE,LocalDate.now().plusDays(3)));
		System.out.println(productSeller.doFlowerPricing(CustomerType.VALUE,LocalDate.now().plusDays(4)));
		System.out.println(productSeller.doFlowerPricing(CustomerType.VOLUME,LocalDate.now()));
		System.out.println(productSeller.doFlowerPricing(CustomerType.VOLUME,LocalDate.now().plusDays(5)));
		System.out.println(productSeller.doFlowerPricing(CustomerType.VOLUME,LocalDate.now().plusDays(4)));
	}
	
	@Test
	public void testCandyBarPricing() {
		ProductSeller productSeller=new ProductSeller();
		System.out.println(productSeller.doCandyBarPricing(CustomerType.REGULAR,Season.WINTER));
		System.out.println(productSeller.doCandyBarPricing(CustomerType.REGULAR,Season.RAINY));
		System.out.println(productSeller.doCandyBarPricing(CustomerType.REGULAR,Season.SUMMER));
		System.out.println(productSeller.doCandyBarPricing(CustomerType.VALUE,Season.RAINY));
		System.out.println(productSeller.doCandyBarPricing(CustomerType.VALUE,Season.SUMMER));
		System.out.println(productSeller.doCandyBarPricing(CustomerType.VALUE,Season.WINTER));
		System.out.println(productSeller.doCandyBarPricing(CustomerType.VOLUME,Season.SUMMER));
		System.out.println(productSeller.doCandyBarPricing(CustomerType.VOLUME,Season.RAINY));
		System.out.println(productSeller.doCandyBarPricing(CustomerType.VOLUME,Season.WINTER));
	}
	
	public static void main(String[] args) throws Exception {
		ProductSellerTest productSellerTest=new ProductSellerTest();
				productSellerTest.testFruitPricing();
				productSellerTest.testFlowerPricing();
				productSellerTest.testCandyBarPricing();
	}

}
