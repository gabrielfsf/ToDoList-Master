package com.gf.toDoListMaster.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gf.toDoListMaster.model.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer> {

	public Task findTaskById(Integer id);
	public List<Task> findAllTaskByStatus(String status);
	public List<Task> findAllTaskByCategory(String category);
}
