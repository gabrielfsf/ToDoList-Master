package com.gf.toDoListMaster;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import com.gf.toDoListMaster.model.Task;
import com.gf.toDoListMaster.repository.TaskRepository;
import com.gf.toDoListMaster.service.TaskServiceI;
import com.gf.toDoListMaster.service.TaskServiceImpl;

@RunWith(SpringRunner.class)
public class TaskServiceTest {
	
	private static Task task1;
	private static Task task2;
	private static List<Task> taskList;
	private static List<Task> filteredListByCategory;
	
	@TestConfiguration
    static class TaskServiceTestContextConfiguration {
  
        @Bean
        public TaskServiceI configuration() {
            return new TaskServiceImpl();
        }
    }
	
	@Autowired
    private TaskServiceI taskService;
 
    @MockBean
    private TaskRepository taskRepository;
    
    @Before
    public void setUp() {
		task1 = new Task("Bills", "Pay Verizon bill", "To-Do");
		task2 = new Task("Grocery", "Buy dog food", "To-Do");
		taskList = new ArrayList<>(Arrays.asList(task1, task2));
		filteredListByCategory = new ArrayList<>(Arrays.asList(task1));
    }
 

	@Test
	public void givenTask_whenFindAll_thenReturnTask() {
		Mockito.when(taskRepository.findAll()).thenReturn(taskList);

		List<Task> found = taskService.findAll();
		
		assertEquals(taskList, found);
		
	}
	
	@Test
	public void givenTasks_whenFindAllTaskByStatus_thenReturnFilteredTasks() {
		Mockito.when(taskRepository.findAllTaskByStatus(task1.getStatus())).thenReturn(taskList);

		List<Task> found = taskService.findAllByStatus(task1.getStatus());
		
		assertEquals(taskList, found);
	}
	
	@Test
	public void givenTasks_whenFindAllTaskByCategory_thenReturnFilteredTasks() {
		Mockito.when(taskRepository.findAllTaskByCategory(task2.getCategory())).thenReturn(filteredListByCategory);

		List<Task> found = taskService.findByCategory(task2.getCategory());
		
		assertEquals(filteredListByCategory, found);
	}

}
