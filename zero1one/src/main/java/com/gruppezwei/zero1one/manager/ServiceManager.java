package com.gruppezwei.zero1one.manager;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gruppezwei.zero1one.controller.UnserTestobjekt;
import com.gruppezwei.zero1one.repository.Attribut;
import com.gruppezwei.zero1one.repository.AttributRepository;
import com.gruppezwei.zero1one.repository.Attributtyp;
import com.gruppezwei.zero1one.repository.AttributtypRepository;
import com.gruppezwei.zero1one.repository.Configitem;
import com.gruppezwei.zero1one.repository.ConfigitemRepository;
import com.gruppezwei.zero1one.repository.Configitemtyp;
import com.gruppezwei.zero1one.repository.ConfigitemtypRepository;
import com.gruppezwei.zero1one.repository.Instanz;
import com.gruppezwei.zero1one.repository.InstanzRepository;
import com.gruppezwei.zero1one.repository.User;
import com.gruppezwei.zero1one.repository.UserRepository;

@Component
public class ServiceManager {
	
	@Autowired
	ConfigitemRepository itemRepo;
	
	@Autowired
	InstanzRepository instanzRepo;
	
	@Autowired
	UserRepository userRepo;
	
	@Autowired
	AttributtypRepository attTypRepo;
	
	@Autowired
	AttributRepository attributRepo;
	
	@Autowired 
	ConfigitemtypRepository confTypRepo;
	
	

	/**
	 * Gibt alle User zurück
	 */
	public List<UnserTestobjekt> getUserGanz() {
		List<User> item = userRepo.findAll();

		List<UnserTestobjekt> testobj = item.stream().map(this::convertTestobjekt).collect(Collectors.toList());

		return testobj;
	}
	
	/**
	 * Gibt alle User zurück
	 */
	public void persistUserGanz(List<User> users) {
		userRepo.saveAll(users);
	}
	
	
	/**
	 * Gibt alle User zurück
	 */
	public void deleteUser(List<User> users) {
		userRepo.delete(users.get(0));;
	}
	
	
	
	/**
	 * Gibt alle ConfigItems zurück
	 */
	public List<UnserTestobjekt> getConfigItemGanz() {
		List<Configitem> item = itemRepo.findAll();

		List<UnserTestobjekt> testobj = item.stream().map(this::convertTestobjekt).collect(Collectors.toList());

		return testobj;
	}

	/**
	 * Gibt ConfigItems mit gefragtem Configitemname zurück
	 * @param name
	 * @return
	 */
	public List<UnserTestobjekt> getConfigItemByName(String name) {
		List<Configitem> item = itemRepo.findByConfigitemtypname(name);

		List<UnserTestobjekt> testobj = item.stream().map(this::convertTestobjekt2).collect(Collectors.toList());

		return testobj;
	}
	
	/**
	 * Gibt alle Attributtypen zurück
	 */
	public List<UnserTestobjekt> getAttributTypGanz() {
		List<Attributtyp> item = attTypRepo.findAll();

		List<UnserTestobjekt> testobj = item.stream().map(this::convertTestobjekt).collect(Collectors.toList());

		return testobj;
	}
	
	/**
	 * Gibt alle Attribute zurück
	 */
	public List<UnserTestobjekt> getAttributGanz() {
		List<Attribut> item = attributRepo.findAll();

		List<UnserTestobjekt> testobj = item.stream().map(this::convertTestobjekt).collect(Collectors.toList());

		return testobj;
	}
	
	/**
	 * Gibt alle ConfigItemTypen zurück
	 */
	public List<UnserTestobjekt> getConfigItemTypGanz() {
		List<Configitemtyp> item = confTypRepo.findAll();

		List<UnserTestobjekt> testobj = item.stream().map(this::convertTestobjekt).collect(Collectors.toList());

		return testobj;
	}
	
	/**
	 * Gibt alle ConfigItems zurück
	 */
	public List<UnserTestobjekt> getInstanzGanz() {
		List<Instanz> item = instanzRepo.findAll();

		List<UnserTestobjekt> testobj = item.stream().map(this::convertTestobjekt).collect(Collectors.toList());

		return testobj;
	}

	//Mapping-Methoden
	//Mappen Abfrageobjekt in unserTestobjekte
	
	private UnserTestobjekt convertTestobjekt(Configitem i) {
		UnserTestobjekt u = new UnserTestobjekt();

		u.setEins(""+ i.getId());
		u.setZwei(i.getConfigItemTypname());
		u.setDrei(i.getName());

		return u;
	}
	
	private UnserTestobjekt convertTestobjekt(User u) {
		UnserTestobjekt t = new UnserTestobjekt();

		t.setEins(""+ u.getName());
		t.setZwei(u.getPasswort());
		t.setDrei(""+ u.getBerechtigungsID());

		return t;
	}

	private UnserTestobjekt convertTestobjekt(Attributtyp u) {
		UnserTestobjekt t = new UnserTestobjekt();

		t.setEins(""+ u.getName());
		t.setZwei(u.getConfigItemTypname());

		return t;
	}

	private UnserTestobjekt convertTestobjekt(Attribut u) {
		UnserTestobjekt t = new UnserTestobjekt();

		t.setEins(""+ u.getAttributtypID());
		t.setZwei(u.getWert());
		t.setDrei(""+ u.getConfigItemID());
		t.setVier(""+ u.getId());

		return t;
	}
	
	private UnserTestobjekt convertTestobjekt(Instanz i) {
		UnserTestobjekt u = new UnserTestobjekt();

		u.setEins(""+ i.getId());
		u.setZwei(""+ i.getInstanzTypname());
		u.setDrei(i.getName());

		return u;
	}

	private UnserTestobjekt convertTestobjekt(Configitemtyp i) {
		UnserTestobjekt u = new UnserTestobjekt();

		u.setEins(""+ i.getName());

		return u;
	}
	
	private UnserTestobjekt convertTestobjekt2(Configitem i) {
		UnserTestobjekt u = new UnserTestobjekt();

		u.setEins(""+ i.getName());

		return u;
	}
	
}
