package com.gf.toDoListMaster;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.gf.toDoListMaster.model.Task;
import com.gf.toDoListMaster.repository.TaskRepository;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.MOCK, classes = ToDoListMasterApplication.class)
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:application-integrationtest.properties")
public class ToDoListApplicationIntegrationTest {
	
	private Task task1;
	
	@Autowired
    private TaskRepository taskRepository;
	
	@Autowired
	private MockMvc mvc;
	
	@Test
	public void givenTasks_findAll_returnsHtmlAnd200Status() throws Exception {
		task1 = new Task("Bills", "Pay Verizon bill", "To-Do");
		taskRepository.save(task1);
		
		mvc.perform(get("/")
			.contentType(MediaType.TEXT_HTML))
			.andExpect(status().isOk())
			.andExpect(content()
			.contentTypeCompatibleWith(MediaType.TEXT_HTML));
	}
	
}
