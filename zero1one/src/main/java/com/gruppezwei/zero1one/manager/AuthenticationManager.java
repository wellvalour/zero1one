package com.gruppezwei.zero1one.manager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gruppezwei.zero1one.repository.User;
import com.gruppezwei.zero1one.repository.UserRepository;

@Component
public class AuthenticationManager {
	
	@Autowired
	UserRepository userRepo;
	
	
	public List<User> getUserByName(String name) {
		return userRepo.findByName(name);
	}
	
}
