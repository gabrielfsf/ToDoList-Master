package com.gf.toDoListMaster.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
}

