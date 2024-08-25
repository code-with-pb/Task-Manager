package com.pb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pb.model.User;
import com.pb.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService service;
	
	
	@PostMapping("/register")
	public User addUser(@RequestBody User user) {
		return service.addUser(user);
	}
	
	@PostMapping("/login")
	public String login(@RequestBody User user) {
		return service.verify(user);
		
	}
}
