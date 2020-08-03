package com.bizleap.training.tutorial28;

import java.util.*;
import com.bizleap.training.tutorial22.Gender;
import com.bizleap.training.tutorial30.OtherStudent;
import com.bizleap.training.tutorial30.UCSYStudent;

public class MessenginngManager {
	
	private Map<Status,List<MessageGroup>> messageGroupMap=null;
	private List<MessageGroup> messageGroupList=null;
	private List<Message> internshipMeeting=null;
	private List<Message> internship2020=null;
	private List<Message> employeeMeeting=null;

	public MessenginngManager() {
		start();
	}
	
	public List<Message> getInternshipMeeting() {
		return internshipMeeting;
	}

	public void setInternshipMeeting(List<Message> internshipMeeting) {
		this.internshipMeeting = internshipMeeting;
	}

	public List<Message> getInternship2020() {
		return internship2020;
	}

	public void setInternship2020(List<Message> internship2020) {
		this.internship2020 = internship2020;
	}

	public List<Message> getEmployeeMeeting() {
		return employeeMeeting;
	}

	public void setEmployeeMeeting(List<Message> employeeMeeting) {
		this.employeeMeeting = employeeMeeting;
	}

	public Map<Status, List<MessageGroup>> getMessageGroupMap() {
		return messageGroupMap;
	}

	public void setMessageGroupMap(Map<Status, List<MessageGroup>> messageGroupMap) {
		this.messageGroupMap = messageGroupMap;
	}

	public List<MessageGroup> getMessageGroupList() {
		return messageGroupList;
	}
	public void setMessageGroupList(List<MessageGroup> messageGroupList) {
		this.messageGroupList = messageGroupList;
	}
	
	private void doInitialize() {
		
		internship2020 = Arrays.asList(new Message[] {
				new Message(1,new UCSYStudent("Theint Thu Thu Aung",21,Gender.FEMALE,"UCSY"), "hello",Status.SEEN),
				new Message(2,new UCSYStudent("Sandar Win",21,Gender.FEMALE,"UCSY"), "I'm from UCSY.",Status.SEEN),
				new Message(3,new OtherStudent("Htet Wai Lin",21,Gender.MALE,"Other"), "Bye",Status.SEEN),
				new Message(4,new OtherStudent("Kaung Nyunt Hlaing",21,Gender.MALE,"Other"), "Nice to meet you all.",Status.SEEN),
				new Message(5,new UCSYStudent("Hlwan Moe Hein",21,Gender.MALE,"UCSY"), "How are you?",Status.DELIVERED)
				});
		
		internshipMeeting = Arrays.asList(new Message[] {
				new Message(1,new OtherStudent("Thuzar Hlaing",21,Gender.FEMALE,"Other"), "Thank you.",Status.SEEN),
				new Message(2,new UCSYStudent("Hpone Naing Tun",21,Gender.MALE,"UCSY"), "Nice to meet you all.",Status.SEEN),
				new Message(3,new OtherStudent("Phu Pwint Eaindray",21,Gender.FEMALE,"Other"), "Hello Friends!",Status.SEEN),
				new Message(4,new OtherStudent("Saw Than Shwe",21,Gender.MALE,"Other"), "Nice to meet you all.",Status.DELIVERED)
		});
			
		employeeMeeting = Arrays.asList(new Message[] {
				new Message(1,new OtherStudent("Ei Ei Tone",21,Gender.FEMALE,"Other"), "Good night.",Status.SEEN),
			    new Message(2,new UCSYStudent("Phoo Pwint Thu",21,Gender.FEMALE,"UCSY"), "What are you doing?",Status.SEEN),
				new Message(3,new UCSYStudent("Aye Chan Nyein",21,Gender.MALE,"UCSY"), "I'm fine.",Status.SEEN),
				new Message(4,new UCSYStudent("Naw Phaw Hkee Lar Mya",21,Gender.FEMALE,"UCSY"), "Good afternoon everyone.",Status.DELIVERED)
		});
	
		if(messageGroupMap == null)
			messageGroupMap = new HashMap<Status, List<MessageGroup>>();
		if(messageGroupList == null)
			messageGroupList = Arrays.asList(new MessageGroup[] {
					new MessageGroup("1", "Internship 2020", internship2020),
					new MessageGroup("2", "Internship Meeting", internshipMeeting),
					new MessageGroup("3", "Employee Meeting",employeeMeeting)});
			
	}
	
	private void populateMessageGroupMap() {
		
		List<MessageGroup> sameStatusMessageGroupList=null;
		for(MessageGroup messageGroup:messageGroupList) {
			for(Message message:messageGroup.getMessageList()) {
				if(!message.isContainStatus(messageGroupMap)) {
					sameStatusMessageGroupList=new ArrayList<MessageGroup>();
					sameStatusMessageGroupList.add(messageGroup);
				}
				else {
					sameStatusMessageGroupList=messageGroupMap.get(message.getStatus());
					sameStatusMessageGroupList.add(messageGroup);
				}
				messageGroupMap.put(message.getStatus(), sameStatusMessageGroupList);
			}
			//System.out.println(messageGroupMap);
		}
	}
	
	public void start() {
		doInitialize();
		populateMessageGroupMap();
	}
	
}
