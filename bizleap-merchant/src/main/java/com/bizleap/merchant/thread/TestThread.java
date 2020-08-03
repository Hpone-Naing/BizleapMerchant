package com.bizleap.merchant.thread;

public class TestThread extends Thread{

	private static int threadCount;
	private int callCount;
	private long startTime;
	private long endTime;
	private long sleepDuration;
	private double totalTime;
	private Thread toJoin;
	
	public TestThread(String name, int callCount, int sleepDuration, Thread toJoin) {
		this.callCount = callCount;
		this.sleepDuration=sleepDuration;
		this.toJoin=toJoin;
		setName(name);
	}
	
	public Thread getToJoin() {
		return toJoin;
	}

	public void setToJoin(Thread toJoin) {
		this.toJoin = toJoin;
	}

	public static int getThreadCount() {
		return threadCount;
	}

	public static void setThreadCount(int threadCount) {
		TestThread.threadCount = threadCount;
	}

	public int getCallCount() {
		return callCount;
	}

	public void setCallCount(int callCount) {
		this.callCount = callCount;
	}

	public long getStartTime() {
		return startTime;
	}

	public void setStartTime(long startTime) {
		this.startTime = startTime;
	}

	public long getEndTime() {
		return endTime;
	}

	public void setEndTime(long endTime) {
		this.endTime = endTime;
	}

	public double getTotalTime() {
		return totalTime;
	}

	public void setTotalTime(double totalTime) {
		this.totalTime = totalTime;
	}

	public long getSleepDuration() {
		return sleepDuration;
	}

	public void setSleepDuration(long sleepDuration) {
		this.sleepDuration = sleepDuration;
	}

	protected void doStart() {
		if(toJoin != null) {
			try {
				toJoin.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}		
		threadCount++;
		this.startTime = System.currentTimeMillis();
		System.out.println("STARTED " + getName() + "Thread count: " + getThreadCount());
	//	System.out.println("Call count: " + callCount);
	}
	
	protected void doEnd() {
		threadCount--;
		this.endTime = System.currentTimeMillis();
		this.setTotalTime(this.endTime - this.startTime);		
		System.out.println("COMPLETED " + getName() + ", total time: " + getTotalTime() + " Thread count: " + getThreadCount());
	}
	
	protected void doSleep() {
		/*try {
				System.out.println(getName() + " SLEEPING");
				Thread.sleep(sleepDuration);
		} catch (InterruptedException e) {
				e.printStackTrace();
		}*/
	}
}
