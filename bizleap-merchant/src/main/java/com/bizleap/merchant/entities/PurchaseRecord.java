package com.bizleap.merchant.entities;

import java.time.LocalDate;

import com.bizleap.merchant.enums.CustomerType;
import com.bizleap.merchant.enums.ProductType;

public class PurchaseRecord {
	
	private Customer customer;
	private Item item;
	
	
	public PurchaseRecord() {

	}
	
	public PurchaseRecord(Customer customer, Item item) {
		this.customer = customer;
		this.item = item;
	}

	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}
	public static PurchaseRecord parsePurchaseRecord(String dataLine) {
		PurchaseRecord record=new PurchaseRecord();
		String[] tokens=dataLine.split(";");
		record.setCustomer(new Customer(tokens[0].trim(),
										CustomerType.valueOf(tokens[1].trim()),
										LocalDate.parse(tokens[2].trim())));		
		record.setItem(new Item(Integer.parseInt(tokens[3].trim()),
								Integer.parseInt(tokens[4].trim()),
								Double.parseDouble(tokens[5].trim()),
								ProductType.valueOf(tokens[6].trim())));
		return record;
	}
	
}
