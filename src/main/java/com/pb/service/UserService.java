package com.pb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.pb.dao.UserDao;
import com.pb.model.User;

@Service
public class UserService {
	@Autowired
	private UserDao users;
	@Autowired
	private AuthenticationManager autheManager;
	@Autowired
	private JWTService jwtservice;
	
	private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);
	
	public User addUser(User user) {
		
		user.setPassword(encoder.encode(user.getPassword()));
		
		return users.save(user);
		
	}

	public String verify(User user) {
		// TODO Auto-generated method stub
		
		Authentication authentication = 
				autheManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
		if(authentication.isAuthenticated()) {
			return jwtservice.generateToken(user.getUsername());
		}
		return "Fail";
	}

}
