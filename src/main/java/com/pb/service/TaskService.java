package com.pb.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pb.dao.TaskDao;
import com.pb.model.Task;

@Service
public class TaskService {
	
	@Autowired
	private TaskDao tdao;
	
	public String createTask(Task task) {
		// TODO Auto-generated method stub
		tdao.save(task);
		if(tdao != null) {
			return "Task Created SuccessFully";
		}
		return null;
	}

	public List<Task> getTask() {
		// TODO Auto-generated method stub
		return tdao.findAll();
	}

	public Task updateTask(int id, Task task) {
		// TODO Auto-generated method stub
		Optional<Task> tsk = tdao.findById(id);
		
		if(tsk.isPresent()) {
			Task tk = tsk.get();
			tk.setCreated_at(task.getCreated_at());
			tk.setDescription(task.getDescription());
			tk.setDue_date(task.getDue_date());
			tk.setPriority(task.getPriority());
			tk.setStatus(task.getStatus());
			tk.setTitle(task.getTitle());
			tk.setUpdated_at(task.getUpdated_at());
			
			return tdao.save(tk);
			
		}else {
			throw new RuntimeException("Task not found with id: "+id);
		}
	}

	public String deleteTask(int id) {
		// TODO Auto-generated method stub
		tdao.deleteById(id);
		return "Deleted SuccessFully";
	}

}
