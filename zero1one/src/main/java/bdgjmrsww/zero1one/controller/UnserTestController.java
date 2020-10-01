package bdgjmrsww.zero1one.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import bdgjmrsww.zero1one.manager.ServiceManager;

@Controller
public class UnserTestController {
	@Autowired
	ServiceManager manager;
	
	@GetMapping(value = "/template", consumes = { MediaType.ALL_VALUE }, produces = { MediaType.TEXT_HTML_VALUE })
	public String test(Model model) {
		List<UnserTestobjekt> testobj = manager.getMitarbeiter();
		
		model.addAttribute("unserTestTemplate", testobj);

		return "unserTestTemplate";
	}
}
