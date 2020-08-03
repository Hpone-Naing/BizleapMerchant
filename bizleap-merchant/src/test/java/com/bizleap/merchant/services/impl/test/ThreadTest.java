package com.bizleap.merchant.services.impl.test;

import org.junit.Test;

import com.bizleap.merchant.thread.GetThread;
import com.bizleap.merchant.thread.PutThread;
import com.bizleap.merchant.thread.RemoveThread;
import com.bizleap.merchant.thread.TestThread;

public class ThreadTest {
	@Test
	public void testThread() throws InterruptedException{
		//MapManipulator.getInstance();
		TestThread putThread1 = new PutThread("Put001",100,10,null);
		TestThread getThread1 = new GetThread("Get001",100,20,putThread1);
		TestThread removeThread1 = new RemoveThread("Remove001",10,20,getThread1);
		
		
		TestThread putThread2 = new PutThread("Put002",90,20,removeThread1);
		TestThread getThread2 = new GetThread("Get002",90,15,putThread2);
		TestThread removeThread2 = new RemoveThread("Remove002",20,20,getThread2);
		
		TestThread putThread3 = new PutThread("Put003",80,20,removeThread2);
		TestThread getThread3 = new GetThread("Get003",80,30,putThread3);
		TestThread removeThread3 = new RemoveThread("Remove003",30,30,getThread3);
		
		TestThread putThread4 = new PutThread("Put004",70,10,removeThread3);
		TestThread getThread4 = new GetThread("Get004",70,20,putThread4);
		TestThread removeThread4 = new RemoveThread("Remove004",40,20,getThread4);
		
		putThread1.start();
		getThread1.start();
		removeThread1.start();
		
		putThread2.start();
		getThread2.start();
		removeThread2.start();
		
		putThread3.start();
		getThread3.start();
		removeThread3.start();
		
		putThread4.start();	
		getThread4.start();	
		removeThread4.start();
		
		while(TestThread.getThreadCount() > 0);
		System.out.println("Test Thread completed. " + TestThread.getThreadCount());
		
	//	System.out.println("Current thread: " + Thread.currentThread().getName());
	//	putThread4.join();

	//	System.out.println("Current thread: " + Thread.currentThread().getName());
	//	getThread4.join();
	
	//	System.out.println("Current thread: " + Thread.currentThread().getName());
	//	removeThread.join();
				
	}
}
