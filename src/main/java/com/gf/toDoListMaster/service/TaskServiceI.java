package com.gf.toDoListMaster.service;

import java.util.List;

import com.gf.toDoListMaster.model.Task;

public interface TaskServiceI {

	public void save(Task task);
	public List<Task> findAll();
	public List<Task> findByCategory(String category);
	public List<Task> findAllByStatus(String status);
}
