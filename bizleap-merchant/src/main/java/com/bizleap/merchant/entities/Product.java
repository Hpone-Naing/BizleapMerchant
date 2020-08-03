package com.bizleap.merchant.entities;

import java.util.Map;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import com.bizleap.common.domain.AbstractEntity;
import com.bizleap.merchant.enums.ProductType;

@Entity
@Table(name = "product")
public class Product extends AbstractEntity implements Comparable<Product>{
	
	@Column (name = "name" , length = 255)
	private String name;
	
	@Column (name = "price")
	private double price;
	
	@Column (name = "basePrice")
	private double basePrice;
	
	@Column (name = "weight")
	private double weight;
	
	@Enumerated (EnumType.STRING)
	private ProductType productType;
	//private PricingManager pricingManager;
	
	public Product() {
		
	}
	
	public Product(ProductType productType) {
		this.productType=productType;
	}
	/*
		public Product(String name,double basePrice, double weight, ProductType productType) {
		this.name = name;
		this.basePrice = basePrice;
		this.weight = weight;
		this.productType = productType;
	}

		public Product(String productId,String name,double basePrice, double weight, ProductType productType) {
		this(name,basePrice,weight,productType);
		this.productId=productId;
	}*/

	public Product boId(String boId) {
		setBoId(boId);
		return this;
	}
	
	public Product Id(Long id) {
		setId(id);
		return this;
	}
	
	
	public Product name(String name) {
		setName(name);
		return this;
	}
	
	public Product basePrice(double basePrice) {
		setBasePrice(basePrice);
		return this;
	}
	
	public Product weight(double weight) {
		setWeight(weight);
		return this;
	}
	
	public Product productType(ProductType productType) {
		setProductType(productType);
		return this;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getBasePrice() {
		return basePrice;
	}

	public void setBasePrice(double basePrice) {
		this.basePrice = basePrice;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public ProductType getProductType() {
		return productType;
	}

	public void setProductType(ProductType productType) {
		this.productType = productType;
	}
	
	/*public PricingManager getPricingManager() {
		return pricingManager;
	}

	public void setPricingManager(PricingManager pricingManager) {
		this.pricingManager = pricingManager;
	}
	*/
	public void configurePricingManager(Map<String,String> paramMap) {
		
	}
	
	public double calculatePrice() {
		//return pricingManager.doPricing(this);
		switch(productType) {
			case FRUIT:
				return Fruit.pricingManager.doPricing(this);
			case FLOWER:
				return Flower.pricingManager.doPricing(this);
			case CANDYBAR:
				return CandyBar.pricingManager.doPricing(this);
		}
		return 0;
	}
	
	protected Product clone(Product product) {
		super.clone(product);
		product.setName(getName());
		product.setWeight(getWeight());
		product.setBasePrice(getBasePrice());
		product.setPrice(getBasePrice()*getWeight());
		product.setProductType(getProductType());
		return product;
	}
	
	public Product clone() {
		return null;
	};
	/*
	public static Product parseProduct(String dataLine){
		Product product=new Product();
		String[] tokens=dataLine.split(",");
		product.setId(Long.parseLong(tokens[0].trim()));
		product.setBoId(tokens[1].trim());
		product.setName(tokens[2]);
		product.setBasePrice(Double.parseDouble(tokens[3].trim()));
		product.setWeight(Double.parseDouble(tokens[4].trim()));
		product.setProductType(ProductType.valueOf(tokens[5].trim()));
		return product;
	}*/
	
	public static Product parseProduct(String dataLine){
		Product product=new Product();
		String[] tokens=dataLine.split(",");
		product.setBoId(tokens[0]);
		product.setName(tokens[1]);
		product.setBasePrice(Double.parseDouble(tokens[2].trim()));
		product.setWeight(Double.parseDouble(tokens[3].trim()));
		product.setProductType(ProductType.valueOf(tokens[4].trim()));
		return product;
	}
	
	@Override
	public int compareTo(Product product) {
		return super.compareTo(product);
	}
	
	@Override
		public boolean equals(Object instance) {
			if(!(instance instanceof Product))
				return false;
			if(instance == this)
				return true;
			Product product = (Product) instance;
			if(product.getId() > 0L) 
				return new EqualsBuilder().append(getId(), product.getId()).isEquals();
			return new EqualsBuilder()
					.appendSuper(super.equals(instance))
					.append(getBoId(), product.getBoId())
					.append(getName(), product.getName())
					.append(getBasePrice(), product.getBasePrice())
					.append(getWeight(), product.getWeight())
					.append(getProductType(), product.getProductType())
					.isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(51,13) //two randomly chosen prime numbers
				.append(getBoId())
				.append(getName())
				.append(getBasePrice())
				.append(getWeight())
				.append(getProductType())
				.toHashCode();
	}	
	
	@Override
	public String toString() {
		return new StringBuffer(super.toString())
								  .append("Name: "+ name)
								  .append("BasePrice: " + basePrice)
								  .append("Weight: " + weight)
								  .append("ProductType:" + productType)
								  .toString();
	}
}
