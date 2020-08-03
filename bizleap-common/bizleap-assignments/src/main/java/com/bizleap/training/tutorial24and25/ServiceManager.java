package com.bizleap.training.tutorial24and25;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;

public class ServiceManager {
		
	private Queue<Student> queue = null;
	private Queue<Student> serveQueue = null;
	private Queue<Student> departQueue = null;
	private	List<Student> studentList=null;
	private Set<Integer> randomNumber=null;

	public Set<Integer> getRandomNumber() {
		if(randomNumber==null)
			randomNumber=new HashSet<Integer>();
		return randomNumber;
	}

	public void setRandomNumber(Set<Integer> randomNumber) {
		this.randomNumber = randomNumber;
	}

	public Queue<Student> getQueue() {
		return queue;
	}

	public void setQueue(Queue<Student> queue) {
		this.queue = queue;
	}
	
	public Student getAStudent() {
		int random=(int)(Math.random()*studentList.size());
		if(!getRandomNumber().add(random))
			random=(int)(Math.random()*studentList.size());
		return studentList != null ? studentList.get(random):null;
	}

	private void doIntialize() {
		if(studentList==null) {
			studentList =Arrays.asList(
					new Student("Theint Thu Thu Aung"), 
					new Student("Sandar Win"),
					new Student("Htet Wai Lin"),
					new Student("Kaung Nyunt Hlaing"), 
					new Student("Hlwan Moe Hein"), 
					new Student("Thuzar Hlaing"), 
					new Student("Hpone Naing Tun"),
					new Student("Phu Pwint Eaindray"),
					new Student("Saw Than Shwe"), 
					new Student("Ei Ei Tone"), 
					new Student("Phoo Pwint Thu"), 
					new Student("Aye Chan Nyein"), 
					new Student("Naw Phaw Hkee Lar Mya"),
					new Student("Pann Cherry Hlaing"),
					new Student("Aung Baw Ga"),
					new Student( "Min Thant Khant"));
		}
		 
		if (queue== null)
			queue=new ConcurrentLinkedQueue<Student>();
		if (serveQueue== null)
			serveQueue=new ConcurrentLinkedQueue<Student>();
		if (departQueue== null)
			departQueue=new ConcurrentLinkedQueue<Student>();

	}

	private void doArrivals() {
		getAStudent().arrive(getQueue());
		getAStudent().arrive(getQueue());
		getAStudent().arrive(getQueue());
		getAStudent().arrive(getQueue());
		System.out.println("Arrival Students : " + queue);
	}

	private void doServe() {
		while(!queue.isEmpty()) {
			Student student=queue.poll();
			student.award(queue);
			serveQueue.add(student);
		}
		System.out.println(serveQueue + " get ice-cream.");	
	}
	
	private void doDepart() {
		while(!serveQueue.isEmpty()) {
			Student student=serveQueue.poll();
			student.depart(serveQueue);
			departQueue.add(student);
		}
		System.out.println(departQueue + " has been departured.");
	}
	public void start() {
		doIntialize();
		doArrivals();
		doServe();
		doDepart();
	}

	public static void main(String[] args) {
		new ServiceManager().start();
	}	
}
