package com.gruppezwei.zero1one.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

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
	
	@GetMapping(value = "/ci-record-aendern/{record}", consumes = { MediaType.ALL_VALUE }, produces = { MediaType.TEXT_HTML_VALUE })
	public String getAttributesByName(@PathVariable String record, Model model) {
		System.out.println(record);
		List<CiRecord> RecObjList = lesen.getCiRecordByID(Integer.parseInt(record));
		CiRecord RecObj = RecObjList.get(0);
//		List<Attribute> AttObj = lesen.getAttributToRecord(Integer.parseInt(record));

		model.addAttribute("RecObj", RecObj);
//		model.addAttribute("AttObj", RecObj);
//		model.addAttribute("id", type);


		return "ci-record-aendern";
	}
	
	
}
