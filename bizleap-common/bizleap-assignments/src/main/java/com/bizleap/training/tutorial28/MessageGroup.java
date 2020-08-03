package com.bizleap.training.tutorial28;

import java.util.List;

public class MessageGroup {
	
	private String id;
	private String name;
	private List<Message> messageList;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public MessageGroup(String id, String name, List<Message> messageList) {
		super();
		this.id = id;
		this.name = name;
		this.messageList = messageList;
	}

	public List<Message> getMessageList() {
		return messageList;
	}

	public void setMessageList(List<Message> messageList) {
		this.messageList = messageList;
	}

	@Override
	public String toString() {
		return new StringBuffer().append(id).append(name).append(messageList).toString();
	}

}
