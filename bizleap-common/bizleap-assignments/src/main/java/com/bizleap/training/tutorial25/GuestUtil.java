package com.bizleap.training.tutorial25;

import java.time.*;
import java.util.*;

public class GuestUtil {

	public static List<HashMap<BirthDayGuest, LocalTime>> getAllGuests() {
		List<HashMap<BirthDayGuest, LocalTime>> arriveGuests = null;
		HashMap<BirthDayGuest, LocalTime> inTimeGuests = new HashMap<BirthDayGuest, LocalTime>();
		BirthDayGuest guests[] = { new BirthDayGuest("Hla Hla"), new BirthDayGuest("Mg Mg"),
				new BirthDayGuest("Moe Moe"), new BirthDayGuest("Kyaw Kyaw"), new BirthDayGuest("Aung Aung") };
		for (BirthDayGuest guest : guests) {
			inTimeGuests.put(guest, guest.arrive());
			arriveGuests = new ArrayList<HashMap<BirthDayGuest, LocalTime>>();
			arriveGuests.add(inTimeGuests);
		}
		return arriveGuests;

	}
}
