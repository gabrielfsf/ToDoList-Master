package com.gf.toDoListMaster.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.gf.toDoListMaster.model.Task;
import com.gf.toDoListMaster.service.TaskServiceImpl;


@Controller
public class TaskController {

	@Autowired
	TaskServiceImpl taskServiceImpl;
	
	@GetMapping("/") 
	public String showTaskList(Model model) {
		List<Task> tasks = taskServiceImpl.findAll();
        model.addAttribute("taskList", tasks);
		return "toDoList";
	}
	
	@GetMapping("/new") 
	public String addNewTaskForm(Model model) {
		model.addAttribute("task", new Task());
		return "newTaskForm";
	}
	
	@PostMapping("/new")
	public String submitTaskForm(Task task, Model model) {
        
    	taskServiceImpl.save(task);
        model.addAttribute("successMessage", "Task successfully added!");
        model.addAttribute("task", new Task());
        
        return "newTaskForm";
    }
}
