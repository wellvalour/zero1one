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

		
		CiRecord RecObjOut = lesen.getSingleCiRecordByID(Integer.parseInt(record));
		ZwischenspeicherObj = RecObjOut;
		String Uname = HomeController.getUser();

		model.addAttribute("RecObj", RecObjOut);
		model.addAttribute("name", Uname);

		return "ci-record-aendern";
	}
	
	@PostMapping(value = "/ci-record-aendern-submit", consumes = { MediaType.ALL_VALUE }, produces = { MediaType.TEXT_HTML_VALUE })
	public String persitAttribute(@ModelAttribute CiRecord RecObjOut, Model model) {
		
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
		String Uname = HomeController.getUser();

		model.addAttribute("type", TypObj);
		model.addAttribute("suchliste", SeaListRec);
		model.addAttribute("suche", new CiSearch());
		model.addAttribute("name", Uname);
		
		return "dashboard/record";
	}
	
	
//	@GetMapping(value = "/ci-record-aendern-Att/{record}", consumes = { MediaType.ALL_VALUE }, produces = { MediaType.TEXT_HTML_VALUE })
//	public String getNewAttributes(@PathVariable String record, Model model) {
//
//		
//		List<CiRecord> RecObjList = lesen.getCiRecordByID(Integer.parseInt(record));
//		CiRecord RecObjOut = RecObjList.get(0);
//		RecObjOut.getAttribute().add(new Attribute());
//		int laenge = RecObjOut.getAttribute().size();
//		CiRecord RecObjIn = new CiRecord();
//		List<Attribute> neuAttList = new ArrayList<Attribute>();
//		for(int i=0; i< laenge; i++) {
//			Attribute neuAtt = new Attribute();
//			neuAttList.add(neuAtt);
//		}
//		RecObjIn.setAttribute(neuAttList);
//		
//		ZwischenspeicherObj = RecObjOut;
//		
//		model.addAttribute("RecObj", RecObjOut);
//		model.addAttribute("RecObjIn", RecObjIn);
//
//		return "ci-record-aendern-Att";
//	}
//	
//	
//	@PostMapping(value = "/ci-record-aendern-Att-submit", consumes = { MediaType.ALL_VALUE }, produces = { MediaType.TEXT_HTML_VALUE })
//	public String neuesAttribute(@ModelAttribute CiRecord RecObjIn, Model model) {
//
//		List<Attribute> alteAtt = ZwischenspeicherObj.getAttribute();
//		List<Attribute> neueAtt = RecObjIn.getAttribute();
//			for(int i=0; i<neueAtt.size();i++) {
//				if(neueAtt.get(i).getWert() == null){
//					neueAtt.set(i, alteAtt.get(i));
//				}
//			}
//			RecObjIn.setAttribute(neueAtt);
//			if(RecObjIn.getName() == null) {
//				RecObjIn.setName(ZwischenspeicherObj.getName());
//			}
//			RecObjIn.setCiTyp(ZwischenspeicherObj.getCiTyp());
//			RecObjIn.setId(ZwischenspeicherObj.getId());
//			ZwischenspeicherObj=RecObjIn;
//			List<CiRecord> RecObjList = new ArrayList<CiRecord>();
//			RecObjList.add(RecObjIn);
//			update.updateConfigItemMitAttributen(RecObjList);
//
//			ZwischenspeicherObj.getAttribute().add(new Attribute());
//			int laenge = ZwischenspeicherObj.getAttribute().size();
//			CiRecord RecObjnewIn = new CiRecord();
//			List<Attribute> neuAttList = new ArrayList<Attribute>();
//			for(int i=0; i< laenge; i++) {
//				Attribute neuAtt = new Attribute();
//				neuAttList.add(neuAtt);
//			}
//			RecObjnewIn.setAttribute(neuAttList);
//		
//		CiRecord RecObjOut = ZwischenspeicherObj;
//
//		model.addAttribute("RecObj", RecObjOut);
//		model.addAttribute("RecObjIn", RecObjnewIn);
//
//
//		return "ci-record-aendern-Att";
//	}
	
	@GetMapping(value = "/ci-record-loeschen/{record}", consumes = { MediaType.ALL_VALUE }, produces = { MediaType.TEXT_HTML_VALUE })
	public String deleteRecord(@PathVariable String record, Model model) {

		loeschen.deleteCiRecord(Integer.parseInt(record));
		List<CiType> TypObj = lesen.getCiTypeAll();
		List<CiRecord> SeaListRec = lesen.getCiRecordAll();
		String Uname = HomeController.getUser();

		model.addAttribute("type", TypObj);
		model.addAttribute("suchliste", SeaListRec);
		model.addAttribute("suche", new CiSearch());
		model.addAttribute("name", Uname);
		
		return "dashboard/record";
	}
	
	@PostMapping(value = "/ci-typ-loeschen", consumes = { MediaType.ALL_VALUE }, produces = { MediaType.TEXT_HTML_VALUE })
	public String deleteTyp(@ModelAttribute CiSearch suchobjekt , Model model) {

		loeschen.deleteCiType(suchobjekt.getSuchbegriff());
		List<CiType> TypObj = lesen.getCiTypeAll();
		List<CiRecord> SeaListRec = lesen.getCiRecordAll();
		String Uname = HomeController.getUser();

		model.addAttribute("type", TypObj);
		model.addAttribute("suchliste", SeaListRec);
		model.addAttribute("suche", new CiSearch());
		model.addAttribute("name", Uname);
		
		return "dashboard/record";
	}
}
