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
}
