package com.gf.toDoListMaster.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.gf.toDoListMaster.model.Task;
import com.gf.toDoListMaster.service.TaskServiceImpl;


@Controller
public class TaskController {

	@Autowired
	TaskServiceImpl taskServiceImpl;
	
	@GetMapping("/") 
	public String getList(Model model) {
		List<Task> tasks = taskServiceImpl.findAll();
        model.addAttribute("taskList", tasks);
		return "toDoList";
	}
}
