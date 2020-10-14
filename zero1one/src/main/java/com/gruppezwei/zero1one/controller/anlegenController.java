package com.gruppezwei.zero1one.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.gruppezwei.zero1one.manager.PersistenceManager;
import com.gruppezwei.zero1one.repository.Attributtyp;

/**
 * Controller für die Seiten Ci-Typ und Ci-Record.
 * Ermöglicht das anlegen von Typen und Records.
 *
 */


@SpringBootApplication
@Controller
public class anlegenController {

	@Autowired
	PersistenceManager manager;
	
	@GetMapping(value = "/ci-typ", consumes = { MediaType.ALL_VALUE }, produces = { MediaType.TEXT_HTML_VALUE })
	public String setType(Model model) {

		CiType neu = new CiType();
		neu.setTypen(new ArrayList<Attributtypen>());
		for(int i=1; i<=3; i++){
			neu.getTypen().add(new Attributtypen());
		}

		model.addAttribute("TypObj", neu);
		
		return "ci-typ";
	}
	
	@PostMapping("/ci-typ")
	public String typeSubmit(@ModelAttribute CiType TypObj, Model model) {		
		for(Attributtypen at : TypObj.getTypen()) {
		at.setConfigItemTyp(TypObj.getName());	
		}
		ArrayList<CiType> neueListe = new ArrayList<CiType>();
		neueListe.add(TypObj);
		manager.persistConfigItemTypeMitAttributen(neueListe);
		
		CiType neu = new CiType();
		neu.setTypen(new ArrayList<Attributtypen>());
		for(int i=1; i<=3; i++){
			neu.getTypen().add(new Attributtypen());
		}

		model.addAttribute("TypObj", neu);
		
		return "ci-typ";
	}
	
	@GetMapping(value = "/ci-record", consumes = { MediaType.ALL_VALUE }, produces = { MediaType.TEXT_HTML_VALUE })
	public String setRecord(Model model) {

		
		return "ci-record";
	}
}
