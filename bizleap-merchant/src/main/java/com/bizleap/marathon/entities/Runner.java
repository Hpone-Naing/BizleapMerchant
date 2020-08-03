package com.bizleap.marathon.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "runner")
public class Runner extends AbstractEntity{
	
	@Column (name = "currentPosition" , length = 255)
	private String currentPosition;
	
	@Column (name = "finalPosition" , length = 255)
	private String finalPosition;
		
	public Runner(long id, String boId, String name, String currentPosition, String finalPosition) {
		super(id, boId, name);
		this.currentPosition = currentPosition;
		this.finalPosition = finalPosition;
	}
	
	public String getCurrentPosition() {
		return currentPosition;
	}
	
	public void setCurrentPlace(String currentPosition) {
		this.currentPosition = currentPosition;
	}
		
	@Override
	public String toString() {
		return new StringBuilder(
				 super.toString())
				.append("currentPosition: " + currentPosition).toString();
	}	
}
