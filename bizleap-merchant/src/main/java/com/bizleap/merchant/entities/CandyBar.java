package com.bizleap.merchant.entities;

import java.util.Map;

import com.bizleap.merchant.enums.CandyBarType;
import com.bizleap.merchant.enums.CustomerType;
import com.bizleap.merchant.enums.ProductType;
import com.bizleap.merchant.enums.Season;
import com.bizleap.merchant.services.strategy.CandyBarPricingManager;
import com.bizleap.merchant.services.strategy.PricingManager;

public class CandyBar extends Product implements Cloneable{

	private CandyBarType candyBarType;
	public static PricingManager pricingManager;
	
	public CandyBar() {
		
	}
	
	public CandyBar(CandyBarType candyBarType) {
		super(ProductType.CANDYBAR);
		this.candyBarType=candyBarType;
	}
	/*
	public CandyBar(String name, double price, double weight, ProductType productType,CandyBarType candyBarType) {
		super(name, price, weight, productType);
		this.candyBarType=candyBarType;
	}
	 */
	public CandyBarType getCandyBarType() {
		return candyBarType;
	}

	public void setCandyBarType(CandyBarType candyBarType) {
		this.candyBarType = candyBarType;
	}

	public boolean isWellEstablish() {
		return this.candyBarType==CandyBarType.WELLESTABLISHED;
	}
	
	public boolean isBestSelling() {
		return this.candyBarType==CandyBarType.BESTSELLING;
	}
	
	public boolean isNewComer() {
		return this.candyBarType==CandyBarType.NEWCOMER;
	}
	
	/*public void configurePricingManager(CustomerType customerType,Season season) {
		((CandyBarPricingManager) this.getPricingManager()).setSeason(season);
		((CandyBarPricingManager) this.getPricingManager()).setCustomerType(customerType);
	}*/
	
	@Override
	public void configurePricingManager(Map<String, String> paramMap) {
		//CandyBarPricingManager candyBarPricingManager=(CandyBarPricingManager) this.getPricingManager();
		CandyBarPricingManager candyBarPricingManager=(CandyBarPricingManager)pricingManager;
		candyBarPricingManager.setCustomerType(
				CustomerType.valueOf(paramMap.get("customerType"))
				);
		candyBarPricingManager.setSeason(
				Season.valueOf(paramMap.get("season"))
				);
	}
	
	@Override
	public CandyBar clone() {
		CandyBar candyBar=new CandyBar();
		super.clone(candyBar);
		candyBar.setCandyBarType(getCandyBarType());
		return candyBar;	
	}
	
	@Override
	public String toString() {
		return new StringBuffer() 
				  .append( super.toString())
				  .append(" CandyBarType:" + candyBarType)
				  .toString();
	}	
}
