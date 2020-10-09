package com.gruppezwei.zero1one.controller;

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

import com.gruppezwei.zero1one.manager.ServiceManager;

@SpringBootApplication
@Controller
public class HomeController {

//	/**
//	 * Als Beispiel wie Spring arbeitet
//	 * 
//	 * Anwendung(Zero1oneApplication) starten umd im Browser localhost:8080/hello
//	 * aufrufen * Nimmt Parameter in der URL entgegen in der Form ?name=Til
//	 * 
//	 * @param name
//	 * @return String
//	 */
//	@GetMapping(value = "/hello", consumes = { MediaType.ALL_VALUE }, produces = { MediaType.TEXT_PLAIN_VALUE })
//	public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
//		return String.format("Hello %s!", name);
//	}
//
//
//	/**
//	 * Und das ist das gleiche wie /home mit Thymleaf
//	 * 
//	 * @return komplett HTML-Seite aus templates
//	 */
//	@GetMapping(value = "/test", consumes = { MediaType.ALL_VALUE }, produces = { MediaType.TEXT_HTML_VALUE })
//	String test() {
//		return "test";
//	}
//
//	/**
//	 * Das Beispiel arbeit jetzt richtig mit Templates
//	 */
//	@GetMapping("/greeting")
//	public String greetingForm(Model model) {
//		model.addAttribute("greeting", new Greeting());
//		return "greeting";
//	}
//	
//	@PostMapping("/greeting")
//	public String greetingSubmit(@ModelAttribute Greeting greeting, Model model) {
//		model.addAttribute("greeting", greeting);
//		return "result";
//	}
	
	@Autowired
	ServiceManager manager;

	@GetMapping(value = "/dashboard", consumes = { MediaType.ALL_VALUE }, produces = { MediaType.TEXT_HTML_VALUE })
	public String getType(Model model) {
		List<UnserTestobjekt> testobj = manager.getConfigItemTypGanz();
		
		model.addAttribute("type", testobj);

		return "dashboard";
	}
	
//	@GetMapping(value = "/dashboard/{type}", consumes = { MediaType.ALL_VALUE }, produces = { MediaType.TEXT_HTML_VALUE })
//	public String getRecordsByType(@PathVariable("type") String type, Model model) {
//		List<UnserTestobjekt> testobj = manager.getConfigItemTypGanz();
//		List<UnserTestobjekt> testobject = manager.getConfigItemByName(type);
//		
//		model.addAttribute("type", testobj);
//		model.addAttribute("record", testobject);
//
//		return "dashboard";
//	}

//	@RequestMapping(value = "/dashboard", method = {RequestMethod.GET, RequestMethod.POST},
//					consumes = { MediaType.ALL_VALUE }, produces = { MediaType.TEXT_HTML_VALUE })
//	public String getRecordsBy(@RequestParam String type, Model model) {
//		List<UnserTestobjekt> testobj = manager.getConfigItemTypGanz();
//		List<UnserTestobjekt> testobject = manager.getConfigItemByName(type);
//		
//		model.addAttribute("type", testobj);
//		model.addAttribute("record", testobject);
//
//		return "dashboard";
//	}
//
	@GetMapping(value = "/dashboard/{type}", consumes = { MediaType.ALL_VALUE }, produces = { MediaType.TEXT_HTML_VALUE })
	public String getRecordsByName(@PathVariable String type, Model model) {
		List<UnserTestobjekt> testobj = manager.getConfigItemTypGanz();
		List<UnserTestobjekt> testobject = manager.getConfigItemByName(type);
		
		model.addAttribute("type", testobj);
		model.addAttribute("record", testobject);

		return "dashboard/record";
	}
//	
//	Methode für Unterseiten	
//	@GetMapping(value = "/dashboard/eins", consumes = { MediaType.ALL_VALUE }, produces = { MediaType.TEXT_HTML_VALUE })
//	public String gettype(Model model) {
//		List<UnserTestobjekt> testobj = manager.getUserGanz();
//		List<UnserTestobjekt> testobject = manager.getUserGanz();
//		
//		model.addAttribute("type", testobj);
//		model.addAttribute("record", testobject);
//
//		return "dashboard";
//	}
	


	
	
	
}
