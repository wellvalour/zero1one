package com.gruppezwei.zero1one.controller;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
@Controller
public class userController {

	@GetMapping(value = "/profil", consumes = { MediaType.ALL_VALUE }, produces = { MediaType.TEXT_HTML_VALUE })
	public String getData(Model model) {

		
		return "profil2";
	}
	
	@GetMapping(value = "/hilfe", consumes = { MediaType.ALL_VALUE }, produces = { MediaType.TEXT_HTML_VALUE })
	public String getHelp(Model model) {

		
		return "hilfe";
	}
	
}
