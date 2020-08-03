package com.bizleap.training.assignments;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class DisplayMessageGroup {
	
	private Scanner sc;

	public String lastMessage() {

		Map<Integer, String> lastMessage = new HashMap<Integer, String>();
		lastMessage.put(1, "Bye");
		lastMessage.put(2, "See you");
		lastMessage.put(3, "Good night");
		lastMessage.put(4, "Thank you");
		lastMessage.put(5, "Have a nice day!");

		List<String> lastMessageList=null;
		Set<Integer> keys = lastMessage.keySet();
		for (Integer key : keys) {
			if(lastMessageList==null)
			lastMessageList=new ArrayList<String>();
			lastMessageList.addAll( Arrays.asList(lastMessage.get(key)));
		}
		
		return lastMessageList.get(new Random().nextInt(lastMessageList.size()));
	}

	public String names() {
		
		List<String> names = Arrays.asList("Hla Hla", "Aung Aung", "Kyaw Kyaw", "Moe Moe",
				"Soe Soe");
		return names.get(new Random().nextInt(names.size()));
	}

	public Map<Integer, Map<String, String>> messageGroup() {

		Map<Integer, Map<String, String>> msgGroup = new HashMap<Integer, Map<String, String>>();
		Map<String, String> namesAndLastMsg = new HashMap<String, String>();
		namesAndLastMsg.put(names(), lastMessage());

		msgGroup.put(1, namesAndLastMsg);
		msgGroup.put(2, namesAndLastMsg);
		msgGroup.put(3, namesAndLastMsg);
		msgGroup.put(4, namesAndLastMsg);
		msgGroup.put(5, namesAndLastMsg);
		return msgGroup;
	}

	public void showMessageGroup() {

		List<Integer> viewedMsg = new ArrayList<Integer>();
		for (int z = 0; z < 6; z++) {
			System.out.println("Which message group do you want to view?\n Enter number(1 to 5):");
			sc = new Scanner(System.in);
			int id = sc.nextInt();
			if (viewedMsg.contains(id)) {
				System.out.println("You've viewed this message.");
				z--;
			} 
			else {
				viewedMsg.add(id);
				Set<Integer> keys = messageGroup().keySet();
				if (messageGroup().containsKey(id)) {
					for (Integer key : keys) {
						if (key == id)
							System.out.println(messageGroup().get(key));
					}
				}
			}
		}
	}

	public static void main(String[] args) {
		new DisplayMessageGroup().showMessageGroup();
	}
}
