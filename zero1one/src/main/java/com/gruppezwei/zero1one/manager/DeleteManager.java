package com.gruppezwei.zero1one.manager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gruppezwei.zero1one.repository.AttributRepository;
import com.gruppezwei.zero1one.repository.AttributtypRepository;
import com.gruppezwei.zero1one.repository.ConfigitemRepository;
import com.gruppezwei.zero1one.repository.ConfigitemtypRepository;


/**
 * Dieser Manager bietet Methoden zum Löschen von bestehenden Objekten in einer Datenbank.
 * 
 * @author wellvalour
 *
 */
@Component
public class DeleteManager {
	
	@Autowired
	ReadManager readman;
	
	@Autowired
	ConfigitemtypRepository confTypRepo;
	
	@Autowired
	AttributtypRepository attTypRepo;

	@Autowired
	ConfigitemRepository confItemRepo;

	@Autowired
	AttributRepository attributRepo;

	
	/**
	 * Löscht den CiTyp mit diesem Namen und alle zugehörigen Attribute.
	 */
	public void deleteCiType(String name) {
		confTypRepo.deleteById(name);
		
		List<String> ids = readman.getAttributTypIDtoCiType(name);
		
		for(String s : ids) {
			deleteAttributTypNachId(s);
		}
	}
	
	/**
	 * Löscht ein Attributtyp nach seiner ID.
	 */
	public void deleteAttributTypNachId(String id) {
		attTypRepo.deleteById(id);
	}
	
	/**
	 * Löscht den CiRecord mit diesem Namen und alle zugehörigen Attribute.
	 */
	public void deleteCiRecord(Integer id) {
		confItemRepo.deleteById(id);
		
		List<Integer> ids = readman.getAttributIDtoCiRecord(id);
		
		for(int s : ids) {
			deleteAttributNachId(s);
		}
	}
	
	/**
	 * Löscht ein Attribut nach seiner ID.
	 */
	public void deleteAttributNachId(int id) {
		attributRepo.deleteById(id);
	}
}