package com.gruppezwei.zero1one.controller;

import java.util.ArrayList;
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

import com.gruppezwei.zero1one.manager.AuthenticationManager;
import com.gruppezwei.zero1one.manager.ReadManager;

@SpringBootApplication
@Controller
public class userController {

	@Autowired
	AuthenticationManager user;
	
	@Autowired
	ReadManager lesen;
	
	@GetMapping(value = "/profil", consumes = { MediaType.ALL_VALUE }, produces = { MediaType.TEXT_HTML_VALUE })
	public String getData(Model model) {

		if(user.getUserByName(HomeController.getUser()).get(0).getBerechtigungsID() == 1) {
			
			String nameAlt = HomeController.getUser();
			Name nameObj = new Name();
			nameObj.setNameAlt(HomeController.getUser());
			
			Passwort PWObj = new Passwort();
			
			model.addAttribute("nameAlt", nameAlt);
			model.addAttribute("nameObj", nameObj);
			model.addAttribute("PWObj", PWObj);
			
		}else {
			Name nameObj = new Name();
			nameObj.setNameAlt(HomeController.getUser());
			
			Passwort PWObj = new Passwort();
			
			model.addAttribute("nameObj", nameObj);
			model.addAttribute("PWObj", PWObj);

		}
		
		return "profil2";
	}
	
	@PostMapping(value = "/profil/Name-Aendern", consumes = { MediaType.ALL_VALUE }, produces = { MediaType.TEXT_HTML_VALUE })
	public String getAttributeToType(@ModelAttribute Name nameObj, Model model) {
		
		
		if(nameObj.getNameNeu().isEmpty()) {
			//throw Exception möglich
			List<CiType> TypObj = lesen.getCiTypeAll();
			List<CiRecord> SeaListRec = lesen.getCiRecordAll();

			model.addAttribute("type", TypObj);
			model.addAttribute("suchliste", SeaListRec);
			model.addAttribute("suche", new CiSearch());
			
		}else {
			user.changeUsername(HomeController.getUser(), nameObj.getNameNeu());
			HomeController.setUser(nameObj.getNameNeu());
		
			List<CiType> TypObj = lesen.getCiTypeAll();
			List<CiRecord> SeaListRec = lesen.getCiRecordAll();
	
			model.addAttribute("type", TypObj);
			model.addAttribute("suchliste", SeaListRec);
			model.addAttribute("suche", new CiSearch());
		}
		return "dashboard/record";
	}
	
	@GetMapping(value = "/hilfe", consumes = { MediaType.ALL_VALUE }, produces = { MediaType.TEXT_HTML_VALUE })
	public String getHelp(Model model) {

		
		return "hilfe";
	}
	
}
