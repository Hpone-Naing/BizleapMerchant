package com.bizleap.merchant.factory.impl;

import com.bizleap.merchant.entities.CandyBar;
import com.bizleap.merchant.enums.CandyBarType;
import com.bizleap.merchant.enums.CustomerType;
import com.bizleap.merchant.enums.ProductType;
import com.bizleap.merchant.enums.Season;
import com.bizleap.merchant.services.strategy.CandyBarPricingManager;
import com.bizleap.merchant.services.strategy.PricingManager;

public class CandyBarFactory extends AbstractProductFactory{
	
	CandyBarType candyBarType; 
	CustomerType customerType;
	Season season;
	//PricingManager pricingManager;
	
	public CandyBarFactory() {
		super(ProductType.CANDYBAR);
	}
	
	public CandyBarFactory(CandyBarType candyBarType) {
		super(ProductType.CANDYBAR);
		this.candyBarType=candyBarType;
	}

	public CandyBarType getCandyBarType() {
		return candyBarType;
	}

	public void setCandyBarType(CandyBarType candyBarType) {
		this.candyBarType = candyBarType;
	}

	private double getBasePrice(String name) {
		return 5;
	}
	/*
	 * To be used with candyBarType constructor
	 *
	 /
	public CandyBar create(String id,String name,double weight) {
		CandyBar candyBar=(CandyBar) new CandyBar(candyBarType).boId(id).name(name).weight(weight).basePrice(getBasePrice(name));
		candyBar.setPricingManager(this.getPricingManager());
		return candyBar;
	}
	
	/*
	 * To be used with empty constructor
	 */
	public CandyBar create(String id,String name,double weight,CandyBarType candyBarType) {
		CandyBar candyBar=(CandyBar) new CandyBar(candyBarType).boId(id).name(name).weight(weight).basePrice(getBasePrice(name));
		//candyBar.setPricingManager(this.getPricingManager());
		return candyBar;
	}

	@Override
	public PricingManager getPricingManager() {
		if(pricingManager==null)
			pricingManager=new CandyBarPricingManager(customerType, season);
		return pricingManager;
	}
}
