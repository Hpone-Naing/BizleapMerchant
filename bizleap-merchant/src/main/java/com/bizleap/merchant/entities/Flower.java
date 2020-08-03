package com.bizleap.merchant.entities;

import java.time.LocalDate;
import java.util.Map;

import com.bizleap.merchant.enums.CustomerType;
import com.bizleap.merchant.enums.FlowerType;
import com.bizleap.merchant.enums.ProductType;
import com.bizleap.merchant.services.strategy.FlowerPricingManager;
import com.bizleap.merchant.services.strategy.PricingManager;

public class Flower extends Product implements Cloneable {

	private int shelfLifeInDays;
	private FlowerType flowerType;
	private LocalDate inspectionDate;
	public static PricingManager pricingManager;

	public Flower() {

	}

	public Flower(FlowerType flowerType) {
		super(ProductType.FLOWER);
		this.flowerType = flowerType;
	}
	
	public Flower(FlowerType flowerType, int shelfLifeInDays, LocalDate inspectionDate) {
		super(ProductType.FLOWER);
		this.flowerType = flowerType;
		this.shelfLifeInDays = shelfLifeInDays;
		this.inspectionDate = inspectionDate;
	}

	/*
	 * public Flower(String name, double price, double weight, ProductType
	 * productType,FlowerType flowerType,LocalDate inspectionDate) { super(name,
	 * price, weight, productType); this.flowerType = flowerType;
	 * this.inspectionDate=inspectionDate; }
	 */

	public int getShelfLifeInDays() {
		return shelfLifeInDays;
	}

	public void setShelfLifeInDays(int shelfLifeInDays) {
		this.shelfLifeInDays = shelfLifeInDays;
	}

	public LocalDate getInspectionDate() {
		return inspectionDate;
	}

	public void setInspectionDate(LocalDate inspectionDate) {
		this.inspectionDate = inspectionDate;
	}

	public FlowerType getFlowerType() {
		return flowerType;
	}

	public void setFlowerType(FlowerType flowerType) {
		this.flowerType = flowerType;
	}
	
	public Flower inspectionDate(LocalDate inspectionDate) {
		setInspectionDate(inspectionDate);
		return this;
	}
	
	/*public void configurePricingManager(CustomerType customerType, LocalDate purchasingDate) {
		((FlowerPricingManager) this.getPricingManager()).setPurchasingDate(purchasingDate);
		((FlowerPricingManager) this.getPricingManager()).setCustomerType(customerType);
	}
*/
	@Override
	public void configurePricingManager(Map<String, String> paramMap) {
		//FlowerPricingManager flowerPricingManager = (FlowerPricingManager) this.getPricingManager();
		FlowerPricingManager flowerPricingManager = (FlowerPricingManager) pricingManager;
		flowerPricingManager.setCustomerType(CustomerType.valueOf(paramMap.get("customerType")));
		flowerPricingManager.setPurchasingDate(LocalDate.parse(paramMap.get("purchasingDate")));
	}

	@Override
	public Flower clone() {
		Flower flower = new Flower();
		super.clone(flower);
		flower.setShelfLifeInDays(getShelfLifeInDays());
		flower.setInspectionDate(getInspectionDate());
		flower.setFlowerType(getFlowerType());
		return flower;
	}

	@Override
	public String toString() {
		return new StringBuffer() 
			  .append( super.toString())
			  .append(" FlowerType:" + flowerType)
			  .toString();
	}

}
