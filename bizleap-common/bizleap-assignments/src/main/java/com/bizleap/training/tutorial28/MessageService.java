package com.bizleap.training.tutorial28;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class MessageService {

	private MessenginngManager mm=null;
	
	public MessageService() {
		
	}
	
	public MessageService(MessenginngManager mm) {
		this.mm = mm;
	}

	public MessenginngManager getMm() {
		return mm;
	}

	public void setMm(MessenginngManager mm) {
		this.mm = mm;
	}

	public Map<Status, List<MessageGroup>> getMessageGroupMap() {
		return mm.getMessageGroupMap();
	}

	public void show() {
		Map<Status,List<MessageGroup>> messageGroupMap=getMessageGroupMap();
		Set<Status> keys=messageGroupMap.keySet();
		for(Status key:keys) {
			if(key.equals(Status.DELIVERED)) {
			for(MessageGroup messageGroup:messageGroupMap.get(key)) {
				System.out.println(messageGroup.getName());
				Message lastMessage=messageGroup.getMessageList().get(messageGroup.getMessageList().size()-1);
				System.out.println(lastMessage.getStudent().getName() + " : " +
				lastMessage.getLastMessage() + " : " + lastMessage.getStatus());
				System.out.println("---------------------------------------------");
			}
		}
	}
}
	public static void main(String[] args) {
		
		new MessageService(new MessenginngManager()).show();
	}

}
