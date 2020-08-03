package com.bizleap.training.tutorial25;

import java.time.LocalTime;
import java.util.HashMap;
import java.util.Set;

public class BirthDayGuest {

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return new StringBuilder().append("name=" + name).toString();
	}

	public BirthDayGuest(String name) {
		super();
		this.name = name;
	}

	public LocalTime arrive() {
		return LocalTime.now();
	}

	public String serve() {
		return this.name + " get homemade ice-cream.";
	}

	public static void main(String[] args) {

		for (HashMap<BirthDayGuest, LocalTime> item : GuestUtil.getAllGuests()) {
			Set<BirthDayGuest> keys = item.keySet();
			for (BirthDayGuest key : keys)
				System.out.println(key.serve() + "Arrival Time : " +item.get(key));
		}
	}
}
