package bdgjmrsww.zero1one.controller;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UnserTestController {
	@GetMapping(value = "/ddb", consumes = { MediaType.ALL_VALUE }, produces = { MediaType.TEXT_HTML_VALUE })
	String test() {
		return "test";
	}
}
