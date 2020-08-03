package com.bizleap.merchant.thread;

import com.bizleap.merchant.entities.Product;

public class PutThread extends TestThread{

	public PutThread(String name, int callCount, int sleepDuration, Thread toJoin) {
		super(name, callCount, sleepDuration, toJoin);
	}

	@Override
	public void run() {
		doStart();
		int callCount = getCallCount();
		MapManipulator mapManipulator = MapManipulator.getInstance();
		while(callCount > 0){
			Product product = mapManipulator.getRandomProductFromList();
			if(!mapManipulator.containInMap(product.getBoId())){
				mapManipulator.putIntoMap(product,getName(),callCount);		
				callCount--;
			}
			doSleep();
		}
		doEnd();
		System.out.println("--------------------------------------------------------");
	}
}