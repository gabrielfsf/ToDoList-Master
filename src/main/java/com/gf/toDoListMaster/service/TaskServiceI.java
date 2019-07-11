package com.gf.toDoListMaster.service;

import java.util.List;

import com.gf.toDoListMaster.model.Task;

public interface TaskServiceI {

	public void deleteAll();
	public void save(Task task);
	public List<Task> findAll();
	public Task findById(Integer id);
	public void deleteById(Integer id);
	public void updateTaskById(Integer id, Task task);
	public List<Task> findByCategory(String category);
	public List<Task> findAllByStatus(String status);
}
