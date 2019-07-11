package com.gf.toDoListMaster;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.gf.toDoListMaster.controller.TaskController;
import com.gf.toDoListMaster.model.Task;
import com.gf.toDoListMaster.service.TaskServiceImpl;

@RunWith(SpringRunner.class)
@WebMvcTest(TaskController.class)
public class TaskControllerTest {

	@Autowired
    private MockMvc mvc;
 
    @MockBean
    private TaskServiceImpl taskServiceImpl;
 
    @Test
    public void givenTasks_whenFindAll_thenReturnHTMLStatusOK() throws Exception {
         
        Task task1 = new Task("Bills", "Pay Verizon bill", "To-Do");
     
        List<Task> taskList = Arrays.asList(task1);
     
        given(taskServiceImpl.findAll()).willReturn(taskList);
     
        mvc.perform(get("/")
          .contentType(MediaType.TEXT_HTML))
          .andExpect(status().isOk());
    }
}
