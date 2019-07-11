package com.gf.toDoListMaster.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gf.toDoListMaster.model.Task;
import com.gf.toDoListMaster.repository.TaskRepository;

@Service
public class TaskServiceImpl implements TaskServiceI {
	
	@Autowired
	TaskRepository taskRepository;

	@Override
	public void save(Task task) {
		taskRepository.save(task);
	}

	@Override
	public List<Task> findAll() {
		return taskRepository.findAll();
	}

	@Override
	public List<Task> findAllByStatus(String status) {
		return taskRepository.findAllTaskByStatus(status);
	}

	@Override
	public List<Task> findByCategory(String category) {
		return taskRepository.findAllTaskByCategory(category);
	}

	@Override
	public void deleteAll() {
		taskRepository.deleteAll();
	}

	@Override
	public void deleteById(Integer id) {
		taskRepository.deleteById(id);
	}

	@Override
	public Task findById(Integer id) {
		return taskRepository.findTaskById(id);
	}

	@Override
	public void updateTaskById(Integer id, Task task) {
		Task taskToUpdate = taskRepository.findTaskById(id);
		String category = task.getCategory();
		String description = task.getDescription();
		String status = task.getStatus();
		if(category != null) taskToUpdate.setCategory(category);
		if(description != null) taskToUpdate.setDescription(description);
		if(status != null) taskToUpdate.setStatus(status);
		taskRepository.save(taskToUpdate);
	}
}
