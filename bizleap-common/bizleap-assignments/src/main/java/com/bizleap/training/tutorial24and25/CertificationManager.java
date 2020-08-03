package com.bizleap.training.tutorial24and25;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;

public class CertificationManager {
	
	private Queue<Student> queue = null;
	private	List<Student> studentList=null;
	private Queue<Student> departQueue = null;
	private Queue<Student> awardedQueue = null;
	private Set<Integer> randomNumber=null;

	public CertificationManager() {
		super();
	}
	
	public Queue<Student> getQueue() {
		return queue;
	}

	public void setQueue(Queue<Student> queue) {
		this.queue = queue;
	}
	
	public Set<Integer> getRandomNumber(){
		if(randomNumber==null)
			randomNumber=new HashSet<Integer>();
		return randomNumber;
	}
	
	public void setRandomNumber(Set<Integer> randomNumber) {
		this.randomNumber = randomNumber;
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
		if (departQueue== null)
			departQueue=new ConcurrentLinkedQueue<Student>();
		if (awardedQueue== null)
			awardedQueue=new ConcurrentLinkedQueue<Student>();
	}
	
	public Student getAStudent() {
		int randomNumber=(int) (Math.random()*studentList.size());
		while(!getRandomNumber().add(randomNumber))
			randomNumber=(int) (Math.random()*studentList.size());
		return studentList != null ? studentList.get(randomNumber):null;
	}

	private void doArrivals() {
		getAStudent().arrive(getQueue());
		getAStudent().arrive(getQueue());
		getAStudent().arrive(getQueue());
		getAStudent().arrive(getQueue());
		getAStudent().arrive(getQueue());
		getAStudent().arrive(getQueue());
		getAStudent().arrive(getQueue());
		getAStudent().arrive(getQueue());
		System.out.println("Arrival Students : " + queue);
	}

	private void doAwrads() {
		while(!queue.isEmpty()) {
			Student student=queue.poll();
			student.award(queue);
			awardedQueue.add(student);
		}
		System.out.println(awardedQueue + " get Certificate.");			
	}
	
	private void doDepart() {
		while(!awardedQueue.isEmpty()) {
			Student student=awardedQueue.poll();
			student.depart(awardedQueue);
			departQueue.add(student);		
		}
		System.out.println(departQueue + " has been departure.");	
	}

	public void start() {
		doIntialize();
		doArrivals();
		doAwrads();
		doDepart();
	}

	public static void main(String[] args) {
		new CertificationManager().start();
	}	
}
