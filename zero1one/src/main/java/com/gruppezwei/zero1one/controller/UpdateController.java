package com.gruppezwei.zero1one.controller;

import java.util.ArrayList;
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

import com.gruppezwei.zero1one.manager.DeleteManager;
import com.gruppezwei.zero1one.manager.PersistenceManager;
import com.gruppezwei.zero1one.manager.ReadManager;
import com.gruppezwei.zero1one.manager.UpdateManager;


@SpringBootApplication
@Controller
public class UpdateController {

	@Autowired
	PersistenceManager speichern;
	
	@Autowired
	ReadManager lesen;
	
	@Autowired
	DeleteManager loeschen;
	
	@Autowired
	UpdateManager update;
	
	CiRecord ZwischenspeicherObj = new CiRecord();
	
	@GetMapping(value = "/ci-record-aendern/{record}", consumes = { MediaType.ALL_VALUE }, produces = { MediaType.TEXT_HTML_VALUE })
	public String getAttributesByName(@PathVariable String record, Model model) {

		String user = SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();
		
		CiRecord RecObjOut = lesen.getSingleCiRecordByID(Integer.parseInt(record));
		ZwischenspeicherObj = RecObjOut;

		model.addAttribute("RecObj", RecObjOut);
		model.addAttribute("name", user);

		return "ci-record-aendern";
	}
	
	@PostMapping(value = "/ci-record-aendern-submit", consumes = { MediaType.ALL_VALUE }, produces = { MediaType.TEXT_HTML_VALUE })
	public String persitAttribute(@ModelAttribute CiRecord RecObjOut, Model model) {
		
		String user = SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();
		
		List<Attribute> neueAtt = RecObjOut.getAttribute();
			for(int i=0; i<ZwischenspeicherObj.getAttribute().size();i++) {
					ZwischenspeicherObj.getAttribute().get(i).setWert(neueAtt.get(i).getWert());
			}
			
			if(RecObjOut.getName() != null) {
				ZwischenspeicherObj.setName(RecObjOut.getName());
			}
			
			List<CiRecord> RecObjList = new ArrayList<CiRecord>();
			RecObjList.add(ZwischenspeicherObj);
			update.updateConfigItemMitAttributen(RecObjList);

		ZwischenspeicherObj=null;
		
		List<CiType> TypObj = lesen.getCiTypeAll();
		List<CiRecord> SeaListRec = lesen.getCiRecordAll();

		model.addAttribute("type", TypObj);
		model.addAttribute("suchliste", SeaListRec);
		model.addAttribute("suche", new CiSearch());
		model.addAttribute("name", user);
		
		return "dashboard/record";
	}
	
	@GetMapping(value = "/ci-record-loeschen/{record}", consumes = { MediaType.ALL_VALUE }, produces = { MediaType.TEXT_HTML_VALUE })
	public String deleteRecord(@PathVariable String record, Model model) {
		
		String user = SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();

		loeschen.deleteCiRecord(Integer.parseInt(record));
		List<CiType> TypObj = lesen.getCiTypeAll();
		List<CiRecord> SeaListRec = lesen.getCiRecordAll();

		model.addAttribute("type", TypObj);
		model.addAttribute("suchliste", SeaListRec);
		model.addAttribute("suche", new CiSearch());
		model.addAttribute("name", user);
		
		return "dashboard/record";
	}
	
	@PostMapping(value = "/ci-typ-loeschen", consumes = { MediaType.ALL_VALUE }, produces = { MediaType.TEXT_HTML_VALUE })
	public String deleteTyp(@ModelAttribute CiSearch suchobjekt , Model model) {
		
		String user = SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();

		loeschen.deleteCiType(suchobjekt.getSuchbegriff());
		List<CiType> TypObj = lesen.getCiTypeAll();
		List<CiRecord> SeaListRec = lesen.getCiRecordAll();

		model.addAttribute("type", TypObj);
		model.addAttribute("suchliste", SeaListRec);
		model.addAttribute("suche", new CiSearch());
		model.addAttribute("name", user);
		
		return "dashboard/record";
	}
}
