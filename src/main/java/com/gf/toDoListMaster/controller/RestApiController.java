package com.gf.toDoListMaster.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gf.toDoListMaster.model.Task;
import com.gf.toDoListMaster.service.TaskServiceImpl;

@RestController
@RequestMapping("/api")
public class RestApiController {

	@Autowired
	private TaskServiceImpl taskServiceImpl;
	
	@GetMapping("/tasks")
	public List<Task> findAll() {
		return taskServiceImpl.findAll();
	}
	
	@GetMapping("/tasks/{id}")
	public Task findById(Integer id) {
		return taskServiceImpl.findById(id);
	}
	
	@PostMapping("/tasks/new")
	public String addNewTask(Task task){
		taskServiceImpl.save(task);
		return "Task Created Successfully";
	}
	
	@DeleteMapping("/tasks/{id}")
	public String deleteTaskById(@PathVariable Integer id) {
		taskServiceImpl.deleteById(id);
		return "Task Deleted Successfully";
	}
	
	@DeleteMapping("/tasks")
	public String deleteAllTasks() {
		taskServiceImpl.deleteAll();
		return "All Tasks Deleted Successfully";
	}
	
	@PutMapping("/tasks/{id}")
	public String updateJokeById(@PathVariable Integer id, Task task) {
		taskServiceImpl.updateTaskById(id, task);
		return "Task Updated Successfully";
	}
	
}

