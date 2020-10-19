package com.gruppezwei.zero1one.controller;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SecurityController {

	@GetMapping(value = "/login", consumes = { MediaType.ALL_VALUE }, produces = { MediaType.TEXT_HTML_VALUE })
	public String login(Model model) {
		return "login";
	}
}
