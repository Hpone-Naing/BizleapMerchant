package com.bizleap.merchant.entities;

import java.time.LocalDate;

import com.bizleap.merchant.enums.CustomerType;

public class Customer{

	private String name;
	private CustomerType customerType;
	private LocalDate buyProductDate;
	
	
	public Customer() {
		
	}

	public Customer(String name) {
		this.name=name;
		this.customerType=CustomerType.REGULAR;
	}

	public Customer(String name, CustomerType customerType,LocalDate buyProductDate) {
		this.name = name;
		this.customerType = customerType;
		this.buyProductDate=buyProductDate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public CustomerType getCustomerType() {
		return customerType;
	}

	public void setCustomerType(CustomerType customerType) {
		this.customerType = customerType;
	}

	public LocalDate getBuyProductDate() {
		return buyProductDate;
	}

	public void setBuyProductDate(LocalDate buyProductDate) {
		this.buyProductDate = buyProductDate;
	}

	/*@Override
	public String toString() {
		return new StringBuilder().append("Customer [name=" + name + ", customerType=" + customerType + ", buyProductDate=" + buyProductDate
				+ "]").toString();
	}*/
}
