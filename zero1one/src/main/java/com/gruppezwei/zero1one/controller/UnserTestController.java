package com.gruppezwei.zero1one.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.gruppezwei.zero1one.manager.ServiceManager;


@Controller
public class UnserTestController {
	
	@Autowired
	ServiceManager manager;
	
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
	public String getConfigItemTYpGanz(Model model) {
		List<UnserTestobjekt> testobj = manager.getConfigItemTypGanz();
		
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
