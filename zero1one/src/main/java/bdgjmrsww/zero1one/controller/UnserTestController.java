package bdgjmrsww.zero1one.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import bdgjmrsww.zero1one.manager.ServiceManager;
import bdgjmrsww.zero1one.manager.ServiceManagerMitarbeiter;

@Controller
public class UnserTestController {
	@Autowired
	ServiceManagerMitarbeiter manager;
	
	@Autowired
	ServiceManager manager2;
	
	@GetMapping(value = "/nachname", consumes = { MediaType.ALL_VALUE }, produces = { MediaType.TEXT_HTML_VALUE })
	public String test(Model model) {
		List<UnserTestobjekt> testobj = manager.getMitarbeiterByName("Maier");
		
		model.addAttribute("unserTestTemplate", testobj);

		return "unserTestTemplate";
	}
	
	@GetMapping(value = "/mitarbeiter", consumes = { MediaType.ALL_VALUE }, produces = { MediaType.TEXT_HTML_VALUE })
	public String getMitarbeiterGanz(Model model) {
		List<UnserTestobjekt> testobj = manager.getMitarbeiterGanz();
		
		model.addAttribute("unserTestTemplate", testobj);

		return "unserTestTemplate";
	}
	
	@GetMapping(value = "/instanz", consumes = { MediaType.ALL_VALUE }, produces = { MediaType.TEXT_HTML_VALUE })
	public String getInstanzGanz(Model model) {
		List<UnserTestobjekt> testobj = manager2.getInstanzGanz();
		
		model.addAttribute("unserTestTemplate", testobj);

		return "unserTestTemplate";
	}
}
