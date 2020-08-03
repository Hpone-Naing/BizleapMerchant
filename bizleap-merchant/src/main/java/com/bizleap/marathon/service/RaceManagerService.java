package com.bizleap.marathon.service;

import java.util.List;

import com.bizleap.marathon.entities.Runner;

public interface RaceManagerService {

	public void saveARunner();
	public List<Runner> getAllRunners();
	public List<Runner> getAllRunnersInEachRace();
	public List<Runner> getAllCompletedRunners();
	public List<Runner> getAllCompletedRunnersInEachRace();
}
