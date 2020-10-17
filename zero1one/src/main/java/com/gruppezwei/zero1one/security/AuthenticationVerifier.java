package com.gruppezwei.zero1one.security;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gruppezwei.zero1one.manager.AuthenticationManager;
import com.gruppezwei.zero1one.repository.User;

@Component
public class AuthenticationVerifier {
	
	@Autowired 
	AuthenticationManager authManager;
	
	public boolean verifyUser(String name, String password) {
		
		
		List<User> list = authManager.getUserByName(name);
		
		User user = null;
		
		if(list.size()> 0) {
			user = list.get(0);
		} else {
			return false;
		}
		
		if(!user.getName().equals(name)) {
			 return false;
		} else if(user.getPasswort().equals(password)) {
			return true;
		} else {
			 return false;
		}
	}
}
