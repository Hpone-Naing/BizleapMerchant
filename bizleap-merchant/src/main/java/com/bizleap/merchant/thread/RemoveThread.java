package com.bizleap.merchant.thread;

public class RemoveThread extends TestThread {

	public RemoveThread(String name, int callCount, int sleepDuration, Thread toJoin) {
		super(name, callCount, sleepDuration, toJoin);
	}

	@Override
	public void run() {
		doStart();
		int callCount = getCallCount();
		MapManipulator mapManipulator = MapManipulator.getInstance();
		while (callCount > 0) {
			String boId = mapManipulator.getRandomKey();
			//System.out.println("Try to remove " + boId + " " + callCount);
			if(boId != null && mapManipulator.containInMap(boId)){
				//System.out.println("Remove " + product.getBoId());
				mapManipulator.removeFromMap(boId,getName(),callCount);
				callCount--;
			}
			doSleep();
		}
		doEnd();
		System.out.println("--------------------------------------------------------");
	}
}
