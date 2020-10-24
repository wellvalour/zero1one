package com.gruppezwei.zero1one.manager;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gruppezwei.zero1one.exception.UserAllreadyExistsException;
import com.gruppezwei.zero1one.exception.UserCanNotBeDeletedException;
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
	 * Gibt eine Liste aller User zurück
	 */
	public List<User> getAllUsers(){
		return userRepo.findAll();
	}
	
	/**
	 * Gibt eine Liste aller Usernamen zurück
	 */
	public List<String> getAllUsernames(){
		return userRepo.findAll().stream().map(this::convertToString).collect(Collectors.toList());
	}
	
	/**
	 * Gibt Berechtigung zu einem User
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
			throw new UserAllreadyExistsException("Benutzname existiert bereits!");
		}
		else if(user.getName().isEmpty()) {
			throw new UserAllreadyExistsException("Benutzname darf nicht leer sein!");
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
		if(!userRepo.existsById(user.getName())) {
			throw new UserCanNotBeDeletedException("Benutzname existiert nicht!");
		}
		else if(user.getName().isEmpty()) {
			throw new UserCanNotBeDeletedException("Benutzname darf nicht leer sein!");
		}
		userRepo.delete(user);;
	}
	
	/**
	 * Löscht User anhand des Namens
	 * @param name
	 */
	public void deleteUserById(String name) {
		if(!userRepo.existsById(name)) {
			throw new UserCanNotBeDeletedException("Benutzname existiert nicht!");
		}
		else if(name.isEmpty()) {
			throw new UserCanNotBeDeletedException("Benutzname darf nicht leer sein!");
		}
		userRepo.deleteById(name);
	}
	
	/**
	 * ändert Username
	 * @param nameAlt
	 * @param nameNeu
	 */
	public void changeUsername(String nameAlt, String nameNeu) {
		User user = getUserByName(nameAlt).get(0);
		deleteUser(user);
		user.setName(nameNeu);
		userAnlegen(user);
	}

	private String convertToString(User user) {
		return user.getName();
	}
}
