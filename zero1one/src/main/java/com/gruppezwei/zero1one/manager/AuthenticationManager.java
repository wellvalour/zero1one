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
	
	/**
	 * Gibt User zu einem Username zurück
	 * @param name
	 */
	public List<User> getUserByName(String name) {
		return userRepo.findByName(name);
	}
	
	/**
	 * Gibt berchtigung zu einem User
	 * @param username
	 */
	public String getBerechtigung(String username) {
		List<User> user = userRepo.findByName(username);
		
		int id = user.get(0).getBerechtigungsID();
		
		return berRepo.findById(id).get(0).getBezeichnung();
	}
	
	/**
	 * Speichert einen Nutzer ab
	 * @param user
	 */
	public void userAnlegen(User user) {
		if(userRepo.existsById(user.getName())) {
			
		}
		userRepo.save(user);
	}
	
	/**
	 * Speichert neues Passwort (Hashwert) zu User ab.
	 * Nutzername und Berechtigung müssen trotzdem gesetzt sein.
	 * @param user
	 */
	public void changePassword(User user) {
		userRepo.save(user);
	}
	
	/**
	 * Speichert neue Berechtigung zu User ab.
	 * Nutzername und Passwort (Hashwert) müssen trotzdem gesetzt sein.
	 * @param user
	 */
	public void changeBerechtigung(User user) {
		userRepo.save(user);
	}
	
	/**
	 * Löscht User anhand seiner Entität
	 * @param user
	 */
	public void deleteUser(User user) {
		userRepo.delete(user);;
	}
	
	/**
	 * Löscht User anhand des Namens
	 * @param name
	 */
	public void deleteUserById(String name) {
		userRepo.deleteById(name);
	}
}
