package com.bizleap.marathon.resource.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bizleap.marathon.entities.Runner;
import com.bizleap.marathon.resource.RunnerServiceResource;
import com.bizleap.marathon.service.RaceManagerService;

@RestController
@RequestMapping(value = {"/runner"})
public class RunnerServiceResourceImpl implements RunnerServiceResource{

	@Autowired
	RaceManagerService raceManagerService;
	
	@Override
	@RequestMapping(method = RequestMethod.GET, value = "/list")
	public @ResponseBody List<Runner> getAllCompletedRunnersInEachRace(HttpServletRequest request) throws Exception {
		return raceManagerService.getAllCompletedRunnersInEachRace();
	}
}
