package com.gf.toDoListMaster.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Task {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	private String category;
	
	private String description;
	
	private String status;;
	
	public Task() {
		
	}

	public Task(String category, String description, String status) {
		this.category = category;
		this.description = description;
		this.status = status;
	}
	
	public String getCategory() {
		return category;
	}

	public void setUser(String category) {
		this.category = category;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getId() {
		return id;
	}
	
}
