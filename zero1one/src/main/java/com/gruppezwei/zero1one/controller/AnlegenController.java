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

import com.gruppezwei.zero1one.manager.DeleteManager;
import com.gruppezwei.zero1one.manager.PersistenceManager;
import com.gruppezwei.zero1one.manager.ReadManager;
import com.gruppezwei.zero1one.manager.UpdateManager;
import com.gruppezwei.zero1one.repository.Attributtyp;

/**
 * Controller für die Seiten Ci-Typ und Ci-Record.
 * Ermöglicht das anlegen von Typen und Records.
 *
 */



@SpringBootApplication
@Controller
public class AnlegenController {

	@Autowired
	PersistenceManager speichern;
	@Autowired
	ReadManager lesen;
	
	String Zwischenspeicher = new String();
	
	
	@GetMapping(value = "/ci-typ", consumes = { MediaType.ALL_VALUE }, produces = { MediaType.TEXT_HTML_VALUE })
	public String setType(Model model) {

		CiType neu = new CiType();
		neu.setTypen(new ArrayList<Attributtypen>());
		for(int i=0; i<3; i++){
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
		speichern.persistConfigItemTypeMitAttributen(neueListe);
		
		CiType neu = new CiType();
		neu.setTypen(new ArrayList<Attributtypen>());
		for(int i=0; i<3; i++){
			neu.getTypen().add(new Attributtypen());
		}

		model.addAttribute("TypObj", neu);
		
		return "ci-typ";
	}
	
	@GetMapping(value = "/ci-record", consumes = { MediaType.ALL_VALUE }, produces = { MediaType.TEXT_HTML_VALUE })
	public String getRecord(Model model) {

		List<String> TypObj = lesen.getCiTypeAsString();

		model.addAttribute("search", TypObj);
		model.addAttribute("suche", new CiSearch());
		
		return "ci-record";
	}
	
	@PostMapping(value = "/ci-record", consumes = { MediaType.ALL_VALUE }, produces = { MediaType.TEXT_HTML_VALUE })
	public String getAttributeToType(@ModelAttribute CiSearch suche, Model model) {

		Zwischenspeicher=suche.getSuchbegriff();
		List<Attributtypen> ListeAttributtypen = lesen.getAttributTypNachCiType(suche.getSuchbegriff());
		List<String> TypObj = lesen.getCiTypeAsString();
		
		int laenge = ListeAttributtypen.size();
		ArrayList<Attribute> ListeAttribute = new ArrayList<Attribute>();
		for(int i=0; i<laenge; i++){
			ListeAttribute.add(new Attribute());
		}
		
		Hilfsobjekt hilfe = new Hilfsobjekt();
		hilfe.setTypen(ListeAttributtypen);
		hilfe.setType(ListeAttribute);
		hilfe.setCiType(suche.getSuchbegriff());
		
		model.addAttribute("search", TypObj);
		model.addAttribute("suche", new CiSearch());
		model.addAttribute("AttObj", hilfe);
		
		return "ci-record1";
	}
	
	
	
	@PostMapping(value = "/ci-record-submit", consumes = { MediaType.ALL_VALUE }, produces = { MediaType.TEXT_HTML_VALUE })
	public String getAttributeType(@ModelAttribute Hilfsobjekt hilfsObj, Model model) {
		
		CiRecord neuerRecord = new CiRecord();
		neuerRecord.setAttribute(hilfsObj.getType());
		neuerRecord.setCiTyp(Zwischenspeicher);
		neuerRecord.setName(hilfsObj.getRecordName());
		ArrayList<CiRecord> neueRecordListe = new ArrayList<CiRecord>();
		neueRecordListe.add(neuerRecord);
		speichern.persistConfigItemMitAttributen(neueRecordListe);
		
		
		List<String> TypObj = lesen.getCiTypeAsString();

		model.addAttribute("search", TypObj);
		model.addAttribute("suche", new CiSearch());
		
		
		return "ci-record";
	}
}
