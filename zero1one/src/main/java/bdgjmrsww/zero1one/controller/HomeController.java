package bdgjmrsww.zero1one.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@SpringBootApplication
@Controller
public class HomeController {

	/**
	 * Als Beispiel wie Spring arbeitet
	 * 
	 * Anwendung(Zero1oneApplication) starten umd im Browser localhost:8080/hello
	 * aufrufen * Nimmt Parameter in der URL entgegen in der Form ?name=Til
	 * 
	 * @param name
	 * @return
	 */
	@GetMapping(value = "/hello", consumes = { MediaType.ALL_VALUE }, produces = { MediaType.TEXT_PLAIN_VALUE })
	public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
		return String.format("Hello %s!", name);
	}

	/**
	 * Beispiel wie man einfach ne HTML audgibt...ist halt statisch
	 * 
	 * @return
	 * @throws IOException
	 */
	@GetMapping(value = "/home", consumes = { MediaType.ALL_VALUE }, produces = { MediaType.TEXT_HTML_VALUE })
	public String showHomePage() throws IOException {
		File file = new File("src/main/resources/templates/test.html");
		BufferedReader br = new BufferedReader(new FileReader(file));

		String st, result = "";
		while ((st = br.readLine()) != null) {
			result = result + st;
		}
		br.close();
		return result;
	}

	/**
	 * Und das ist das gleiche wie /home mit Thymleaf
	 * @return
	 */
	@GetMapping("/test")
	String test() {
		return "test";
	}

}
