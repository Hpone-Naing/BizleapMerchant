package com.bizleap.training.assignments;
//TutorialOne
public class SaySomething {
	
	public String sayHi() {
		
		return "Hello BizLeap! I am here to learn Java and OOP";
	}

	public static void main(String[] args) {
		
		System.out.print(new SaySomething().sayHi());
	}
}
