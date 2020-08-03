package com.bizleap.merchant.services.strategy;

import com.bizleap.merchant.entities.CandyBar;
import com.bizleap.merchant.entities.Product;
import com.bizleap.merchant.enums.CustomerType;
import com.bizleap.merchant.enums.Season;

public class CandyBarPricingManager extends AbstractPricingManager{
	
	Season season;
	
	public CandyBarPricingManager(CustomerType customerType,Season season) {
		super(customerType);
		this.season = season;
	}
	
	public Season getSeason() {
		return season;
	}

	public void setSeason(Season season) {
		this.season = season;
	}

	private boolean isSummer() {
	return this.season==Season.SUMMER;
	}
	
	/*private boolean isWinter() {
	return this.season==Season.WINTER;
	}*/
	
	private boolean isRainy() {
	return this.season==Season.RAINY;
	}

	@Override
	public double calculatePrice(Product product) {
	double price=product.getBasePrice()*product.getWeight();

	switch(((CandyBar)product).getCandyBarType()) {
	case WELLESTABLISHED:
		price=(isSummer())? price + price * 0.08 :(isRainy())? price - price * 0.08 : price;
		product.setPrice(price);
		break;
	case BESTSELLING:
		price=(isSummer())? price + price * 0.08 :(isRainy())? price - price * 0.08 : price;
		product.setPrice(price);
		break;
	case NEWCOMER:
		price=(isSummer())? price + price * 0.08 :(isRainy())? price - price * 0.08 : price;
		product.setPrice(price);
		break;
	}
	return price;
 }
	/*@Override
	public double calculatePrice(Product product) {
		double price=product.getBasePrice()*product.getWeight();
		switch(((CandyBar)product).getCandyBarType()) {
		case WELLESTABLISHED:
			switch(season) {
				case SUMMER:product.setPrice(price+(price*0.08));
				break;
				case RAINY:product.setPrice(price-(price*0.08));
				break;
				default:
				product.setPrice(price);
		}
			break;
		case BESTSELLING:
			switch(season) {
				case SUMMER:product.setPrice(price+(price*0.12));
				break;
				case RAINY:product.setPrice(price-(price*0.12));
				break;
				default:
				product.setPrice(price);
		}
			break;
		default:
			switch(season) {
				case SUMMER:product.setPrice(price+(price*0.05));
				break;
				case RAINY:product.setPrice(price-(price*0.05));
				break;
				default:
				product.setPrice(price);
		}
			break;
		}
		return price;
	}
	*/
		
	@Override
	public double doPricing(Product product) {
		return super.doPricing(product);
	}	
}
