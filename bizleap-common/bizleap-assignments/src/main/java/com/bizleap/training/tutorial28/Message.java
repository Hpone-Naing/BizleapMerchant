package com.bizleap.training.tutorial28;

import java.util.List;
import java.util.Map;
import com.bizleap.training.tutorial30.Student;

public class Message {
	
	private int id;
	private String lastMessage;
	private Status status;
	private Student student;
	
	public Message(int id, String lastMessage, Status status) {
		super();
		this.id = id;
		this.lastMessage = lastMessage;
		this.status = status;
	}

	public Message(int id, Student student, String lastMessage, Status status) {
		this(id,lastMessage,status);
		this.student=student;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLastMessage() {
		return lastMessage;
	}

	public void setLastMessage(String lastMessage) {
		this.lastMessage = lastMessage;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public boolean isContainStatus(Map<Status,List<MessageGroup>> messageGroupMap) {
		return messageGroupMap.containsKey(this.status);
	}
	
	@Override
	public String toString() {
		return  new StringBuffer().append(id).append(lastMessage).append(status).append(student).toString();
	}
}
