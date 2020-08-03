package com.bizleap.training.tutorial24and25;

//tutorial24
import java.util.*;

public class Student {
	
	private String name;
	
	public Student() {
	}

	public Student(String name) {
		this.name=name;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void arrive(Queue<Student> studentQueue) {
		 studentQueue.add(this);
	}
	
	private void remove(Queue<Student> studentQueue) {
		studentQueue.remove(this);
	}
	
	public void award(Queue<Student> studentQueue) {
		remove(studentQueue);
	}

	public void serve(Queue<Student> studentQueue) {
		remove(studentQueue);
	}

	public void depart(Queue<Student> departQueue) {
		remove(departQueue);
	}
	
	@Override
	public String toString() {
		return new StringBuilder().append("name=" + name ).toString();
	}

}
