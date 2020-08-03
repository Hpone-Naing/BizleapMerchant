package com.bizleap.merchant.entities;

import com.bizleap.merchant.enums.ProductType;

public class Item {

	private int productID;
	private int quanitity;
	private double price;
	private ProductType productType;

	public Item() {

	}

	public Item(int productID, int quanitity, double price, ProductType productType) {
		super();
		this.productID = productID;
		this.quanitity = quanitity;
		this.price = price;
		this.productType = productType;
	}

	public int getProductID() {
		return productID;
	}

	public void setProductID(int productID) {
		this.productID = productID;
	}

	public int getQuanitity() {
		return quanitity;
	}

	public void setQuanitity(int quanitity) {
		this.quanitity = quanitity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public ProductType getProductType() {
		return productType;
	}

	public void setProductType(ProductType productType) {
		this.productType = productType;
	}

}
