package com.bizleap.training.tutorial32;

public class FruitsSeller {
	
	private FruitInitializer fruitInitialization=null;
	private DiscountCalculation discountCalculation=new DiscountCalculation();
	
	public FruitsSeller() {
		
	}
	
	public FruitsSeller(FruitInitializer fruitInitializer) {
		this.fruitInitialization=fruitInitializer;
	}
	
	public FruitsSeller(DiscountCalculation discountCalculation) {
		this.discountCalculation=discountCalculation;
	}
	
	public FruitInitializer getFruitInitialization() {
		return fruitInitialization;
	}

	public void setFruitInitialization(FruitInitializer fruitInitialization) {
		this.fruitInitialization = fruitInitialization;
	}

	public DiscountCalculation getDiscountCalculation() {
		return discountCalculation;
	}

	public void setDiscountCalculation(DiscountCalculation discountCalculation) {
		this.discountCalculation = discountCalculation;
	}

	public void doPricing(Temperature temperatureCategory) {
		for(Fruit fruit:fruitInitialization.getFruitList()) {
			System.out.println("Fruit Name : " + fruit.getName() );
			System.out.println("Price :$ "+((HydratingFruit) fruit).calculatePrice(temperatureCategory) );				
		}	
	}
	
	public void doDiscount(){
		for(Customer customer:fruitInitialization.getCustomerList()) {
			System.out.println("Customer Name : " + customer.getName());
			System.out.println("Customer Type : " + customer.getCustomerType());
			System.out.println();
			for(Fruit fruit:fruitInitialization.getFruitList()) {
				System.out.println("Buy Fruit Name : " + fruit.getName());
				System.out.println("Price : " + fruit.getPrice());
				System.out.println("Discount : " + discountCalculation.calculateDiscount(customer, fruit));
				System.out.println();
			}
		}
	}
	
	public static void main(String[] args) {
	//	new FruitsSeller(new FruitInitializer()).doPricing(Temperature.HIGH);
		new FruitsSeller(new FruitInitializer()).doDiscount();
	}

}
