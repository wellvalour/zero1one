package com.gruppezwei.zero1one.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.MediaType;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.gruppezwei.zero1one.manager.ReadManager;


/**
 * Controller für das Dashboard und die Unterseiten.
 * Ermöglicht die Navigation zwischen Dashboard, Ci-Typen, Ci-Record und implementiert die Suche auf diesen Seiten.
 *
 */

@SpringBootApplication
@Controller
public class HomeController {

	@Autowired
	ReadManager lesen;
	
	@GetMapping(value = "/dashboard", consumes = { MediaType.ALL_VALUE }, produces = { MediaType.TEXT_HTML_VALUE })
	public String getType(Model model) {
		
		String user = SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();
		
		List<CiType> TypObj = lesen.getCiTypeAll();
		List<CiRecord> SeaListRec = lesen.getCiRecordAll();

		model.addAttribute("type", TypObj);
		model.addAttribute("suchliste", SeaListRec);
		model.addAttribute("suche", new CiSearch());
		model.addAttribute("name", user);
		
		return "dashboard/record";
	}
	
	@PostMapping("/dashboard")
	public String searchSubmit(@ModelAttribute CiSearch suchobjekt, Model model) {	
		
		String user = SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();
		
		List<CiType> TypObj = lesen.getCiTypeAll();
		List<CiRecord> SeaListRec = lesen.getCiRecordAll();
		List<Attribute> neuListAtt = lesen.getAttributToRecord(suchobjekt.getId());
		List<CiRecord> RecObjList = lesen.getCiRecordByID(suchobjekt.getId());
		CiRecord RecObj = lesen.getSingleCiRecordByID(suchobjekt.getId());
		
		model.addAttribute("type", TypObj);
		model.addAttribute("record", RecObjList);
		model.addAttribute("id", suchobjekt.getId());
		model.addAttribute("attribute", neuListAtt);
		model.addAttribute("RecObj", RecObj);
		model.addAttribute("suchliste", SeaListRec);
		model.addAttribute("suche", new CiSearch());
		model.addAttribute("name", user);
		
		return "dashboard/attribute";
	}
	
	
	@GetMapping(value = "/dashboard/{type}", consumes = { MediaType.ALL_VALUE }, produces = { MediaType.TEXT_HTML_VALUE })
	public String getRecordsByName(@PathVariable String type, Model model) {
		
		String user = SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();
		
		List<CiType> TypObj = lesen.getCiTypeAll();
		List<CiRecord> RecObj = lesen.getCiRecordByTyp(type);
		List<CiRecord> SeaListRec = lesen.getCiRecordAll();
		
		model.addAttribute("type", TypObj);
		model.addAttribute("record", RecObj);
		model.addAttribute("id", type);
		model.addAttribute("suchliste", SeaListRec);
		model.addAttribute("suche", new CiSearch());
		model.addAttribute("name", user);
		
		return "dashboard/record";
	}
	
	@GetMapping(value = "/dashboard/{type}/{record}", consumes = { MediaType.ALL_VALUE }, produces = { MediaType.TEXT_HTML_VALUE })
	public String getAttributesByName(@PathVariable String type, @PathVariable String record, Model model) {
		
		String user = SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();
		
		List<CiType> TypObj = lesen.getCiTypeAll();
		List<CiRecord> RecObjList = lesen.getCiRecordByTyp(type);
		List<Attribute> AttObj = lesen.getAttributToRecord(Integer.parseInt(record));
		List<CiRecord> RecObjListTemp = lesen.getCiRecordByID(Integer.parseInt(record));
		CiRecord RecObj = RecObjListTemp.get(0);
		List<CiRecord> SeaListRec = lesen.getCiRecordAll();
		
		model.addAttribute("type", TypObj);
		model.addAttribute("record", RecObjList);
		model.addAttribute("id", type);
		model.addAttribute("attribute", AttObj);
		model.addAttribute("RecObj", RecObj);
		model.addAttribute("suchliste", SeaListRec);
		model.addAttribute("suche", new CiSearch());
		model.addAttribute("name", user);

		return "dashboard/attribute";
	}
}
