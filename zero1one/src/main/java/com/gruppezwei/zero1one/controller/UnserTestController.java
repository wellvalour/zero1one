package com.gruppezwei.zero1one.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.gruppezwei.zero1one.manager.PersistenceManager;
import com.gruppezwei.zero1one.manager.ServiceManager;
import com.gruppezwei.zero1one.repository.User;

@Controller
public class UnserTestController {

	@Autowired
	ServiceManager manager;
	
	@Autowired
	PersistenceManager persman;

	@GetMapping(value = "/item", consumes = { MediaType.ALL_VALUE }, produces = { MediaType.TEXT_HTML_VALUE })
	public String getItemGanz(Model model) {
		List<UnserTestobjekt> testobj = manager.getConfigItemGanz();

		model.addAttribute("unserTestTemplate", testobj);

		return "unserTestTemplate";
	}

	@GetMapping(value = "/instanz", consumes = { MediaType.ALL_VALUE }, produces = { MediaType.TEXT_HTML_VALUE })
	public String getInstanzGanz(Model model) {
		List<UnserTestobjekt> testobj = manager.getInstanzGanz();

		model.addAttribute("unserTestTemplate", testobj);

		return "unserTestTemplate";
	}

	@GetMapping(value = "/user", consumes = { MediaType.ALL_VALUE }, produces = { MediaType.TEXT_HTML_VALUE })
	public String getUserGanz(Model model) {

		User pete = new User();
		pete.setName("Max");
		pete.setBerechtigungsID(2);
		pete.setPasswort("Passwort123");

		List<User> list = new ArrayList<User>();
		list.add(pete);

		manager.persistUserGanz(list);

//		manager.deleteUser(list);

		List<UnserTestobjekt> testobj = manager.getUserGanz();

		model.addAttribute("unserTestTemplate", testobj);

		return "unserTestTemplate";
	}

	@GetMapping(value = "/atttyp", consumes = { MediaType.ALL_VALUE }, produces = { MediaType.TEXT_HTML_VALUE })
	public String getAttTypGanz(Model model) {
		List<UnserTestobjekt> testobj = manager.getAttributTypGanz();

		model.addAttribute("unserTestTemplate", testobj);

		return "unserTestTemplate";
	}

	@GetMapping(value = "/attribut", consumes = { MediaType.ALL_VALUE }, produces = { MediaType.TEXT_HTML_VALUE })
	public String getAttributGanz(Model model) {
		List<UnserTestobjekt> testobj = manager.getAttributGanz();

		model.addAttribute("unserTestTemplate", testobj);

		return "unserTestTemplate";
	}

	@GetMapping(value = "/confTyp", consumes = { MediaType.ALL_VALUE }, produces = { MediaType.TEXT_HTML_VALUE })
	public String getConfigItemTYpGanz(Model model){
		List<UnserTestobjekt> testobj = manager.getConfigItemTypGanz();
		
		List<CiRecord> test = new ArrayList<CiRecord>();
		CiRecord rec = new CiRecord();
		rec.setCiTyp("Typ21");
		rec.setId(20004);
		rec.setName("Neuer Record");
		
		List<Attribute> att = new ArrayList<Attribute>();
		
		Attribute att1 = new Attribute();
		att1.setId(20006);
		att1.setCiRecordId(20005);
		att1.setAttributtyp("Attribut7");
		att1.setWert("NeuerWert1");
		
		Attribute att2 = new Attribute();
		att2.setId(20007);
		att2.setCiRecordId(20008);
		att2.setAttributtyp("Attribut8");
		att2.setWert("NeuerWert2");
		
		att.add(att1);
		att.add(att2);
		
		rec.setAttribute(att);
		
		test.add(rec);
		
		persman.persistConfigItemMitAttributen(test);
		
		model.addAttribute("unserTestTemplate", testobj);
		
		return "unserTestTemplate";
	}

	@GetMapping(value = "/ciname", consumes = { MediaType.ALL_VALUE }, produces = { MediaType.TEXT_HTML_VALUE })
	public String getConfigItemByName(Model model) {
		List<UnserTestobjekt> testobj = manager.getConfigItemByName("Maus");

		model.addAttribute("unserTestTemplate", testobj);

		return "unserTestTemplate";
	}
}
