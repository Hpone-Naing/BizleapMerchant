package com.bizleap.marathon.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "marathonrunner")
public class MarathonRunner extends Runner{

	@Column (name = "runningDistance" , length = 255)
	private final String runningDistance = "26km";
	
	public MarathonRunner(long id, String boId, String name, String currentPosition, String finalPosition) {
		super(id, boId, name, currentPosition, finalPosition);
	}
	
	public String getRunningDistance() {
		return runningDistance;
	}

	@Override
	public String toString() {
		return new StringBuilder(
				 super.toString())
				.append("RunningDistance: " + runningDistance).toString();
	}	
}
