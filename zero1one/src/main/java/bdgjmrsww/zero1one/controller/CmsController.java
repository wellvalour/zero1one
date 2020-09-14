package bdgjmrsww.zero1one.controller;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class CmsController {
	
	/**
	 * Anwendung(Zero1oneApplication) starten umd im Browser localhost:8080/hello aufrufen
	 * * Nimmt Parameter in der URL entgegen in der Form ?name=Til
	 * @param name
	 * @return
	 */
	@GetMapping(value="/hello", consumes = { MediaType.ALL_VALUE}, produces = { MediaType.TEXT_PLAIN_VALUE}) 
	public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
		return String.format("Hello %s!", name);
	}
}
