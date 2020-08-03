package com.bizleap.common.domain;

import java.util.Date;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class AbstractEntity {
	
	@Id
	@GeneratedValue
	private long id;
	private String boId;
	private Date creationDate;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getBoId() {
		return boId;
	}
	public void setBoId(String boId) {
		this.boId = boId;
	}
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	
	protected AbstractEntity clone(AbstractEntity abstractEntity) {
		abstractEntity.setId(getId());
		abstractEntity.setBoId(getBoId());
		abstractEntity.setCreationDate(getCreationDate());
		return abstractEntity;
	}
	
//	public boolean sameBoId(String boId) {
//		return this.boId != null && boId != null && this.boId.equals(boId);
//	}
//	
	public boolean sameBoId(AbstractEntity entity) {
		if(entity!=null)
			return this.getBoId().equals(entity.getBoId());
		return false;
	}

	protected int compareTo(AbstractEntity entity) {
		return this.getBoId().compareTo(entity.getBoId());
	}
		
	public boolean isBoIdRequired() {
		return boId == null || SystemConstant.BOID_REQUIRED.equals(getBoId());
	}
	
	@Override
	public String toString() {
		return new StringBuffer()
				.append("Id: " + id) 
				.append("BoId: " + boId)
				//.append("Creation Date: " + creationDate)
				.toString();
	}
}
