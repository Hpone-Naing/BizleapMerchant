package com.bizleap.marathon.entities;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class AbstractEntity {

	@Id
	@GeneratedValue
	private long id;
	private String boId;
	private String name;

	public AbstractEntity(long id, String boId, String name) {
		this.id = id;
		this.boId = boId;
		this.name = name;
	}

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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return new StringBuilder().append("id: " + id).append("boId: " + boId).append("name: " + name).toString();
	}
}
