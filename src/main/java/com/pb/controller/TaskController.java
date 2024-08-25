package com.pb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pb.model.Task;
import com.pb.model.User;
import com.pb.service.TaskService;

@RestController
@RequestMapping("/")
public class TaskController {
	
	@Autowired
	private TaskService service;
	
	@PostMapping("create-task")
	public String createTask(@RequestBody Task task) {
		return service.createTask(task);
	}
	
	@GetMapping("get-task")
	public List<Task> getTask() {
		return service.getTask();
	}
	
	@PutMapping("update-task/{id}")
	public Task updateTask(@PathVariable int id ,@RequestBody Task task) {
		return service.updateTask(id,task);
	}
	
	@DeleteMapping("delete-task/{id}")
	public String deleteTask(@PathVariable int id) {
		return service.deleteTask(id);
	}
}
