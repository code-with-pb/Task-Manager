package com.pb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.pb.dao.UserDao;
import com.pb.model.User;
import com.pb.model.UserPrinciple;

@Service
public class MyUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UserDao users;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		
		User user = users.findByUsername(username);
		if(user == null) {
			System.out.println("User not found");
			throw new UsernameNotFoundException("user not found");
		}
		
		return new UserPrinciple(user);
	}

}
