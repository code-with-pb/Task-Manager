package com.pb.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pb.model.User;
import java.util.List;


@Repository
public interface UserDao extends JpaRepository<User, Integer>{
	
	User findByUsername(String username);
}
