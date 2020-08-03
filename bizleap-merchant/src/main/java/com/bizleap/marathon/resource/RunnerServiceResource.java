package com.bizleap.marathon.resource;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.ResponseBody;
import com.bizleap.marathon.entities.Runner;

public interface RunnerServiceResource {
	
	public @ResponseBody List<Runner> getAllCompletedRunnersInEachRace(HttpServletRequest request) throws Exception;	
}
