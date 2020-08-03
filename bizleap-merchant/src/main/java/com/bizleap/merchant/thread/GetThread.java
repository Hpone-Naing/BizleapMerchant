package com.bizleap.merchant.thread;

public class GetThread extends TestThread{

	public GetThread(String name, int callCount, int sleepDuration, Thread toJoin) {
		super(name, callCount, sleepDuration, toJoin);
	}

	@Override
	public void run() {
		doStart();
		int callCount = getCallCount();
		MapManipulator mapManipulator = MapManipulator.getInstance();
		while (callCount > 0) {
			String boId = mapManipulator.getRandomKey();
			if (boId != null && mapManipulator.containInMap(boId)) {
				 mapManipulator.getFromMap(boId,getName(),callCount);
				 callCount--;
			}
			doSleep();
		}
		doEnd();
		System.out.println("--------------------------------------------------------");
	}
}