package com.bizleap.training.tutorial32;

import java.util.*;
import com.bizleap.training.tutorial32.Fruit;
public class FruitService {

	private  FruitInitializer fruitInitializer=null;
	private DiscountCalculation discountCalculation=new DiscountCalculation();
	
	public FruitService() {
		
	}
	
	public void start() {
		fruitInitializer=new FruitInitializer();
		fruitInitializer.doInitialize();
		//doPricing(Temperature.HIGH);
		doDiscount();
	}
	
	private class FruitInitializer {

		private List<Fruit> fruitList=null;
		private List<Customer> customerList=null;
		
		public List<Fruit> getFruitList() {
			return fruitList;
		}

		public List<Customer> getCustomerList() {
			return customerList;
		}
	
		private void doInitialize() {
				fruitList=Arrays.asList(new Fruit[]{
						new MostHydratingFruit("WaterMelon",1,30),
						new MostHydratingFruit("Pineapple",2,20),
						new MostHydratingFruit("Blueberry",3,5),
						new MostHydratingFruit("Grape",3.5,20),
						new MostHydratingFruit("Cherries",4,20),
						new MostHydratingFruit("Honeydew",2,30),
						new MostHydratingFruit("Mangos",2.5,40),
						new MostHydratingFruit("Orange",4,60),
						new MediumHydratingFruit("Peach",5,70),
						new MediumHydratingFruit("Pair",3.5,25),
						new MediumHydratingFruit("Apples",4,50),
						new MediumHydratingFruit("Guava",2,80),
						new MediumHydratingFruit("Kiwi",4,10),
						new MediumHydratingFruit("Dragon fruit",3,100),
						new LeastHydratingFruit("Bananas",2.5,70),
						new LeastHydratingFruit("Avocados",2,30),
						new LeastHydratingFruit("Jackfruit",3,80),
						new LeastHydratingFruit("Breadfruit",3,30),
						new LeastHydratingFruit("Passion fruit",3.5,70)
				});
				
				customerList=Arrays.asList(
						new Customer("Theint Thu Thu Aung",CustomerType.VALUE,fruitList),
						new Customer("Sandar Win",CustomerType.VALUE,fruitList),
						new Customer("Htet Wai Lin",CustomerType.REGULAR,fruitList),
						new Customer("Hlawn Moe Hein",CustomerType.VALUE,fruitList),
						new Customer("Phoo Pwint Thu",CustomerType.VOLUME,fruitList),
						new Customer("Thuzar Hlaing",CustomerType.REGULAR,fruitList),
						new Customer("Phyu Pwint Endrain",CustomerType.VOLUME,fruitList),
						new Customer("Saw Than Shwe",CustomerType.VALUE,fruitList),
						new Customer("Hpone Naing Tun",CustomerType.VALUE,fruitList),
						new Customer("Aye Chan Nyein",CustomerType.REGULAR,fruitList),
						new Customer("Naw Phaw Hkee Lar Mya",CustomerType.VOLUME,fruitList)
						);
			}
		}
	
	public void doPricing(Temperature temperatureCategory) {
		for(Fruit fruit:fruitInitializer.getFruitList()) {
			System.out.println("Fruit Name : " + fruit.getName() );
			System.out.println("Price :$ "+((HydratingFruit) fruit).calculatePrice(temperatureCategory) );				
		}	
	}
	
	public void doDiscount(){
		for(Customer customer:fruitInitializer.getCustomerList()) {
			System.out.println("Customer Name : " + customer.getName());
			System.out.println("Customer Type : " + customer.getCustomerType());
			System.out.println();
			for(Fruit fruit:fruitInitializer.getFruitList()) {
				System.out.println("Buy Fruit Name : " + fruit.getName());
				System.out.println("Price : " + fruit.getPrice());
				System.out.println("Discount : " + discountCalculation.calculateDiscount(customer, fruit));
				System.out.println();
			}
		}
	}
	
	public static void main(String[] args) {
		
		new FruitService().start();
	}
}
