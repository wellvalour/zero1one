package com.gruppezwei.zero1one.manager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gruppezwei.zero1one.repository.BerechtigungRepository;
import com.gruppezwei.zero1one.repository.User;
import com.gruppezwei.zero1one.repository.UserRepository;

@Component
public class AuthenticationManager {
	
	@Autowired
	UserRepository userRepo;
	
	@Autowired
	BerechtigungRepository berRepo;
	
	
	public List<User> getUserByName(String name) {
		return userRepo.findByName(name);
	}
	
	public String getBerechtigung(String username) {
		List<User> user = userRepo.findByName(username);
		
		int id = user.get(0).getBerechtigungsID();
		
		return berRepo.findById(id).get(0).getBezeichnung();
	}
	
	
}
