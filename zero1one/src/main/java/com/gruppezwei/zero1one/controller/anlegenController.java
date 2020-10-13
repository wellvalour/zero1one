package com.gruppezwei.zero1one.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.gruppezwei.zero1one.manager.PersistenceManager;

/**
 * Controller für die Seiten Ci-Typ und Ci-Record.
 * Ermöglicht das anlegen von Typen und Records.
 *
 */


@SpringBootApplication
@Controller
public class anlegenController {

	@Autowired
	PersistenceManager manager;
	
	@GetMapping(value = "/ci-typ", consumes = { MediaType.ALL_VALUE }, produces = { MediaType.TEXT_HTML_VALUE })
	public String setType(Model model) {

		
		return "ci-typ";
	}
	
	@GetMapping(value = "/ci-record", consumes = { MediaType.ALL_VALUE }, produces = { MediaType.TEXT_HTML_VALUE })
	public String setRecord(Model model) {

		
		return "ci-record";
	}
}
