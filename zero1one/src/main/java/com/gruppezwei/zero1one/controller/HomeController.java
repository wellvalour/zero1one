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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.gruppezwei.zero1one.manager.PersistenceManager;
import com.gruppezwei.zero1one.manager.ServiceManager;

/**
 * Controller für das Dashboard und die Unterseiten.
 * Ermöglicht die Navigation zwischen Dashboard, Ci-Typen, Ci-Record und implementiert die Suche auf diesen Seiten.
 *
 */

@SpringBootApplication
@Controller
public class HomeController {

	
	@Autowired
	PersistenceManager manager;

	@GetMapping(value = "/dashboard", consumes = { MediaType.ALL_VALUE }, produces = { MediaType.TEXT_HTML_VALUE })
	public String getType(Model model) {
		List<CiType> TypObj = manager.getCiTypeAll();
		List<String> SeaObj = manager.getSuchbegriffeAll();

		model.addAttribute("type", TypObj);
		model.addAttribute("search", SeaObj);
		model.addAttribute("suche", new CiSearch());
		
		return "dashboard/record";
	}
	
	@PostMapping("/dashboard")
	public String searchSubmit(@ModelAttribute CiSearch suchobjekt, Model model) {		
		List<CiType> TypObj = manager.getCiTypeAll();
		List<String> SeaObj = manager.getSuchbegriffeAll();

		model.addAttribute("type", TypObj);
		model.addAttribute("search", SeaObj);
		model.addAttribute("suche", new CiSearch());
		model.addAttribute("ausgabe", suchobjekt.getSuchbegriff());
		
		return "suchergebnis";
	}
	
	
	@GetMapping(value = "/dashboard/{type}", consumes = { MediaType.ALL_VALUE }, produces = { MediaType.TEXT_HTML_VALUE })
	public String getRecordsByName(@PathVariable String type, Model model) {
		List<CiType> TypObj = manager.getCiTypeAll();
		List<CiRecord> RecObj = manager.getCiRecordByTyp(type);
		List<String> SeaObj = manager.getSuchbegriffeAll();

		
		model.addAttribute("type", TypObj);
		model.addAttribute("record", RecObj);
		model.addAttribute("id", type);
		model.addAttribute("search", SeaObj);
		model.addAttribute("suche", new CiSearch());

		return "dashboard/record";
	}
	
	@GetMapping(value = "/dashboard/{type}/{record}", consumes = { MediaType.ALL_VALUE }, produces = { MediaType.TEXT_HTML_VALUE })
	public String getAttributesByName(@PathVariable String type, @PathVariable String record, Model model) {
		List<CiType> TypObj = manager.getCiTypeAll();
		List<CiRecord> RecObj = manager.getCiRecordByTyp(type);
		List<Attribute> AttObj = manager.getAttributToRecord(Integer.parseInt(record));
		List<String> SeaObj = manager.getSuchbegriffeAll();
		
		model.addAttribute("type", TypObj);
		model.addAttribute("record", RecObj);
		model.addAttribute("id", type);
		model.addAttribute("attribute", AttObj);
		model.addAttribute("search", SeaObj);
		model.addAttribute("suche", new CiSearch());

		return "dashboard/attribute";
	}
}
